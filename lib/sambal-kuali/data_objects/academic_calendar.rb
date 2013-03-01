# stores test data for creating/editing and validating academic calendars and provides convenience methods for navigation and data entry
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#  @calendar = make AcademicCalendar, [:name=>"acal_name1", :start_date=>"12/12/2012", :end_date=>"12/12/2013", :organization=>"Example_Org"]
#  @calendar.create
# OR alternatively 2 steps together as
#  @calendar = create AcademicCalendar, :name=>"acal_name1", :start_date=>"12/12/2012", :end_date=>"12/12/2013", :organization=>"Example_Org"
# Note the use of the ruby options hash pattern re: setting attribute values
class AcademicCalendar

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  #generally set using options hash
  attr_accessor :name, :start_date, :end_date, :organization
  #not implemented
  attr_accessor :events, :holidays, :terms

  # provides default data:
  #  defaults = {
  #      :name=>random_alphanums.strip,
  #      :start_date=>"09/01/#{next_year[:year]}",
  #      :end_date=>"06/25/#{next_year[:year] + 1}",
  #      :organization=>"Registrar's Office"
  #  }
  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :name=>random_alphanums.strip,
        :start_date=>"09/01/#{next_year[:year]}",
        :end_date=>"06/25/#{next_year[:year] + 1}",
        :organization=>"Registrar's Office"
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
      page.organization.select @organization
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
        page.organization.select @organization
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
    end
  end

end


class AcademicTerm

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :term_type, :term_name, :start_date, :end_date, :instructional_days, :key_date_groups

  def initialize(browser,opts = {})
    @browser = browser

    defaults = {
        :start_date=>"09/02/#{next_year[:year]}",
        :end_date=>"06/24/#{next_year[:year] + 1}",
        :term_type=>"Spring Term",
        :term_name=>"Spring Term" + " #{next_year[:year]}"
    }

    options = defaults.merge(opts)
    set_options(options)

  end

  def create(term_type)

    if (term_type != nil)
      @term_type="#{term_type}".capitalize + " Term"
      @term_name=@term_type + " #{next_year[:year]}"
    end

    on AcademicTermPage do |page|
      page.term_type_add.select @term_type
      page.term_start_date_add.set @start_date
      page.term_end_date_add.set @end_date

      page.acal_term_add

      @keyDateGroup = Array.new(1){make KeyDateGroup}
      @keyDateGroup[0].create
    end
  end

  def verify()
    on AcademicTermPage do |page|
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

end

class KeyDateGroup

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :key_date_group_type, :key_dates

  def initialize(browser,opts = {})
    @browser = browser

    defaults = {
        :key_date_group_type=>"Instructional",
        :key_dates=>{}
    }

    options = defaults.merge(opts)
    set_options(options)
  end

  def create(opts = {})

    on AcademicTermPage do |page|
      sleep 3
      page.key_date_group_dropdown(0).select @key_date_group_type

      page.key_date_group_add 0

      @key_dates = Array.new(1){make KeyDate}
      @key_dates[0].create
    end

  end

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
                :all_day, :date_range

  def initialize(browser,opts = {})
    @browser = browser

    defaults = {
        key_date_type: "Grading Period",
        start_date: "09/02/#{next_year[:year]}",
        end_date: "06/24/#{next_year[:year] + 1}",
        start_time: "10:00",
        end_time: "05:00",
        start_time_ampm: "am",
        end_time_ampm: "pm",
        all_day: false,
        date_range: true
    }

    options = defaults.merge(opts)
    set_options(options)
  end

  def create(opts = {})
    sleep 3;
    on AcademicTermPage do |page|
      page.key_date_dropdown_addline(0,0).select @key_date_type
      page.key_date_start_date_addline(0,0).set @start_date
      page.key_date_end_date_addline(0,0).set @end_date
      page.key_date_allday_addline(0,0).set @all_day
      page.key_date_daterange_addline(0,0).set @date_range

      page.key_date_add(0,0)
    end

  end

  def verify()
    on AcademicTermPage do |page|
      page.key_date_type(0,0,0).should == @key_date_type
      page.key_date_start_date(0,0,0).should == @start_date
      page.key_date_end_date(0,0,0).should == @end_date
      page.key_date_allday(0,0,0).should == @all_day
      page.key_date_daterange(0,0,0).should == @date_range
    end
  end

end

