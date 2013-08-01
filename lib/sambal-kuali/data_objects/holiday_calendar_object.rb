# stores test data for creating/editing and validating holiday calendars and provides convenience methods for navigation and data entry
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#  @calendar = make HolidayCalendar, [:name=>"acal_name1", :start_date=>"12/12/2012", :end_date=>"12/12/2013"]
#  @calendar.create
# OR alternatively 2 steps together as
#  @calendar = create HolidayCalendar, :name=>"acal_name1", :start_date=>"12/12/2012", :end_date=>"12/12/2013"
# Note the use of the ruby options hash pattern re: setting attribute values
class HolidayCalendar

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  #generally set using options hash
  attr_accessor :name, :start_date, :end_date, :holiday_list

  # provides default data:
  #defaults = {
  # :name=>random_alphanums.strip,
  # :start_date=>"09/01/#{next_year[:year]}",
  # :end_date=>"06/25/#{next_year[:year] + 1}",
  # :organization=>"Registrar's Office",  GONE per KSENROLL-5641
  # :holiday_list=>[
  # {:type=>"random", :start_date=>"02/01/#{next_year[:year] + 1}", :all_day=>true, :date_range=>false, :instructional=>false},
  # {:type=>"random", :start_date=>"03/02/#{next_year[:year] + 1}", :end_date=>"03/04/#{next_year[:year] + 1}", :all_day=>true, :date_range=>true, :instructional=>false},
  # {:type=>"random", :start_date=>"04/05/#{next_year[:year] + 1}", :start_time=>"03:00", :start_meridian=>"pm", :end_time=>"07:44", :end_meridian=>"pm", :all_day=>false, :date_range=>false, :instructional=>false},
  # {:type=>"random", :start_date=>"05/11/#{next_year[:year] + 1}", :start_time=>"02:22", :start_meridian=>"am", :end_date=>"05/22/#{next_year[:year] + 1}", :end_time=>"07:44", :end_meridian=>"pm", :all_day=>false, :date_range=>true, :instructional=>false}
  # ]
  #}
  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :name=>random_alphanums.strip,
        :start_date=>"09/01/#{next_year[:year]}",
        :end_date=>"06/25/#{next_year[:year] + 1}",
        :create_by_copy_search => nil,
        :holiday_list=>[
            (make Holiday, :type=>"random", :start_date=>"02/01/#{next_year[:year] + 1}", :all_day=>true, :date_range=>false, :instructional=>false) ,
            (make Holiday, :type=>"random", :start_date=>"03/02/#{next_year[:year] + 1}", :end_date=>"03/04/#{next_year[:year] + 1}", :all_day=>true, :date_range=>true, :instructional=>false )
        ]
    }
    options = defaults.merge(opts)
    set_options(options)
  end

  #navigates to Create Calendar page and creates academic calendar from blank
  def create
    if @create_by_copy_search
      go_to_calendar_search
      on CalendarSearch do |page|
        page.search_for "Holiday Calendar", @create_by_copy_search.name
        page.copy @create_by_copy_search.name
      end
      on EditHolidayCalendar do |page|
        @name = random_alphanums.strip
        page.calendar_name.set @name
        init_calendar
        page.start_date.set @holiday_list.first.start_date
        page.end_date.set @holiday_list.last.start_date
        @start_date = page.start_date.text
        @end_date = page.end_date.text
        page.save
      end
    else
      go_to_holiday_calendar
      on CopyHolidayCalendar do |page|
        page.start_blank_calendar
      end
      on CreateHolidayCalendar do |page|
         page.calendar_name.set @name
         page.start_date.set @start_date
         page.end_date.set @end_date
         @holiday_list.each do |holiday|
           holiday.create
         end
         init_calendar
       page.save
      end
    end
  end

  #navigates to Create Calendar page and creates academic calendar by copying the calendar matching the name parameter
  #
  #@param name [String] name of source calendar
  def copy_from(name)
    go_to_holiday_calendar
    if right_source? name
      on CopyHolidayCalendar do |page|
        page.name.set @name
        page.start_date.set @start_date
        page.end_date.set @end_date
      end
    else
      on CopyHolidayCalendar do |page|
        page.choose_different_calendar
      end
      on CalendarSearch do |page|
        page.search_for "Holiday Calendar", name
        page.copy name
      end
      on EditHolidayCalendar do |page|
        page.academic_calendar_name.set @name
        page.calendar_start_date.set @start_date
        page.calendar_end_date.set @end_date
      end
      on EditHolidayCalendar do |page|
        page.save
      end
    end
  end

  def copy(name)
    on CalendarSearch do |page|
      page.search_for "Holiday Calendar", name
      page.copy name
    end
    on EditHolidayCalendar do |page|
      @name = random_alphanums.strip
      page.calendar_name.set @name
      init_calendar
      page.start_date.set @holiday_list.first.start_date
      page.end_date.set @holiday_list.last.start_date
      @start_date = page.start_date.text
      @end_date = page.end_date.text
      page.save
    end
  end

  def init_calendar
    @holiday_list.clear
    on EditHolidayCalendar do |page|
      page.holiday_table.rows[2..page.holiday_table.rows.count].each do |holiday_row|
        temp_holiday = make Holiday
        temp_holiday.init_holiday(holiday_row) unless holiday_row.cells[EditHolidayCalendar::HOLIDAY_TYPE].text == ""
        @holiday_list.push(temp_holiday) unless temp_holiday.type == "random"
      end
    end
  end


  def search
    go_to_calendar_search
    on CalendarSearch do |page|
      page.search_for "Holiday Calendar", @name
    end
  end

  def right_source?(name)
    on CreateAcadCalendar do |page|
      if page.source_name == name
        return true
      else
        return false
      end
    end
  end

  def make_official
    on CreateHolidayCalendar do |page|
      page.make_official
    end
  end


  def search_and_edit_holiday_calendar
    go_to_calendar_search
    on CalendarSearch do |page|
      page.search_for "Holiday Calendar", @name
      page.edit @name
    end
  end

  def search_holiday_calendar
    go_to_calendar_search
    on CalendarSearch do |page|
      page.search_for "Holiday Calendar", @name
    end
  end

  def instructional_days_off
    return 1
  end
end

class Holiday

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :type, :start_date, :start_time, :start_ampm, :end_date, :end_time, :end_ampm, :all_day, :date_range, :instructional

  def initialize(browser,opts = {})
    @browser = browser

    defaults = {
        :type=> "random",
        :start_date => "12/12/2012",
        :start_time => "",
        :start_ampm => "",
        :end_date => "",
        :end_time => "",
        :end_ampm => "",
        :all_day => true,
        :date_range => false,
        :instructional => true,

    }

    options = defaults.merge(opts)
    set_options(options)
  end

  def create(opts = {})

    on CreateHolidayCalendar do |page|
      if @type == "random"
        page.holiday_type.select page.select_random_holiday
        @type=page.holiday_type.value
      else
        page.holiday_type.select @type
      end
      page.holiday_start_date.set @start_date
      #if @date_range
      #  page.date_range.set
      #  sleep 4
      #  page.holiday_end_date.set @end_date
      #else
      #  page.date_range.clear if page.date_range.set?
      #end
      #if @all_day
      #  page.all_day.set unless page.all_day.set?
      #else
      #  page.start_time
      #end
      if !@instructional then
        page.instructional.clear
        #make sure date is not on a weekend
        st_date = Date.strptime( @start_date , '%m/%d/%Y')
        e_date = Date.strptime( @end_date , '%m/%d/%Y') unless @end_date.nil? or @end_date == ""
        while st_date.saturday? or st_date.sunday? do
          st_date = st_date + 1
          e_date = e_date + 1 unless e_date.nil?
        end
        @start_date = st_date.strftime("%m/%d/%Y")
        page.holiday_start_date.set @start_date
        if !e_date.nil? then
          @end_date = e_date.strftime("%m/%d/%Y")
          page.holiday_end_date.set @end_date
        end
      else
        page.instructional.set
      end
      page.add_link.click
      page.loading.wait_while_present
    end

  end

  def init_holiday(holiday_row)
      @type = holiday_row.cells[EditHolidayCalendar::HOLIDAY_TYPE].text
      @start_date = holiday_row.cells[EditHolidayCalendar::START_DATE].text_field.value
      @start_time = holiday_row.cells[EditHolidayCalendar::START_TIME].text_field.value
      @start_am = holiday_row.cells[EditHolidayCalendar::START_AMPM].radio.set? if holiday_row.cells[EditHolidayCalendar::START_AMPM].radio.enabled?
      @end_date = holiday_row.cells[EditHolidayCalendar::END_DATE].text_field.value
      @end_time = holiday_row.cells[EditHolidayCalendar::END_TIME].text_field.value
      @end_am = holiday_row.cells[EditHolidayCalendar::END_AMPM].radio.set? if holiday_row.cells[EditHolidayCalendar::END_AMPM].radio.enabled?
      #@all_day = holiday_row.cells[EditHolidayCalendar::ALL_DAY].checkbox.set?
      #@date_range = holiday_row.cells[EditHolidayCalendar::DATE_RANGE].checkbox.set?
      @instructional = holiday_row.cells[EditHolidayCalendar::INSTRUCTIONAL].checkbox.set?
  end
end
