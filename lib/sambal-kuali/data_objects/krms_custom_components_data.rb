class CustomComponentsData
  include Foundry
  include DataFactory

  attr_accessor :course, :gpa, :test_score, :test_name, :department, :organization, :grade_select

  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :course=>random_alphanums,
        :gpa=>"0.0",
        :test_score=>"0",
        :test_name=>random_alphanums,
        :department=>random_alphanums,
        :organization=>random_alphanums
    }

    set_options(defaults.merge(opts))
  end
end