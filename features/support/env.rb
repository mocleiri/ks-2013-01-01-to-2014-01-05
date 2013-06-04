#$test_site = "http://localhost:8081/ks-with-rice-bundled-dev" #Local Env
$test_site = "http://env2.ks.kuali.org"
$test_site = ENV['TEST_SITE'] unless ENV['TEST_SITE'] == nil
$distributed_env = ENV['DISTRIBUTED_ENV']

$: << File.dirname(__FILE__)+'/../../lib'

require 'sambal-kuali'
require 'watir-webdriver/extensions/alerts' # required to deal with BROWSER-alerts (as opposed to JS-alerts)

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
    puts "debug -- creating new browser"
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
      @browser.close unless @browser == nil
      browser = nil
    end
  end
end