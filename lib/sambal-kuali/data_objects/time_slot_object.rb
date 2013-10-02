# Stores test data for creating/editing and validating time slots
#
# Class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#  @time_slot = mame TimeSlot, [:days => "", ...]
#  @time_slot.create
# OR alternatively 2 steps together as
#  @time_slot = create TimeSlot, [:days => "", ...]
#
# Note the use of the ruby options hash pattern re: setting attribute values
class TimeSlot
  include Workflows

  # type: string generally set using options hash
  attr_accessor :code,
                :term_type,
                :days,
                :start_time,
                :end_time

  # provides default data:
  #
  #  defaults = {
  #    :code => ""
  #    :term_type => "FallFull"
  #    :days => "MWF"
  #    :start_time => "9:00 AM"
  #    :end_time => "9:40 AM"
  #  }

  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :code => "",
        :term_type => "Fall - Full",
        :days => "MWF",
        :start_time => "9:00 AM",
        :end_time => "9:40 AM"
    }

    options = defaults.merge(opts)

    set_options(options)
  end

  # navigates to manage time slots page and creates timeslot(s) based on class attributes
  def create
    # TO DO
  end

end