# Created data used for testing
#
# CORequisitesData contains CourseOffering
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in  )
#  @editAgenda = make ManageCORequisitesData
#  @editAgenda.create_data_advanced_search(section, course)
# Methods:
#  @initialize(browser, opts={})
#  @navigate(term, course)
#  @data_setup(sect, term, course)
#  @commit_changes( back)
#  @assert_agenda_tree_contents
#  @open_agenda_section
#
# Note the use of the ruby options hash pattern re: setting attribute values

class CORequisitesData
  include Foundry
  include DataFactory

  attr_accessor :submit_btn,
                :section

  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :section => "Student Eligibility & Prerequisite"
    }

    options = defaults.merge(opts)

    set_options(options)
  end

  def navigate(term, course)
    @manageCORdata = make ManageCORequisitesData
    @course_offering = make CourseOffering, {:course => course, :term => term}
    @course_offering.manage
    on ManageCourseOfferings do |page|
      page.loading.wait_while_present
      page.manage_course_offering_requisites
    end
  end

  def data_setup(sect, term, course)
    navigate(term, course)
    on CourseOfferingRequisites do |page|
      page.loading.wait_while_present
      open_agenda_section
      check = @manageCORdata.check_data_existence
      if( check == 0)
        page.rule_add
        @manageCORdata.create_data_advanced_search( sect)
        commit_changes( true)
      else
        page.rule_edit
        check_new = @manageCORdata.check_new_data_existence
        if( check_new == 0)
          page.loading.wait_while_present
          page.rule_edit
          @manageCORdata.create_less_data_advanced_search( sect)
          commit_changes( true)
        end
      end
    end
  end

  def commit_changes( return_to_edit_page = false )
    begin
      on ManageCORequisites do |page|
        page.loading.wait_while_present
        page.update_rule_btn
      end
    rescue Watir::Wait::TimeoutError
      #means Update Rule button already clicked
    end
    on CourseOfferingRequisites do |page|
      page.loading.wait_while_present
      page.submit
    end
    if return_to_edit_page == true
      on ManageCourseOfferings do |page|
        page.loading.wait_while_present
        page.manage_course_offering_requisites
      end
      open_agenda_section
    end
  end

  def open_agenda_section
    sections = {"Student Eligibility & Prerequisite"=>:eligibility_prereq_section,
                "Antirequisite"=>:antirequisite_section, "Corequisite"=>:corequisite_section,
                "Recommended Preparation"=>:recommended_prep_section,
                "Repeatable for Credit"=>:repeatable_credit_section,
                "Course that Restricts Credits"=>:resctricted_credit_section}
    on CourseOfferingRequisites do |page|
      page.loading.wait_while_present
      if( page.send(sections[@section]).element(:tag_name, 'img').attribute_value('alt') != "expand")
        page.send(sections[@section]).when_present.click
      end
    end
  end
end
