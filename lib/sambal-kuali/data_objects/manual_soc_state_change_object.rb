class ManualSocStateChange

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  #string - generally set using options hash
  attr_accessor :term,
                :soc_state

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
  def perform_manual_soc_state_change(opts={})
    case opts[:new_soc_state]
      when "Publishing"
        @soc_state = ManualSocStateChange::PUBLISHING_STATE_KEY
      when "In Progress"
        @soc_state = ManualSocStateChange::IN_PROGRESS_STATE_KEY
    end
    if opts[:term] != nil
      @term = opts[:term]
    end

    go_to_manual_soc_state_change
    on ManualSocStateChangePage do |page|
      sleep 2
      page.change_soc_state_termCode.value = @term
      page.change_soc_state_newSocState.value = @soc_state
      page.change_soc_state
    end
  end

end