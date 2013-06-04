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
      page.manage_course_offering_requisites
    end
  end

  def data_setup(change, sect, term, course)
    sections = {"Student Eligibility & Prerequisite"=>:eligibility_prereq, "Antirequisite"=>:antirequisite,
                "Corequisite"=>:corequisite, "Recommended Preparation"=>:recommended_prep,
                "Repeatable for Credit"=>:repeatable_credit, "Course that Restricts Credits"=>:resctricted_credit}
    navigate(term, course)

    on CourseOfferingRequisites do |page|
      page.loading.wait_while_present
      page.send(sections[sect])
      if change == "setup"
        check = @manageCORdata.check_data_existence
        if( check == 0)
          page.rule_add
          @manageCORdata.create_data_advanced_search(sect)
        end
      else
        page.rule_edit
        @manageCORdata.edit_data_advanced_search(sect)
      end
      page.submit
    end

    on ManageCourseOfferings do |page|
      page.manage_course_offering_requisites
    end

    on CourseOfferingRequisites do |page|
      page.send(sections[sect])
    end
  end
end
