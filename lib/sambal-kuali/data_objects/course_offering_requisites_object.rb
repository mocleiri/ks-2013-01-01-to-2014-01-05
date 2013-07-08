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
      :section => "Student Eligibility & Prerequisite",
      :term => "201208",
      :course => "ENGL101"
    }

    options = defaults.merge(opts)

    set_options(options)
  end

  def navigate_to_mco_requisites
    @manageCORdata = make ManageCORequisitesData
    @course_offering = make CourseOffering, {:course => @course, :term => @term}
    @course_offering.manage
    on ManageCourseOfferings do |page|
      page.loading.wait_while_present(200)
      page.manage_course_offering_requisites
    end
  end

  def data_setup
    navigate_to_mco_requisites
    on CourseOfferingRequisites do |page|
      page.loading.wait_while_present
      open_agenda_section
      if page.rule_edit_links.exists?
        page.rule_edit
        page.loading.wait_while_present
        @manageCORdata.create_less_data_advanced_search( @section)
        commit_changes( true)
      else
        page.rule_add
        @manageCORdata.create_data_advanced_search( @section)
        commit_changes( true)
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
      page.loading.wait_while_present(200)
    end
    if return_to_edit_page == true
      on ManageCourseOfferings do |page|
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
      page.loading.wait_while_present(60)
      if( page.send(sections[@section]).element(:tag_name, 'img').attribute_value('alt') != "expand")
        page.send(sections[@section]).when_present.click
      end
    end
  end
end
