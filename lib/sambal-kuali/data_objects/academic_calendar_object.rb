# stores test data for creating/editing and validating academic calendars and provides convenience methods for navigation and data entry
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#  @calendar = make AcademicCalendar, [:name=>"acal_name1", :start_date=>"12/12/2012", :end_date=>"12/12/2013"
#  @calendar.create
# OR alternatively 2 steps together as
#  @calendar = create AcademicCalendar, :name=>"acal_name1", :start_date=>"12/12/2012", :end_date=>"12/12/2013"
# Note the use of the ruby options hash pattern re: setting attribute values
class AcademicCalendar

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  #generally set using options hash
  attr_accessor :name, :start_date, :end_date, :terms
  #not implemented
  attr_accessor :events, :holidays


  # provides default data:
  #  defaults = {
  #      :name=>random_alphanums.strip,
  #      :start_date=>"09/01/#{next_year[:year]}",
  #      :end_date=>"06/25/#{next_year[:year] + 1}",
  #      :organization=>"Registrar's Office"   GONE: per KSENROLL-7685
  #  }
  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :name=>random_alphanums.strip,
        :start_date=>"09/01/#{next_year[:year]}",
        :end_date=>"06/25/#{next_year[:year] + 1}",
        :terms => []
    }
    options = defaults.merge(opts)
    set_options(options)
  end

  #navigates to Create Calendar page and creates academic calendar from blank
  def create
    go_to_academic_calendar
    on CreateAcadCalendar do |page|
      page.start_blank_calendar
    end
    on EditAcademicCalendar do |page|
      page.academic_calendar_name.set @name
      page.calendar_start_date.set @start_date
      page.calendar_end_date.set @end_date
      page.save
    end
  end

  #navigates to Create Calendar page and creates academic calendar by copying the calendar matching the name parameter
  #
  #@param name [String] name of source calendar
  def copy_from(name)
    go_to_academic_calendar
    if right_source? name
      on CreateAcadCalendar do |page|
        page.name.set @name
        page.start_date.set @start_date
        page.end_date.set @end_date
      end
    else
      on CreateAcadCalendar do |page|
        page.choose_different_calendar
      end
      on CalendarSearch do |page|
        page.search_for "Academic Calendar", name
        page.copy name
      end
      on EditAcademicCalendar do |page|
        page.academic_calendar_name.set @name
        page.calendar_start_date.set @start_date
        page.calendar_end_date.set @end_date
      end
    end
    on EditAcademicCalendar do |page|
      page.save
    end
  end

  #search for academic calendar matching the :name attribute
  def search
    go_to_calendar_search
    on CalendarSearch do |page|
      page.search_for "Academic Calendar", @name
    end
  end

  #checks currently selected calendar matches name
  #
  #@param name [String] name of selected calendar
  #
  #@returns boolean
  def right_source?(name)
    on CreateAcadCalendar do |page|
      if page.source_name == name
        return true
      else
        return false
      end
    end
  end

  #make currently selected calendar official
  def make_official
    on EditAcademicCalendar do |page|
      page.make_official
      page.make_offical_confirm
    end
  end

  def edit (opts = {})
    search
    on(CalendarSearch).edit @name

    if !opts[:terms].nil? then
      opts[:terms].each do |term_object|
        add_term(term_object)
      end
    end

  end

  def add_term(term_object)
    term_object.create
    @terms << term_object
  end

end


class AcademicTerm

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :term_type, :term_name, :start_date, :end_date, :instructional_days, :key_date_groups, :parent_calendar

  WINTER_TERM_TYPE = "Winter Term"
  FALL_TERM_TYPE = "Fall Term"

  def initialize(browser,opts = {})
    @browser = browser
    calendar_year = get_random_calendar_year

    defaults = {
        :start_date=>"09/02/#{calendar_year}",
        :end_date=>"06/24/#{calendar_year}",
        :term_type=>"Fall Term",
        :term_name=>"Fall Term #{calendar_year}",
        :key_date_group_list=> Array.new(1){make KeyDateGroup}

    }

    options = defaults.merge(opts)
    set_options(options)

  end

  def create()

    on EditAcademicTerms do |page|
      page.go_to_term_tab
      page.term_type_add.select @term_type
      page.adding.wait_while_present
      page.term_start_date_add.set @start_date
      page.term_end_date_add.set @end_date
      #TODO - parent term
      page.acal_term_add
      page.adding.wait_while_present

      page.open_term_section(@term_type)

      key_date_group_list.each do |date_group|
        date_group.create
      end
    end
  end

  #checks to see if group already exists
  def add_key_date_group(key_date_group_object)
    key_date_group_object.create
    @key_date_group_list <<  key_date_group_object
  end

  ##
  def edit(opts = {})
    search
    on(CalendarSearch).edit @term_name
    on(EditAcademicTerms).open_term_section(@term_type)
  end


  #TODO - move should statements to step definitions
  def verify()
    on EditAcademicTerms do |page|
      page.get_term_type(0).should == @term_name
      page.get_term_start_date(0).should == @start_date
      page.get_term_end_date(0).should == @end_date
    end
    @keyDateGroup[0].verify
  end

  def search
    go_to_calendar_search
    on CalendarSearch do |page|
      page.search_for "Academic Term", @term_name
    end
  end

  #there are existing calendars up to 2023, so most of the term codes are used
  BASE_UNUSED_CALENDAR_YEAR = 2024
  MAX_UNUSED_CALENDAR_YEAR = 2199
  def get_random_calendar_year(base_year =BASE_UNUSED_CALENDAR_YEAR, max_year = MAX_UNUSED_CALENDAR_YEAR)
    rand( (base_year).to_i..(max_year).to_i)
  end

end

class KeyDateGroup

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :key_date_group_type, :key_dates, :term_index, :term_type

  INSTRUCTIONAL_DATE_GROUP = "Instructional"
  REGISTRATION_DATE_GROUP = "Registration"

  def initialize(browser,opts = {})
    @browser = browser

    defaults = {
        :key_date_group_type=> INSTRUCTIONAL_DATE_GROUP,
        :key_dates=>[],
        :term_index=>0
    }

    options = defaults.merge(opts)
    set_options(options)
  end

  def create(opts = {})

    on EditAcademicTerms do |page|
      sleep 3
      #page.open_keydates_section(@parent_term.term_type)

      #only create if not already there
      if page.key_date_group_div(@term_type, @key_date_group_type).nil? then
        @term_index = page.term_index_by_term_type(@term_type)
        page.key_date_group_dropdown(@term_index).select @key_date_group_type
        page.loading.wait_while_present

        page.key_date_group_add @term_index
        page.adding.wait_while_present
      end

      @key_dates.each do |key_date|
        add_key_date(key_date)
      end

      page.save
    end

  end

  def add_key_date(key_date_object)
    key_date_object.create
  end
  private :add_key_date

  #def edit(opts = {})
  #
  #end


  def verify
    @key_dates[0].verify
  end
end

class KeyDate

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :key_date_type, :start_date, :end_date, :start_time, :end_time, :start_time_ampm, :end_time_ampm,
                :all_day, :date_range, :term_index, :parent_key_date_group

  def initialize(browser,opts = {})
    @browser = browser

    defaults = {
        key_date_type: "Grading Period",
        start_date: "09/02/#{next_year[:year]}",
        end_date: nil,
        start_time: nil,
        end_time: nil,
        start_time_ampm: nil,
        end_time_ampm: nil,
        all_day: true,
        date_range: false,
        term_index: 0
    }

    options = defaults.merge(opts)
    set_options(options)
  end

  def create()
    #only create if doesn't already exist, other wise edit the existing one
    on EditAcademicTerms do |page|
      if ! page.key_date_exists?(@parent_key_date_group.term_type, @parent_key_date_group.key_date_group_type, @key_date_type) then
        @term_index = page.term_index_by_term_type(@parent_key_date_group.term_type)

        page.key_date_dropdown_addline(@term_index,0).select @key_date_type
        page.loading.wait_while_present
        page.key_date_start_date_addline(@term_index,0).set @start_date
        page.loading.wait_while_present


        page.key_date_allday_addline(@term_index,0).set @all_day
        page.loading.wait_while_present
        page.key_date_daterange_addline(@term_index,0).set @date_range
        page.loading.wait_while_present

        page.key_date_end_date_addline(@term_index,0).set @end_date if @date_range

        page.key_date_add(@term_index,0)
      else
        #TODO - need the opposite of set_options here
        edit :key_date_type => @key_date_type, :start_date => @start_date, :end_date  => @end_date, :start_time  => @start_time, :end_time  => @end_time, :start_time_ampm  => @start_time_ampm,  :end_time_ampm => @end_time_ampm, :all_day => @all_day, :date_range  => @date_range
      end
      page.save

    end

  end

  def edit options={}

    edit_row = on(EditAcademicTerms).key_date_target_row(@parent_key_date_group.term_type, @parent_key_date_group.key_date_group_type, @key_date_type)

    if options[:start_date] != nil
      on EditAcademicTerms  do |page|
        page.edit_key_date_start_date(edit_row,options[:start_date])
      end
    end

    if options[:all_day] != nil
      on EditAcademicTerms  do |page|
        if options[:all_day] then
          page.set_key_date_is_all_day(edit_row)
        else
          page.clear_key_date_is_all_day(edit_row)
        end
      end
    end

    if options[:date_range] != nil
      on EditAcademicTerms  do |page|
        if options[:date_range] then
          page.set_key_date_is_range(edit_row)
        else
          page.clear_key_date_is_range(edit_row)
        end
      end
    end

    if options[:end_date] != nil
      on EditAcademicTerms  do |page|
        page.edit_key_date_end_date(edit_row,options[:end_date]) if @date_range
      end
    end

    if options[:start_time] != nil
      on EditAcademicTerms  do |page|
        page.edit_key_date_start_time(edit_row,options[:start_time])
      end
    end

    if options[:end_time] != nil
      on EditAcademicTerms  do |page|
        page.edit_key_date_end_time(edit_row,options[:end_time])
      end
    end

    if options[:start_time_ampm] != nil
      on EditAcademicTerms  do |page|
        page.edit_key_date_start_ampm(edit_row,options[:start_time_ampm])
      end
    end

    if options[:end_time_ampm] != nil
      on EditAcademicTerms  do |page|
        page.edit_key_date_end_ampm(edit_row,options[:end_time_ampm])
      end
    end

    on(EditAcademicTerms).save

    set_options(options)
    end

#TODO - move to step definitions
  def verify()
    on EditAcademicTerms do |page|
      page.key_date_type(0,0,0).should == @key_date_type
      page.key_date_start_date(0,0,0).should == @start_date
      page.key_date_end_date(0,0,0).should == @end_date
      page.key_date_allday(0,0,0).should == @all_day
      page.key_date_daterange(0,0,0).should == @date_range
    end
  end

end

