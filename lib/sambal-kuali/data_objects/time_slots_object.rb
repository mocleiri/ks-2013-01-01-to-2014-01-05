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


  def show_time_slots
    go_to_manage_time_slots

    on TimeSlotMaintenance do |page|
      page.select_time_slot_types(term_types)
      page.show_time_slots
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
          :days => "M",
          :start_time => "10:00",
          :start_time_am_pm => "PM",
          :end_time => "10:50",
          :end_time_am_pm => "PM"
      }

      options = defaults.merge(opts)

      set_options(options)
    end

  end

end