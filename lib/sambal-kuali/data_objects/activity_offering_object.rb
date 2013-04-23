# stores test data for creating/editing and validating activity offerings and provides convenience methods for navigation and data entry
#
# ActivityOffering objects contain the following objects: SeatPool, DeliveryLogistic (requested and actual) and Personnel (Affiliated Personnel)
#
# ActivityOffering is a child of a CourseOffering
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#  @activity_offering = make ActivityOffering, [:seat_pool_list => {},...]
#  @activity_offering.create
# OR alternatively 2 steps together as
#  @activity_offering = create ActivityOffering, [:seat_pool_list => {},...]
# Note the use of the ruby options hash pattern re: setting attribute values
class ActivityOffering
  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows
  include Comparable

  #type: string generally set using options hash
  attr_accessor :code,
                :format,
                :activity_type,
                :max_enrollment,
                :seat_remaining_percent,
                :course_url,
                :aoc_private_name
  #type: hash - generally set using options hash
  attr_accessor :actual_delivery_logistics_list,
                :requested_delivery_logistics_list,
                :seat_pool_list
  #array - generally set using options hash
  attr_accessor :personnel_list,
                :colocate_ao_list
  #boolean - generally set using options hash
  attr_accessor :evaluation,
                :honors_course,
                :create_by_copy,
                :colocate_shared_enrollment
  #type ActivityOffering object - generally set using options hash
  attr_accessor :parent_course_offering


  # provides default data:
  #
  #  defaults = {
  #    :parent_course_offering => ""
  #    :format => "Lecture Only",
  #    :activity_type => "Lecture",
  #    :max_enrollment => 100,
  #    :actual_delivery_logistics_list => {},
  #    :requested_delivery_logistics_list => {} ,
  #    :personnel_list => [],
  #    :seat_pool_list => {} ,
  #    :course_url => "www.test_course.com",
  #    :evaluation => true,
  #    :honors_course => true,
  #    :colocate_ao_list => [],
  #    :colocate_shared_enrollment => false
  #  }
  # some basic e.g. list/hash values:
  # :seat_pool_list =>  {"random"=> (make SeatPool)}
  # :requested_delivery_logistics_list => {"default"=> (make DeliveryLogistics)}
  # :personnel_list => Array.new(1){make Personnel}
  # :colocate_ao_list => Array.new(1){make ActivityOffering}

  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    # :seat_pool_list =  {"random"=> (make SeatPool)}
    # :requested_delivery_logistics_list = {"default"=> (make DeliveryLogistics)}
    # :personnel_list => [] -- Array.new(1){make Personnel}

    defaults = {
        :parent_course_offering => (make CourseOffering),
        :format => "Lecture Only",
        :activity_type => "Lecture",
        :max_enrollment => 100,
        :actual_delivery_logistics_list => {},
        :requested_delivery_logistics_list => {},
        :personnel_list => [] ,
        :seat_pool_list => {},
        :course_url => "www.test_course.com",
        :evaluation => true,
        :honors_course => true,
        :aoc_private_name => :default_cluster,
        :create_by_copy => nil, #if true create copy using :ao_code
        :colocate_ao_list => [],
        :colocate_shared_enrollment => false
    }

    options = defaults.merge(opts)

    @format = options[:format]
    @activity_type = options[:activity_type]

    set_options(options)

  end

  def <=>(other)
    @code <=> other.code
  end

  #navigates to activity offering edit page and sets up activity offering based on class attributes
  def create
    @parent_course_offering.manage

    if @create_by_copy then
      on ManageCourseOfferings do |page|
        pre_copy_list = page.get_cluster_assigned_ao_list(@aoc_private_name)
        page.copy(@code, @aoc_private_name)
        post_copy_list = page.get_cluster_assigned_ao_list(@aoc_private_name)
        @code = (post_copy_list - pre_copy_list).first
        return
      end
    end

    on ManageCourseOfferings do |page|
      pre_add_ao_list = page.codes_list
      post_add_ao_list = []
      #if page.codes_list.length == 0
      sleep 2
      page.add_activity
      page.format.select @format
      page.loading.wait_while_present
      sleep 2
      page.activity_type.select @activity_type
      page.quantity.set "1"
      page.complete_add_activity
      post_add_ao_list = page.codes_list
      #end
      new_code =  post_add_ao_list - pre_add_ao_list
      @code = new_code[0]
    end

    init = {
        :max_enrollment => @max_enrollment,
        :actual_delivery_logistics_list => @actual_delivery_logistics_list,
        :requested_delivery_logistics_list => @requested_delivery_logistics_list,
        :personnel_list => @personnel_list ,
        :seat_pool_list => @seat_pool_list,
        :course_url => @course_url,
        :evaluation => @evaluation,
        :honors_course => @honors_course,
        :colocate_ao_list => @colocate_ao_list,
        :colocate_shared_enrollment => @colocate_shared_enrollment
    }

    edit(init)
  end

  def init_existing(ao_table_row, parent_co)
    @code =  ao_table_row.cells[ManageCourseOfferings::AO_CODE].text
    @activity_type = ao_table_row.cells[ManageCourseOfferings::AO_TYPE].text
    @parent_course_offering = parent_co
  end

  #navigates activity offering edit page and updates activity offering based on class attributes
  # @example - must always call save
  #  @activity_offering.edit :honors_course=> true
  #  @activity_offering.save
  #
  # NB: 'save' is a separate step from edit as it allows validation steps to occur during the edit process
  #
  # @param opts [Hash] key => value for attribute to be updated
  def edit opts={}

    on(ManageCourseOfferings).edit @code

    edit_colocation opts
    edit_max_enrollment_no_colocation opts
    edit_requested_delivery_logistics opts
    edit_course_url opts
    edit_evaluation opts
    edit_honors_course opts
    edit_personnel_list opts
    edit_seat_pool_list opts

  end #END: edit

  # PRIVATE helper methods for edit()

      def edit_colocation opts={}

        is_breaking_colocation = false
        if !opts[:break_colocation].nil? # only test for nil; true/false map to 'confirm/cancel'
          is_breaking_colocation = true
        end

        is_editing_colocation = false
        if !opts[:colocate_ao_list].nil? && !opts[:colocate_ao_list].empty?
          is_editing_colocation = true
        end

        # cannot both EDIT and BREAK the colo simultaneously
        if is_breaking_colocation && is_editing_colocation
          raise "Cannot both EDIT and BREAK a colocation simultaneously"
        end

        if is_breaking_colocation
          edit_break_colocation opts
          return nil
        end

        # else perform normal EDIT
        on ActivityOfferingMaintenance do |page|
          page.select_colocated_checkbox

          # add the colo-COs to this CO
          opts[:colocate_ao_list].each do |ao_to_colo|
            page.colocated_co_input_field.value = ao_to_colo.parent_course_offering.course
            page.colocated_ao_input_field.value = ao_to_colo.code
            page.add_colocated
          end

          if opts[:colocate_shared_enrollment]
            page.select_separately_manage_enrollment_radio #toggling to this and back is required or an error generates on submit
            page.select_jointly_share_enrollment_radio
            page.colocated_shared_max_enrollment_input_field.value = opts[:max_enrollment]
          else # ie: 'separately manage'
            page.select_separately_manage_enrollment_radio
            page.colocated_shared_max_enrollment_table_first_ao_input.value = opts[:max_enrollment]
          end
        end

      end #END: edit_colocation

      def edit_break_colocation opts={}

        @browser.confirm( opts[:break_colocation] ) {
          on(ActivityOfferingMaintenance).select_colocated_checkbox
        }

      end #END: edit_break_colocation

      def edit_max_enrollment_no_colocation opts={}

        if opts[:colocate_ao_list] && !opts[:colocate_ao_list].empty?
          return nil
        end

        if opts[:max_enrollment] != nil
          on ActivityOfferingMaintenance do |page|
            page.total_maximum_enrollment.set opts[:max_enrollment]
            page.total_maximum_enrollment.fire_event "onchange"
            @max_enrollment = opts[:max_enrollment]
          end
        end

      end #END: edit_max_enrollment_no_colocation

      def edit_requested_delivery_logistics opts={}

        if opts[:requested_delivery_logistics_list].nil? || opts[:requested_delivery_logistics_list].empty?
          return nil
        end

        #'save' vs 'save and process' determined by first rdl
        first_rdl = opts[:requested_delivery_logistics_list].values[0]
        #list of requests added with updated keys
        requests_added = {}

        opts[:requested_delivery_logistics_list].values.each do |request|
          request.create
          requests_added["#{request.days}#{request.start_time}#{request.start_time_ampm.upcase}".delete(' ')] = request
        end

      end #END: edit_request_delivery_logistics

      def edit_course_url opts={}

        if opts[:course_url].nil?
          return nil
        end

        on(ActivityOfferingMaintenance).course_url.set opts[:course_url]
        @course_url = opts[:course_url]

      end #END: edit_course_url

      def edit_evaluation opts={}

        if opts[:evaluation].nil?
          return nil
        end

        on ActivityOfferingMaintenance do |page|
          if opts[:evaluation]
            page.requires_evaluation.set
          else
            page.requires_evaluation.clear
          end
        end

        @evaluation =  opts[:evaluation]

      end #END: edit_evaluation

      def edit_honors_course opts={}

        if opts[:honors_course].nil?
          return nil
        end

        on ActivityOfferingMaintenance do |page|
          if opts[:honors_course]
            page.honors_flag.set
          else
            page.honors_flag.clear
          end
        end

        @honors_course = opts[:honors_course]

      end #END: edit_honors_course

      def edit_personnel_list opts={}

        if opts[:personnel_list].nil?
          return nil
        end

        opts[:personnel_list].each do |person|
          person.add_personnel
        end

        @personnel_list = opts[:personnel_list]

      end #END: edit_personnel_list

      def edit_seat_pool_list opts={}

        if opts[:seat_pool_list].nil?
          return nil
        end

        opts[:seat_pool_list].each do |key,seat_pool|
          seat_pool.add_seatpool(seatpool_populations_used)
          @seat_pool_list[key] = seat_pool unless !seat_pool.exp_add_succeed?
        end

      end #END: edit_seat_pool_list

  private :edit_colocation,
          :edit_break_colocation,
          :edit_max_enrollment_no_colocation,
          :edit_requested_delivery_logistics,
          :edit_course_url,
          :edit_evaluation,
          :edit_honors_course,
          :edit_personnel_list,
          :edit_seat_pool_list

  #completes activity offering edit operation
  #this is a separate step from edit as it allows validation steps to occur during the edit process
  def save()
puts 'save'
    on ActivityOfferingMaintenance do |page|
      page.submit
    end
  end

  #calculates the expected number of seats remaining
  #
  #@return [int] expected number of seats remaining
  def seats_remaining
    seats_used = 0
    @seat_pool_list.each do |key,seat_pool|
      seats_used += seat_pool.seats.to_i
    end
    [@max_enrollment - seats_used , 0].max
  end

  #removes seatpool from activity offering
  #
  #@param [string] seat_pool_list hash key
  def remove_seatpool(seatpool_key)
    on ActivityOfferingMaintenance do |page|
      page.remove_seatpool(@seat_pool_list[seatpool_key].population_name)
    end
    @seat_pool_list.delete(seatpool_key)
  end

  #removes all seatpools from activity offering
  def remove_seatpools()
    @seat_pool_list.each do |seatpool_key|
      if @seat_pool_list[seatpool_key].remove
        on ActivityOfferingMaintenance do |page|
          page.remove_seatpool(@seat_pool_list[seatpool_key].population_name)
        end
        @seat_pool_list.delete(seatpool_key)
      end
    end
  end

  # updates the value in @seatpool.priority with @seatpool.priority_after_reseq for each seatpool
  #
  # e.g. after removing the seatpool with priory 1, the seatpool with priority 2 becomes priority 1
  def resequence_expected_seatpool_priorities()
    @seat_pool_list.values.each do |seatpool|
      seatpool.priority = seatpool.priority_after_reseq
    end
  end

  #while on activity offering edit page and updates the details for a specific seatpool
  # @example - must always call save
  #  @activity_offering.edit :honors_course=> true
  #  @activity_offering.edit_seatpool :seats => 2
  #  @activity_offering.save
  #
  # NB: 'save' is a separate step from edit as it allows validation steps to occur during the edit process
  #
  # @param opts [Hash] key => value for attribute to be updated
  def edit_seatpool opts = {}

    sp_key = opts[:seatpool_key]
    sp_key = @seat_pool_list.keys[0] unless sp_key != nil

    defaults = {
        :priority => @seat_pool_list[sp_key].priority,
        :seats => @seat_pool_list[sp_key].seats,
        :expiration_milestone => @seat_pool_list[sp_key].expiration_milestone,
        :remove => false,
        :priority_after_reseq => @seat_pool_list[sp_key].priority_after_reseq
    }
    options=defaults.merge(opts)
    update_pop_name = @seat_pool_list[sp_key].population_name

    on ActivityOfferingMaintenance do |page|
      page.update_seats(update_pop_name, options[:seats])
      @seat_pool_list[sp_key].seats = options[:seats]
    end

    if options[:priority] != @seat_pool_list[sp_key].priority
      on ActivityOfferingMaintenance do |page|
        page.update_priority(update_pop_name,options[:priority])
        @seat_pool_list[sp_key].priority = options[:priority]
      end
    end

    if options[:expiration_milestone] != @seat_pool_list[sp_key].expiration_milestone
      on ActivityOfferingMaintenance do |page|
        page.update_expiration_milestone(update_pop_name,options[:expiration_milestone])
        @seat_pool_list[sp_key].expiration_milestone = options[:expiration_milestone]
      end
    end

    if options[:priority_after_reseq] != @seat_pool_list[sp_key].priority_after_reseq
      @seat_pool_list[sp_key].priority_after_reseq = options[:priority_after_reseq]
    end

    #remove has to be last...
    if options[:remove]
      on ActivityOfferingMaintenance do |page|
        page.remove_seatpool(update_pop_name)
        @seat_pool_list.delete(sp_key)
      end
    end
  end

  #returns a list of populations used in the AO seatpool
  #
  # @returns [Array] list of population names
  def seatpool_populations_used
    populations_used = []
    @seat_pool_list.values.each do |seatpool|
      populations_used << seatpool.population_name
    end
    populations_used
  end

end

# stoes test data for creating/editing and validating seatpool and provides convenience methods for navigation and data entry
#
# SeatPool is a child of a ActivityOffering
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
# seatpool_hash[1] = make SeatPool, :population_name => "Core", :seats => 10, :priority => 2, :priority_after_reseq => 2
#
# @activity_offering = create ActivityOffering, :seat_pool_list => seatpool_hash
#
#create generally called from ActivityOffering class
# Note the use of the ruby options hash pattern re: setting attribute values
class SeatPool

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows
  include PopulationsSearch

  #generally set using options hash
  attr_accessor :priority,
                :seats,
                :population_name,
                :expiration_milestone,
                :remove,
                :priority_after_reseq,
                :exp_add_succeed

  alias_method :remove?, :remove
  alias_method :exp_add_succeed?, :exp_add_succeed

  # provides default data:
  #defaults = {
  #    :priority => 1,
  #    :seats => 10,
  #    :population_name => "random",
  #    :expiration_milestone => "First Day of Classes",
  #    :remove => false,
  #    :priority_after_reseq => 0,
  #    :exp_add_succeed => true
  #}
  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :priority => 1,
        :seats => 10,
        :population_name => "random",
        :expiration_milestone => "First Day of Classes",
        :remove => false,
        :priority_after_reseq => 0,
        :exp_add_succeed => true
    }
    options = defaults.merge(opts)
    options[:priority_after_reseq] = options[:priority] unless options[:priority_after_reseq] != 0
    set_options(options)

  end

  #calculates expected % of total enrollment for the seatpool
  #
  # @returns [int] expected % of total enrollment
  def percent_of_total(max_enrollment)
    "#{(@seats.to_i*100/max_enrollment.to_i).round(0)}%"
  end

  # add_seatpool to activity offering
  #
  # @param [Array] list of populations used in seatpools already added
  def add_seatpool(pops_used_list)
    on ActivityOfferingMaintenance do |page|
      page.add_pool_priority.set @priority
      page.add_pool_seats.set @seats
      if @population_name != ""
        page.lookup_population_name

        #TODO should really call Population.search_for_pop
        on ActivePopulationLookup do |page|
          if @population_name == "random"
            page.keyword.wait_until_present
            #page.keyword.set random_letters(1)
            page.search
            #page.change_results_page(1+rand(3))
            #names = page.results_list
            #@population_name = names[1+rand(9)]
            @population_name = search_for_random_pop(pops_used_list)
            page.return_value @population_name
          else
            page.keyword.set @population_name
            page.search
            page.return_value @population_name
          end
        end

      end
      on ActivityOfferingMaintenance do |page|
        page.add_seat_pool
      end
    end
  end
end

# stores test data for creating/editing and validating personnel data and provides convenience methods for navigation and data entry
#
# Personnel is a child of a ActivityOffering or CourseOffering (Affiliated Personnel)
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#
# personnel_list[0] = make Personnel, :id=> "user1", :affiliation =>"Instructor"
#
# @activity_offering.edit_offering :affiliated_person_list => personnel_list
#
#create generally called from ActivityOffering/CourseOffering class
# Note the use of the ruby options hash pattern re: setting attribute values
class Personnel
  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  #generally set using options hash
  attr_accessor :id,
                :affiliation,
                :inst_effort

  # provides default data:
  # defaults = {
  #    :id => "admin",
  #    :affiliation => "Instructor",
  #    :inst_effort => 50
  # }
  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :id => "admin",
        :affiliation => "Instructor",
        :inst_effort => 50
    }

    set_options(defaults.merge(opts))
  end

  # creates personnel based on class attributes
  #
  # generally called from ActivityOffering class
  def create
    on ActivityOfferingMaintenance do |page|
      page.add_person_id.set @id
      page.add_affiliation.select @affiliation
      page.add_inst_effort.set @inst_effort
      page.add_personnel
    end
  end

  # edits personnel based on values in options hash
  #
  #  @param opts [Hash] key => value for attribute to be updated
  def edit opts={}
    on ActivityOfferingMaintenance do |page|
      page.add_person_id.fit opts[:id]
      page.add_affiliation.fit opts[:affiliation]
      page.add_inst_effort.fit opts[:inst_effort]
    end
#        update_options(opts)
  end

  # edits personnel based on values in options hash
  #
  #  @param opts [Hash] key => value for attribute to be updated
  def add_personnel(opts={})
    @id = opts[:id]
    @affiliation = opts[:affiliation]
    @inst_effort = opts[:inst_effort]
    on ActivityOfferingMaintenance do |page|
      page.add_person_id.set @id
      page.add_affiliation.select @affiliation
      page.add_inst_effort.set @inst_effort
      page.add_personnel
    end
  end
end

# stores test data for creating/editing and validating delivery logistics data and provides convenience methods for navigation and data entry
#
# DeliveryLogistics is a child of a ActivityOffering (Requested delivery logistics - rdl and actual - adl)
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#
# rdl_list[0] = make DeliveryLogistics, :days=> M, ...
#
# @activity_offering.edit_offering :requested_delivery_logistics_list = rdl_list
#
#create generally called from ActivityOffering
# Note the use of the ruby options hash pattern re: setting attribute values
class DeliveryLogistics
  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  #boolean - generally set using options hash
  attr_accessor :tba, :process
  #generally set using options hash
  attr_accessor :days,
                :start_time,
                :start_time_ampm,
                :end_time,
                :end_time_ampm,
                :facility,
                :facility_long_name,
                :room,
                :features_list


  alias_method :tba?, :tba
  alias_method :process?, :process

  # provides default data:
  # defaults = {
  #    :tba  => false,
  #    :days  => "MWF",
  #    :start_time  => "01:00",
  #    :start_time_ampm  => "pm",
  #    :end_time  => "02:00",
  #    :end_time_ampm  => "pm",
  #    :facility  => "ARM",
  #    :facility_long_name  => "Reckord Armory",
  #    :room  => "126",
  #    :features_list  => [],
  #    :process => true
  # }
  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :tba  => false,
        :days  => "MWF",
        :start_time  => "01:00",
        :start_time_ampm  => "pm",
        :end_time  => "02:00",
        :end_time_ampm  => "pm",
        :facility  => "ARM",
        :facility_long_name  => "Reckord Armory",
        :room  => "126",
        :features_list  => [],
        :process => true
    }
    options = defaults.merge(opts)
    set_options(options)
  end

  # adds Delivery Logistics request based on class attributes
  #
  # add must be completed by calling save or save_and_process (allows adding of multiple rdls)
  #
  # generally called from ActivityOffering class
  def create
    on ActivityOfferingMaintenance do |page|
      if @tba
        page.add_tba.set
      else
        page.add_tba.clear
      end

      page.add_days.set @days
      page.add_start_time.set @start_time
      page.add_start_time_ampm.select @start_time_ampm
      page.add_end_time.set @end_time
      page.add_end_time_ampm.select @end_time_ampm
      page.add_facility.set @facility
      page.add_room.set @room
      #page.facility_features TODO: later, facility features persistence not implemented yet
      page.add_new_delivery_logistics
    end

  end

  # completes create operation (allows adding multiple rdls)
  def save_and_process
    on DeliveryLogisticsEdit do |page|
      page.save_and_process_request
    end
  end

  # completes create operation (allows adding multiple rdls)
  def save
    on DeliveryLogisticsEdit do |page|
      page.save_request
    end
  end

  # delete Delivery Logistics request row
  #
  # generally called from ActivityOffering class - see ActivityOffering
  #
  # @param row
  def delete_rdl(row)
    on DeliveryLogisticsEdit do |page|
      page.delete_requested_logistics_features(row)
      page.save_request
    end
  end

  # delete multiple Delivery Logistics requests
  #
  # generally called from ActivityOffering class - see ActivityOffering
  #
  # @param [int] num of rows to delete
  def delete_rdls(num)
    on DeliveryLogisticsEdit do |page|
      i = 1
      begin
        puts(i)
        begin
          page.delete_requested_logistics_features(i)
        rescue Exception
          page.delete_requested_logistics_features(1)
        end
        i +=1
      end while i < num-1

      page.save_request
    end

  end

  # ??
  def rdl_row_numbers
    on DeliveryLogisticsEdit do |page|
      page.rdl_table_row_nums
    end
  end

end