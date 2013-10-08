# Stores test data for creating/editing and validating a group of time slots for 1 or more term-types
#
# Class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#
# TO DO TO DO TO DO #####################################################################
#
# Note the use of the ruby options hash pattern re: setting attribute values
class TimeSlots

  include Foundry
  include DataFactory
  include Workflows

  attr_accessor :term_types

  attr_reader   :new_time_slots

  # provides default data:
  #
  #  defaults = {
  #     :term_types => [ "Fall - Full" ]
  #  }

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

  def create
    show_time_slots
  end #END-create


  def add_new_time_slot( time_slot )
    time_slot.code = on(TimeSlotMaintenance).add_new_time_slot time_slot
    new_time_slots << time_slot
  end

  def add_new_time_slot_without_validation( time_slot )
    on(TimeSlotMaintenance).add_time_slot_without_validation(time_slot)
  end

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

  def add_unused_time_slots(termType = "Fall - Full", nbr)
    (1..nbr).each do
      on TimeSlotMaintenance do |page|
        startTime, endTime = page.generate_unused_start_and_end_times
        sTime, sAmPm = startTime.split(" ")
        eTime, eAmPm = endTime.split(" ")
        add_new_time_slot(make TimeSlots::TimeSlot, :term_type => termType, :start_time => sTime, :start_time_am_pm => sAmPm, :end_time => eTime, :end_time_am_pm => eAmPm)
      end
    end
  end

  def delete(code)
    puts "calling TimeSlots.delete(#{code})"
    on TimeSlotMaintenance do |page|
      page.delete_time_slot(code)
      sleep(9)
    end

    print_new_time_slots_to_console
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

  # Stores test data for creating/editing and validating an individual time slot
  #
  # Class attributes are initialized with default data unless values are explicitly provided
  #
  # Typical usage: (with optional setting of explicit data value in [] )
  #
  # TO DO TO DO TO DO #####################################################################
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

    # provides default data:
    #
    #  defaults = {
    #    :code => ""
    #    :term_type => "Fall - Full"
    #    :days => "M"
    #    :start_time => "10:00"
    #    :start_time_am_pm => "PM"
    #    :end_time => "10:50"
    #    :end_time_am_pm => "PM"
    #  }

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