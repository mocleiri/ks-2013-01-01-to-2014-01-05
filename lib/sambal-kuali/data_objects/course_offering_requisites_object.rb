class CORequisitesData
  include Foundry
  include DataFactory

  attr_accessor :submit_btn

  def initialize(browser, opts={})
    @browser = browser

    defaults = {
    }

    options = defaults.merge(opts)

    set_options(options)
  end
end
