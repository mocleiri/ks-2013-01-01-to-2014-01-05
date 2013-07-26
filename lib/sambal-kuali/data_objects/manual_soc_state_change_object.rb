class ManualSocStateChange

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  #string - generally set using options hash
  attr_accessor :term,
                :soc_state

  OPEN_STATE_KEY = "kuali.soc.state.open"
  PUBLISHING_STATE_KEY = "kuali.soc.state.publishing"
  IN_PROGRESS_STATE_KEY = "kuali.soc.scheduling.state.inprogress"

  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :term => Rollover::SOC_STATES_SOURCE_TERM,
        :soc_state => ManualSocStateChange::PUBLISHING_STATE_KEY
    }
    options = defaults.merge(opts)
    set_options(options)
  end

  # initiates a manual SOC state-change
  #
  # @example
  #   @manual_soc_state_change.perform_manual_soc_state_change :new_soc_state => "Publishing"
  #
  # @param opts [Hash] {:new_soc_state => "Publishing" (default is "Open")}
  def perform_manual_soc_state_change(opts={})
    case opts[:new_soc_state]
      when "Publishing"
        @soc_state = ManualSocStateChange::PUBLISHING_STATE_KEY
      when "In Progress"
        @soc_state = ManualSocStateChange::IN_PROGRESS_STATE_KEY
      else
        @soc_state = ManualSocStateChange::OPEN_STATE_KEY
    end

    visit ManualSocStateChangePage
    on ManualSocStateChangePage do |page|
      page.change_soc_state_termCode.value = @term
      page.change_soc_state_newSocState.value = @soc_state
      page.change_soc_state
    end
  end

end