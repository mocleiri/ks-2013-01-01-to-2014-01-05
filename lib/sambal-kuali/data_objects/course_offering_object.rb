# note: this test has been code-reviewed here: https://fisheye.kuali.org/cru/ks-370
# additional notes about future-refactoring were left in this jira: https://jira.kuali.org/browse/KSENROLL-5895



# stores test data for creating/editing and validating course offerings and provides convenience methods for navigation and data entry
#
# CourseOffering objects contain ActivityOfferings, ActivityOfferingClusters, DeliveryFormats....
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#  @course_offering = make CourseOffering, [:course => "CHEM317",...]
#  @course_offering.create
# OR alternatively 2 steps together as
#  @course_offering = create CourseOffering, [:course => "CHEM317",...]
# Note the use of the ruby options hash pattern re: setting attribute values
class CourseOffering

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  #generally set using options hash
  attr_accessor :term,
                :course,
                :suffix,
                :final_exam_type
  #generally set using options hash
  attr_accessor :activity_offering_cluster_list,
                :ao_list,
                :affiliated_person_list,
                :affiliated_org_list
  #generally set using options hash
  attr_accessor :wait_list,
                :wait_list_level,
                :wait_list_type,
                :grade_format,
                :delivery_format_list,
                :final_exam_driver,
                :honors_flag,
                :grade_options,
                :reg_options,
                :search_by_subj
  #generally set using options hash - course offering object to copy
                :create_by_copy



  # provides default data:
  #  defaults = {
  #    :term=>Rollover::MAIN_TEST_TERM_SOURCE,
  #    :course=>"ENGL211",
  #    :suffix=>"",
  #    :activity_offering_cluster_list=>[],
  #    :ao_list => [],
  #    :final_exam_type => "NONE",
  #    :wait_list => "NO",
  #    :wait_list_level => "Course Offering",
  #    :wait_list_type => "Automatic",
  #    :grade_format => "",
  #    :delivery_format_list => [],
  #    :final_exam_driver => "",
  #    :honors_flag => "NO",
  #    :affiliated_person_list => {},
  #    :affiliated_org_list => {},
  #    :grade_options => "Letter",
  #    :reg_options => "None available",
  #    :search_by_subj => false,
  #    :create_by_copy => nil
  #  }
  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :term=>Rollover::MAIN_TEST_TERM_SOURCE,
        :course=>"ENGL211",
        :suffix=>"",
        :activity_offering_cluster_list=>[],
        :ao_list => [],
        :final_exam_type => "STANDARD",
        :wait_list => "YES",
        :wait_list_level => "Course Offering",
        :wait_list_type => "Automatic",
        :grade_format => "",
        :delivery_format_list => [],
        :final_exam_driver => "",
        :honors_flag => "NO",
        :affiliated_person_list => {},
        :affiliated_org_list => {},
        :grade_options => "Letter",
        :reg_options => "Pass/Fail Grading",
        :search_by_subj => false,
        :create_by_copy => nil,
        :create_from_existing => nil,
    }
    options = defaults.merge(opts)
    set_options(options)
  end

  # creates course offering based on class attributes
  def create
    if @create_by_copy != nil
      @course = create_co_copy(@create_by_copy.course, @create_by_copy.term)
      #deep copy
      @term = @create_by_copy.term
      @activity_offering_cluster_list = @create_by_copy.activity_offering_cluster_list
      @ao_list = @create_by_copy.ao_list
    elsif @create_from_existing != nil
      @course = create_from_existing_course(@create_from_existing.course, @create_from_existing.term)
      #deep copy
      @activity_offering_cluster_list = @create_from_existing.activity_offering_cluster_list
      @ao_list = @create_from_existing.ao_list
    else #create from catalog
      start_create_by_search
      on CreateCourseOffering do  |page|
        @suffix = random_alphanums(5)
        page.suffix.set @suffix
        @course = "#{@course}#{@suffix}"
        delivery_obj = make DeliveryFormat
        delivery_obj.select_random_delivery_formats
        @delivery_format_list << delivery_obj
        page.create_offering
      end
    end
  end

  # searches for and edits an existing course offering course_code matching @course attribute
  # @example
  #  @course_offering.edit :honors_flag=> "YES"
  #
  # @param opts [Hash] key => value for attribute to be updated
  def edit_offering options={}
    #TODO change method name to 'edit'
    if options[:suffix] != @suffix
      #TODO:Add Suffix to edit method Course Offerings
    end

    if options[:wait_list] != nil
      on CourseOfferingEdit do |page|
        if options[:wait_list] == "NO"
          page.waitlist_off
        else
          page.waitlist_on
        end
        @wait_list = options[:wait_list]
      end
    end

    if options[:wait_list_level] != nil
      on CourseOfferingEdit do |page|
        if options[:wait_list_level] == "Activity Offering"
          page.waitlist_option_activity_offering
        else
          page.waitlist_option_course_offering
        end
        @wait_list_level = options[:wait_list_level]
      end
    end

    if options[:wait_list_type] != nil
      on CourseOfferingEdit do |page|
        @wait_list_type = options[:wait_list_type]
        page.waitlist_select.select(@wait_list_type)
      end
    end

    if options[:honors_flag] != nil
      on CourseOfferingEdit do |page|
        if options[:honors_flag] == "YES"
          page.honors_flag.set
        else
          page.honors_flag.clear
        end
        @honors_flag = options[:honors_flag]
      end
    end

    if options[:final_exam_type] != nil
      on CourseOfferingEdit do |page|
        case options[:final_exam_type]
          when "Standard final Exam"
            page.final_exam_option_standard
            @final_exam_type = "STANDARD"
          when "Alternate final assessment"
            page.final_exam_option_alternate
            @final_exam_type = "ALTERNATE"
          when "No final exam or assessment"
            page.final_exam_option_none
            @final_exam_type = "NONE"
        end
      end
    end

    if options[:delivery_format_list] != nil
      delivery_obj = make DeliveryFormat
      delivery_obj.edit_random_delivery_formats
      @delivery_format_list << delivery_obj
    end

    if options[:grade_format] != nil
      on CourseOfferingEdit do |page|
        page.select_grade_roster_level(options[:grade_format])
      end
      @grade_format = options[:grade_format]
    end

    if options[:final_exam_driver] != nil
      on CourseOfferingEdit do |page|
        page.select_final_exam_driver(options[:final_exam_driver])
      end
      @final_exam_driver = options[:final_exam_driver]
    end

    if options[:affiliated_person_list] != nil
      options[:affiliated_person_list].values.each do |person|
        on CourseOfferingEdit do |page|
          page.lookup_person
        end
        on PersonnelLookup do |page|
          page.principal_name.set person.id
          page.search
          page.return_value(person.id)
        end
        on CourseOfferingEdit do |page|
          page.add_affiliation.select(person.affiliation)
          page.add_personnel
        end
      end
    end

    if options[:affiliated_org_list] != nil
      options[:affiliated_org_list].values.each do |org|
        on CourseOfferingEdit do |page|
          page.lookup_org
        end

        on OrgLookupPopUp do |page|
          page.short_name.set org.org_name
          page.search
          page.return_value(org.org_name)
        end

        on CourseOfferingEdit do |page|
          page.add_org
        end
      end
    end
  end

  def manage
    #TODO: ?change to def manage_and_init
    go_to_manage_course_offerings
    on ManageCourseOfferings do |page|
      page.term.set @term

      if @search_by_subj
        page.input_code.set @course[0,4]
      else
        page.input_code.set @course
      end

      page.show

      begin
        page.create_co_button.wait_until_present(5)
        page.target_row(@course).link(text: "Manage").click
        page.loading.wait_while_present
      rescue Watir::Wait::TimeoutError
        #means was single CO returned, AO list is already displayed
      end
    end

    on ManageCourseOfferings do |page|
      begin
        @ao_list = page.codes_list
      rescue
        @ao_list = []
      end

    end
  end

  def search_by_subjectcode
    go_to_manage_course_offerings
    on ManageCourseOfferings do |page|
      page.term.set @term
      page.input_code.set @course[0,4]
      st_time = Time.new
      page.show
      end_time = Time.new
      puts "#{@course[0,4]} subj code search time: #{end_time-st_time}"
    end
  end

  def search_by_coursecode
    go_to_manage_course_offerings
    on ManageCourseOfferings do |page|
      page.term.set @term
      page.input_code.set @course
      page.show
    end
  end

  def start_create_by_search
    go_to_create_course_offerings
    on CreateCourseOffering do  |page|
      page.target_term.set @term
      page.catalogue_course_code.set @course
      page.show
    end
  end

  def view_course_details
    on ManageCourseOfferingList do |page|
      page.view_course_offering @course.upcase
    end
  end

  # checks to see if course offering in the same is in specified state, otherwise creates a new course offering
  # @example
  #  @course_offering.check_course_in_status
  # updates the course code
  #
  # @param co_status [String] "Offered", "Draft"
  #TODO: use constants here for status
  def check_course_in_status(co_status)
    search_by_subjectcode
    on ManageCourseOfferingList do |page|
      existing_co = page.select_co_by_status(co_status)
      if existing_co != nil
        @course = existing_co
      else
        @course = create_co_copy(@course, @term)
        if co_status == "Offered" or co_status == "Planned"
          approve_course
        end
      end
    end
  end

  def approve_course
   on ManageCourseOfferingList do |page|
      begin
        page.select_co(@course.upcase)
        page.approve_course_offering
        page.approve_yes
      rescue Timeout::Error => e
      puts "rescued target_row edit"
      end
    end
  end

  def approve_subject_code
    search_by_subjectcode
    on ManageCourseOfferingList do |page|
      sleep 1
      page.approve_subject_code
    end
    approved = false
    on ManageCourseOfferingList do |page|
      sleep 1
      approved = page.course_offering_results_table.rows[2].cells[ManageCourseOfferingList::CO_STATUS_COLUMN].text == "Planned"
    end
    #to avoid data setup failure retry approve subject
    if !approved then
      search_by_subjectcode
      on ManageCourseOfferingList do |page|
        sleep 1
        page.approve_subject_code
      end
    end
  end




  #navigate for the manage registration groups page for the course offering
  #
  #@param  opts [Hash] {:cleanup_existing_clusters => true/false}
  def manage_registration_groups(opts = {:cleanup_existing_clusters => true})
    manage
    on ManageCourseOfferings do |page|
      page.manage_registration_groups
    end
    if opts[:cleanup_existing_clusters]
      cleanup_all_ao_clusters
    end
  end

  #delete specified activity offering
  #
  #@param  opts [Hash] {:ao_code => "code"}
  def delete_ao(opts)
    ao_code = opts[:ao_code]
    delete_ao_list( {:code_list => [ ao_code]})
  end

  #delete specified activity offerings
  #
  #@param  opts [Hash] {:code_list => ["code1","code2", ...]}
  def delete_ao_list(opts)
    ao_code_list = opts[:code_list]
    on ManageCourseOfferings do |page|
      page.select_aos(ao_code_list)
      page.delete_aos
    end
    on ActivityOfferingConfirmDelete do |page|
      page.delete_activity_offering
    end
  end

  def attempt_ao_delete_by_status(aostate)
    on ManageCourseOfferings do |page|
      if page.row_by_status(aostate).exists?
        ao = page.select_ao_by_status(aostate)
        if page.delete_aos_button.enabled?
          page.delete_aos
          on ActivityOfferingConfirmDelete do |page|
            delete_present = page.delete_activity_offering_button.present?
            page.cancel
            return delete_present
          end
        else
          page.deselect_ao(ao)
          return false
        end
      else
        page.copy("A")
        @ao_list = page.codes_list
        page.select_ao(@ao_list.first)
        if aostate == "Approved"
        page.approve_activity
        ao = page.select_ao_by_status(aostate)
        end
        if page.delete_aos_button.enabled?
          page.delete_aos
          on ActivityOfferingConfirmDelete do |page|
            @access = page.delete_activity_offering_button.present?
            page.delete_activity_offering
            return @access
          end
        else
          page.deselect_ao(ao)
          return false
        end
      end
    end
  end

  def attempt_co_delete_by_status(aostate)
      on ManageCourseOfferingList do |page|
          @course = page.select_co_by_status(aostate)
          if page.delete_cos_button.enabled?
            page.delete_cos
          else
            page.deselect_co(@course)
            return false
          end
          on DeleteCourseOffering do |page|
            return  page.confirm_delete_button.present?
          end
      end
  end

  #copy the specified activity offering
  #
  #@param  opts [Hash] {:ao_code => "CODE"}
  def copy_ao(opts)
    ao_code = opts[:ao_code]
    on ManageCourseOfferings do |page|
      page.copy(ao_code)
    end
  end

  #enter the edit page for the specified activity offering
  #
  #@param  opts [Hash] {:ao_code => "CODE"}
  def edit_ao(opts)
    ao_code = opts[:ao_code]
    on ManageCourseOfferings do |page|
      page.edit(ao_code)
    end
  end

  def delete_ao_cross_list_value(opts)
    ao_code_list = opts[:code_list]
    on ManageCourseOfferings do |page|
      page.select_aos(ao_code_list)
      page.delete_aos
    end
    on ActivityOfferingConfirmDelete do |page|
      page.delete_confirm_message
    end
  end

  def ao_status(inputOrg)
    retVal = nil
    aoCode = inputOrg[:inputs][0]
    aoState = inputOrg[:inputs][1]
    on ManageCourseOfferings do |page|
      if page.ao_status(aoCode, aoState)
        retVal = aoState
      end
    end
    retVal
  end

  def ao_schedule_data(ao_code)
    retVal = nil
    aoCode = ao_code[:ao_code]
    on ManageCourseOfferings do |page|
      retVal = page.ao_schedule_data(aoCode)
    end

    retVal
  end

  def cross_listed_co_data(co_code)
    retVal = nil
    on ManageCourseOfferings do |page|
      retVal = page.course_title
    end

    retVal
  end

  def add_ao_cluster(ao_cluster)
    ao_cluster.create
    @activity_offering_cluster_list << ao_cluster
  end

  def expected_unassigned_ao_list
    expected_unassigned = @ao_list
    @activity_offering_cluster_list.each do |cluster|
      expected_unassigned = expected_unassigned - cluster.assigned_ao_list
    end
    expected_unassigned.delete_if { |id| id.strip == "" }
    expected_unassigned
  end

  def create_from_existing_course(course, term)
    pre_copy_co_list = []
    post_copy_co_list = []

    go_to_manage_course_offerings
    on ManageCourseOfferings do |page|
      page.term.set @term
      page.input_code.set course[0,4] #subject code
      page.show
    end
    on ManageCourseOfferingList do |page|
      pre_copy_co_list = page.co_list
    end

    start_create_by_search
    on CreateCourseOffering do |page|
      page.create_from_existing_offering_tab
      page.select_copy_for_existing_course(term, course)
      page.configure_course_offering_copy_toggle
      #TODO add parms for selecting what to exclude from copy
    end

    go_to_manage_course_offerings
    on ManageCourseOfferings do |page|
      page.term.set @term
      page.input_code.set course[0,4] #subject code
      page.show
    end
    on ManageCourseOfferingList do |page|
      post_copy_co_list = page.co_list
    end
    (post_copy_co_list - pre_copy_co_list).first
  end
  private :create_from_existing_course

  def create_co_copy(source_course_code, term)
    pre_copy_co_list = []
    post_copy_co_list = []

    go_to_manage_course_offerings
    on ManageCourseOfferings do |page|
      page.term.set term
      page.input_code.set source_course_code[0,4] #subject code
      page.show
    end
    on ManageCourseOfferingList do |page|
      pre_copy_co_list = page.co_list
      page.copy source_course_code
    end
    on CopyCourseOffering do |page|
      page.create_copy
    end
    on ManageCourseOfferingList do |page|
      post_copy_co_list = page.co_list
    end

    @course = (post_copy_co_list - pre_copy_co_list).first
  end
  private :create_co_copy

  def total_co_list(course_code)
    go_to_manage_course_offerings
    on ManageCourseOfferings do |page|
      page.term.set @term
      page.input_code.set course_code
      page.show
    end
    on(ManageCourseOfferingList).co_list
  end

  def delete_co(args={})

    should_confirm_delete = false
    case args[:should_confirm_delete]
      when true
        should_confirm_delete = true
    end

    co_code_list = args[:code_list]
    on ManageCourseOfferingList do |page|
      page.select_cos(co_code_list)
      page.delete_cos
    end
    on DeleteCourseOffering do |page|
      case should_confirm_delete
        when true
          page.confirm_delete
        else
          page.cancel_delete
      end
    end

  end

  def delete_co_warning_message(args={})

    co_code_list = args[:code_list]
    on ManageCourseOfferingList do |page|
      page.select_cos(co_code_list)
      page.delete_cos
    end
    on DeleteCourseOffering do |page|
      delete_warning = page.delete_warning_message
      page.cancel_delete
      return delete_warning
    end
  end

  def delete_co_with_link(args={})
    should_confirm_delete = false
    case args[:should_confirm_delete]
      when true
        should_confirm_delete = true
    end

    on ManageCourseOfferings do |page|
      page.delete_course_offering
    end
    on DeleteCourseOffering do |page|
      case should_confirm_delete
        when true
          page.confirm_delete
        else
          page.cancel_delete
      end
    end
  end

  def cleanup_all_ao_clusters
    existing_cluster_list = []
    on ManageRegistrationGroups do |page|
      page.cluster_div_list.each do |cluster_div|
        existing_cluster_list << cluster_div.span().text()
      end
    end

    existing_cluster_list.each do |cluster|
      on ManageRegistrationGroups do |page|
        while true
          begin
            sleep 1
            wait_until(10) {page.cluster_list_div.exists? }
            break
          rescue Watir::Wait::TimeoutError #in case generation fails
            break
          rescue Selenium::WebDriver::Error::StaleElementReferenceError
            puts "rescued - generate_unconstrained_reg_groups"
          end
        end
        page.remove_cluster(cluster)
        page.confirm_delete_cluster
        begin
          page.cluster_list_item_div(cluster).wait_while_present(60)
        rescue Watir::Exception::UnknownObjectException
          #ignore
        end
      end
    end
  end
end

class AffiliatedOrg

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :org_id,
                :org_name

  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :org_id => "65",
        :org_name => "Biology"
    }
    options = defaults.merge(opts)
    set_options(options)
  end

end

class DeliveryFormat
  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :format,
                :grade_format,
                :final_exam_driver

  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :format => "Lecture/Quiz",
        :grade_format => "Course",
        :final_exam_driver => "Lecture"
    }
    options = defaults.merge(opts)
    set_options(options)
  end

  def select_random_delivery_formats
    on CreateCourseOffering do  |page|
      selected_options = page.add_random_delivery_format
      if selected_options[:del_format] == "Lab"
         @format = "Lab Only"
      elsif selected_options[:del_format] == "Lecture"
         @format = "Lecture Only"
      else
         @format = selected_options[:del_format]
      end

      if selected_options[:grade_format] == "Course"
        @grade_format = "Course Offering"
      else
        @grade_format = selected_options[:grade_format]
      end


      @final_exam_driver = selected_options[:final_exam_driver]
      return selected_options
    end

  end

  def edit_random_delivery_formats
    on CourseOfferingEdit do |page|
      selected_options = page.edit_random_delivery_format
      @format = selected_options[:del_format]
      @grade_format = selected_options[:grade_format]
      @final_exam_driver = selected_options[:final_exam_driver]
      return selected_options
    end
  end

end
