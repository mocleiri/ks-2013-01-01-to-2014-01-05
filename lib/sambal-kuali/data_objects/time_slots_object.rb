# Stores test data for creating/editing and validating a group of time slots for 1 or more term-types
#
# Class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#
#   To create 3 time-slots that shouldn't conflict with any existing ones: (see comment in add_unused_time_slots method for more detail)
#
#       @time_slots = create TimeSlots
#       @time_slots.add_unused_time_slots(3)
#
#   To add a specific time-slot (accepting defaults for start-time and end-time):
#
#       @time_slots = create TimeSlots, :term_types => ["Spring - Full", "Fall - Full"]           <- this will show all time-slots for both term-types
#       time_slot_to_add = make TimeSlots::TimeSlot, :term_type => "Spring - Full", :days => "T"  <- this will then add a time-slot for a specific term-type
#       @time_slots.add_new_time_slot( time_slot_to_add )
#
# Note the use of the ruby options hash pattern re: setting attribute values
class TimeSlots

  require 'date'

  include Foundry
  include DataFactory
  include Workflows

  attr_accessor :term_types

  attr_reader   :new_time_slots

  # provides default data
  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :term_types => [ "Fall - Full" ],
        :new_time_slots => []
    }

    options = defaults.merge(opts)

    set_options(options)
  end

  # creates the TimeSlots-object and shows all time-slots for the specific term-types
  def create
    show_time_slots
  end #END-create

  # adds a new time-slot, validating that it was added successfully and adding it to it's internal list of added time-slots (for validation later)
  def add_new_time_slot( time_slot )
    time_slot.code = on(TimeSlotMaintenance).add_new_time_slot time_slot
    new_time_slots << time_slot
  end

  def edit_time_slot(opts)
    defaults = {
    }
    options = defaults.merge(opts)
    on TimeSlotMaintenance do |page|
      page.edit_time_slot(options)
    end
  end

  # adds a new time-slot but performs no validation and does not store in the internal list
  def add_new_time_slot_without_validation( time_slot )
    on(TimeSlotMaintenance).add_time_slot_without_validation(time_slot)
  end

  # duplicates a time-slot that already exists in the table (by it's code) -- note, does not validate nor store the result
  def add_duplicate_time_slot(code)
    target_timeslot_row = on(TimeSlotMaintenance).target_results_row(code)
    time_slot = make TimeSlots::TimeSlot, :term_type => target_timeslot_row[TimeSlotMaintenance::TIME_SLOT_RESULTS_TERM_TYPE].text,
                     :days => target_timeslot_row[TimeSlotMaintenance::TIME_SLOT_RESULTS_DAYS].text.gsub!( /\s+/, ''),
                     :start_time => target_timeslot_row[TimeSlotMaintenance::TIME_SLOT_RESULTS_START_TIME].text.split(" ")[0],
                     :start_time_am_pm => target_timeslot_row[TimeSlotMaintenance::TIME_SLOT_RESULTS_START_TIME].text.split(" ")[1],
                     :end_time => target_timeslot_row[TimeSlotMaintenance::TIME_SLOT_RESULTS_END_TIME].text.split(" ")[0],
                     :end_time_am_pm => target_timeslot_row[TimeSlotMaintenance::TIME_SLOT_RESULTS_END_TIME].text.split(" ")[1]
    add_new_time_slot_without_validation(time_slot)
  end

  # adds a specified number of time-slots, generating a pseudo-unique set of start/end-times
  #
  # note: current impl does not actually verify that the start/end times used are unique; it merely takes the start
  # time of the last row in the table and then calculates a new time based off of this.  To facilitate uniqueness, this
  # will use a day that isn't used widely by ref-data.  Thus, it *might* collide if existing time-slots higher in the
  # table just happen to use these values, but it's not likely unless ref-data changes.
  def add_unused_time_slots(termType = "Fall - Full", nbr)
    (1..nbr).each do
      on TimeSlotMaintenance do |page|
        startTime = increment_time( page.get_start_time_of_last_row, 1 )
        sTime, sAmPm = startTime.split(" ")
        eTime, eAmPm = increment_time( startTime, 5 ).split(" ")
        add_new_time_slot(make TimeSlots::TimeSlot, :term_type => termType, :start_time => sTime, :start_time_am_pm => sAmPm, :end_time => eTime, :end_time_am_pm => eAmPm)
      end
    end
  end

  def increment_time(full_time_with_am_pm, x_minutes_to_increment_by)
    ( DateTime.strptime(full_time_with_am_pm, '%I:%M %p') + (x_minutes_to_increment_by.to_f/1440) ).strftime( '%I:%M %p' )
  end

  def delete(code)
    on TimeSlotMaintenance do |page|
      page.delete_time_slot(code)
    end
  end


  def show_time_slots
    go_to_manage_time_slots

    on TimeSlotMaintenance do |page|
      page.select_time_slot_types(term_types)
      page.show_time_slots
    end
  end

  def print_new_time_slots_to_console
    puts "Newly-added time slots:"
    new_time_slots.each do |slot|
      slot.print_time_slot_to_console
    end
  end

  def print_all_time_slot_codes_to_console
    ts_list = []
    puts "All time slot codes:"
    on TimeSlotMaintenance do |page|
      ts_list = page.get_time_slot_code_list
    end
    puts ts_list
  end

  # Stores test data for creating/editing and validating an individual time slot
  #
  # Class attributes are initialized with default data unless values are explicitly provided
  #
  # Note that typical usage of this should be via 'make' not 'create' and then pass to an add-method in the TimeSlots object
  #
  # For examples, see comment at the top of the file
  #
  # Note the use of the ruby options hash pattern re: setting attribute values
  class TimeSlot

    include DataFactory

    # type: string generally set using options hash
    attr_accessor :code,
                  :term_type,
                  :days,
                  :start_time,
                  :start_time_am_pm,
                  :end_time,
                  :end_time_am_pm

    # provides default data
    #
    # initialize is generally called using TestFactory Foundry .make or .create methods
    def initialize(browser, opts={})
      @browser = browser

      defaults = {
          :code => "",
          :term_type => "Fall - Full",
          :days => "W",
          :start_time => "2:31",
          :start_time_am_pm => "AM",
          :end_time => "2:36",
          :end_time_am_pm => "AM"
      }

      options = defaults.merge(opts)

      set_options(options)
    end

    def print_time_slot_to_console
      puts "Code #{code}, Term type #{term_type}, Days #{days}, Start #{start_time} #{start_time_am_pm}, End #{end_time} #{end_time_am_pm}"
    end
  end

end