# stores test data for performing and validating term rollovers and provides convenience methods for navigation and data entry
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#   @rollover = make Rollover, [:source_term => "201201",:target_term=>"202101"]
#   @rollover.perform_rollover
#
#  will automatically select next valid target_term
#
# Note the use of the ruby options hash pattern re: setting attribute values
class Rollover

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  #generally set using options hash
  attr_accessor :source_term,
                :target_term

  SOC_STATES_SOURCE_TERM = "201212"

  PUBLISHED_SOC_TERM = "201512"
  FINAL_EDITS_SOC_TERM = "201612"
  OPEN_SOC_TERM = "201712"
  DRAFT_SOC_TERM = "201812"

  MAIN_TEST_TERM_SOURCE = "201201"
  MAIN_TEST_TERM_TARGET = "202001"

  # provides default data:
  #  defaults = {
  #    :source_term=>"201201",
  #    :target_term=>"202101"
  #  }
  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :source_term=>"201212",
        :target_term=>"202112"
    }
    options = defaults.merge(opts)
    set_options(options)
  end

  #performs rollover, will increment target term year until rollover button is enabled
  #(ie searches for valid target term)
  #
  #@raises exception if the rollover cannot be successfully initiated
  def perform_rollover
    go_to_perform_rollover
    on PerformRollover do |page|
      @target_term = page.select_terms(@target_term,@source_term)
      raise "source_term_code issue" unless  page.source_term_code == @source_term
      raise "target_term_code issue" unless  page.target_term_code == @target_term

      puts "Rollover initiated - source term: #{@source_term}"
      puts "Rollover initiated - target term: #{@target_term}"
      page.rollover_course_offerings
      raise "rollover issue" unless page.status == "In Progress"
    end
  end

  #polls rollover status for 20 mins
  #
  #@raises exception if the rollover is not completed within test timeout limit
  def wait_for_rollover_to_complete
    go_to_rollover_details
    on RolloverDetails do |page|
      page.term.set @target_term
      page.go
      poll_ctr = 0
      while page.status != "Finished" and poll_ctr < 80     #will wait 40 mins
        poll_ctr = poll_ctr + 1
        sleep 30
        page.go
      end
      if page.status == "Finished"
        puts "Completed: Rollover duration: #{page.rollover_duration}"
        puts "Course Offerings transitioned: #{page.course_offerings_transitioned}"
        puts "Course Offerings exceptions: #{page.course_offerings_exceptions}"
        puts "Activity Offerings transitioned: #{page.activity_offerings_transitioned}"
        puts "Activity Offerings exceptions: #{page.activity_offerings_exceptions}"
      else
        raise "rollover did not complete - test timed out"
      end
    end
  end

  #release rollover to depts in target term
  #
  #@raises exception if the rollover cannot be released
  def release_to_depts
    go_to_rollover_details
    on RolloverDetails do |page|
      page.term.set @target_term
      page.go
      raise "rollover details - release to depts not enabled" unless page.release_to_departments_button.enabled?
      page.release_to_departments
    end

    on RolloverConfirmReleaseToDepts do |page|
      page.confirm
      page.release_to_departments
    end

    on RolloverDetails do |page|
      raise "release to depts not completed" unless page.status_detail_msg =~ /have been released to the departments/
    end
  end

end
