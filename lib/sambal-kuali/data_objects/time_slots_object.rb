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

  attr_accessor :term_types,
                :time_slots

  # provides default data:
  #
  #  defaults = {
  #     :term_types => [ "Fall - Full" ]
  #     :time_slots => []
  #  }

  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :term_types => [ "Fall - Full" ],
        :time_slots => []
    }

    options = defaults.merge(opts)

    set_options(options)
  end

  def show_time_slots
    go_to_manage_time_slots

    on TimeSlotMaintenance do |page|
      page.select_time_slot_types(term_types)
      page.show_time_slots

      time_slot_search_results_array = page.time_slot_search_results_table.to_a
      time_slot_search_results_array.each_with_index do |row, index|
        unless index == 0 || index == time_slot_search_results_array.length-1
          time_slots << ( make TimeSlot, :code => row[TimeSlotMaintenance::TIME_SLOT_RESULTS_CODE],
                                         :term_type => row[TimeSlotMaintenance::TIME_SLOT_RESULTS_TERM_TYPE],
                                         :days => row[TimeSlotMaintenance::TIME_SLOT_RESULTS_DAYS],
                                         :start_time => row[TimeSlotMaintenance::TIME_SLOT_RESULTS_START_TIME].split(' ')[0],
                                         :start_time_am_pm => row[TimeSlotMaintenance::TIME_SLOT_RESULTS_START_TIME].split(' ')[1],
                                         :end_time => row[TimeSlotMaintenance::TIME_SLOT_RESULTS_END_TIME].split(' ')[0],
                                         :end_time_am_pm => row[TimeSlotMaintenance::TIME_SLOT_RESULTS_END_TIME].split(' ')[1] )
        end
      end
    end

  end

  # navigates to manage time slots page and creates timeslot(s) based on class attributes
  def add_time_slot( time_slot )
    on TimeSlotMaintenance do |page|
      page.initiate_add_time_slot
      page.add_time_slot_popup_field_termType.select time_slot.term_type
      page.add_time_slot_popup_field_days.set time_slot.days
      page.add_time_slot_popup_field_startTime.set time_slot.start_time
      page.add_time_slot_popup_field_startTime_am_pm.select time_slot.start_time_am_pm.downcase
      page.add_time_slot_popup_field_endTime.set time_slot.end_time
      page.add_time_slot_popup_field_endTime_am_pm.select time_slot.end_time_am_pm.downcase
      page.save_add_time_slot
    end

    time_slots << time_slot
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
    #    :days => "MWF"
    #    :start_time => "9:00"
    #    :start_time_am_pm => "AM"
    #    :end_time => "9:40"
    #    :end_time_am_pm => "AM"
    #  }

    # initialize is generally called using TestFactory Foundry .make or .create methods
    def initialize(browser, opts={})
      @browser = browser

      defaults = {
          :code => "",
          :term_type => "Fall - Full",
          :days => "MWF",
          :start_time => "9:00",
          :start_time_am_pm => "AM",
          :end_time => "9:40",
          :end_time_am_pm => "AM"
      }

      options = defaults.merge(opts)

      set_options(options)
    end

  end

end