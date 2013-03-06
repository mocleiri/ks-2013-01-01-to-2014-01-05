#$test_site = "http://localhost:8081/ks-with-rice-bundled-dev" #Local Env
$test_site = "http://env2.ks.kuali.org" # TODO: This needs some serious re-thinking. Should come from a yaml config file instead of being explicitly declared here.

$: << File.dirname(__FILE__)+'/../../lib'

require 'sambal-kuali'

World Foundry
World StringFactory
World DateFactory
World Workflows

client = Selenium::WebDriver::Remote::Http::Default.new
#client.timeout = 15 # seconds default is 60

browser = nil
headless = nil

if ENV['HEADLESS']
  require 'headless'
  headless = Headless.new :destroy_at_exit => false
  headless.start
end

Before do
  if browser == nil
    browser = Watir::Browser.new :firefox, :http_client => client
  end
  @browser = browser
end

at_exit { browser.close unless browser == nil }


if ENV['HEADLESS']
  #at_exit do
  #  headless.destroy
  #end

  After do | scenario |
    if scenario.failed?
      @browser.close
      browser = nil
    end
  end
end