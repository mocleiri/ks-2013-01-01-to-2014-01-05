# Created data used for testing
#
# ManageCORequisitesData contains CourseOffering
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in  )
#  @editAgenda = make ManageCORequisitesData
#  @editAgenda.create_data_advanced_search(section, course)
# Methods:
#  @advanced_search(field, code)
#  @check_data_existence
#  @create_data_advanced_search( sect, course)
#  @create_course_rule( course, sect)
#  @create_text_rule( text)
#  @create_all_courses_rule( courses, sect)
#  @create_number_courses_rule( courses, sect)
#
# Note the use of the ruby options hash pattern re: setting attribute values

class ManageCORequisitesData
  include Foundry
  include DataFactory

  attr_accessor :select_rule

  def initialize(browser, opts={})
    @browser = browser

    defaults = {
    }

    options = defaults.merge(opts)

    set_options(options)
  end
  #this method will be removed at some point
  def find_krms_before_element( section, tag, node, comp)
    sect = {"edit_tree"=>:edit_tree_section,"preview_tree"=>:preview_tree_section}
    compounds = {"outer compound"=>"_parent_node_0_parent_root_control"}
    on ManageCORequisites do |page|
      node_i = node.to_i
      node_i -= 1
      return page.send(sect[section]).element(:tag_name => tag, :id => /.*node_#{node_i}#{Regexp.escape(compounds[comp])}.*/).id
    end
  end

  def advanced_search(field, code)
    fields = {"course code"=>:lookup_course_code, "course title"=>:lookup_course_title, "course set"=>:lookup_set_name}
    on ManageCORequisites do |page|
      page.edit_loading.wait_while_present
      page.search_link
      page.send(fields[field]).when_present.set code
      page.lookup_search_button
      page.loading.wait_while_present
      if( field == "course code" || field == "course set")
        page.lookup_results.a(:title => /.*#{Regexp.escape(code)}.*/).click
      else
        #TODO - find a way to return course code randomly when searching for title or description
      end
    end
    #sleep 3 #adding sleep, moving through the tree too fast causes test to crash
  end

  def check_data_existence
    on CourseOfferingRequisites do |page|
      page.loading.wait_while_present
      if page.rule_edit_links.exists?
        return 1
      else
        return 0
      end
    end
  end

  def create_data_advanced_search( sect, term, course)
    sections = {"Student Eligibility & Prerequisite"=>:eligibility_prereq, "Antirequisite"=>:antirequisite,
                "Corequisite"=>:corequisite, "Recommended Preparation"=>:recommended_prep,
                "Repeatable for Credit"=>:repeatable_credit, "Course that Restricts Credits"=>:resctricted_credit}

    @course_offering = make CourseOffering, {:course => course, :term => term}
    @course_offering.manage

    on ManageCourseOfferings do |page|
      page.manage_course_offering_requisites
    end

    on CourseOfferingRequisites do |page|
      page.loading.wait_while_present
      page.send(sections[sect])
    end

    check = check_data_existence
    if( check == 0)
      on CourseOfferingRequisites do |page|
        page.rule_add
      end

      on ManageCORequisites do |page|
        page.add_btn
        create_course_rule( "ENGL101", sect)
        page.add_btn
        create_course_rule( "HIST639", sect)
        page.add_btn
        create_text_rule( "free form text input value")
        page.edit_tree_section.span(:text => /.*A\..*/).when_present.click
        page.group_btn
        create_all_courses_rule(  ["ENGL478", "HIST416"], sect)
        page.add_btn
        create_text_rule( "Text")
        page.edit_tree_section.span(:text => /.*F\..*/).when_present.click
        page.group_btn
        create_text_rule( "Text to copy")
        page.edit_tree_section.span(:text => /.*D\..*/).when_present.click
        page.add_btn
        create_number_courses_rule( ["HIST395", "HIST210"], sect)
        page.loading.wait_while_present
        page.edit_tree_section.select(:id => /u\d+_node_3_parent_node_0_parent_root_control/).when_present.select "OR"
        page.edit_loading.wait_while_present
        page.edit_tree_section.select(:id => /u\d+_node_1_parent_node_2_parent_node_0_parent_node_0_parent_root_control/).when_present.select "OR"
        page.edit_loading.wait_while_present
        page.update_rule_btn
      end

      on CourseOfferingRequisites do |page|
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

  def edit_data_advanced_search( sect, term, course)
    sections = {"Student Eligibility & Prerequisite"=>:eligibility_prereq, "Antirequisite"=>:antirequisite,
                "Corequisite"=>:corequisite, "Recommended Preparation"=>:recommended_prep,
                "Repeatable for Credit"=>:repeatable_credit, "Course that Restricts Credits"=>:resctricted_credit}

    @course_offering = make CourseOffering, {:course => course, :term => term}
    @course_offering.manage

    on ManageCourseOfferings do |page|
      page.manage_course_offering_requisites
    end

    on CourseOfferingRequisites do |page|
      page.loading.wait_while_present
      page.send(sections[sect])
      page.rule_edit
    end

    on ManageCORequisites do |page|
      page.edit_tree_section.span(:text => /.*C\..*/).when_present.click
      page.add_btn
      create_course_rule( "ENGL101", sect)
      page.group_btn
      create_text_rule( "free form text input value")
      page.edit_tree_section.span(:text => /.*B\..*/).when_present.click
      page.group_btn
      create_all_courses_rule(  ["ENGL478", "HIST416"], sect)
      page.add_btn
      create_text_rule( "Text")
      page.edit_tree_section.span(:text => /.*F\..*/).when_present.click
      page.group_btn
      create_number_courses_rule( ["HIST395", "HIST210"], sect)
      page.loading.wait_while_present
      page.edit_tree_section.select(:id => /u\d+_node_3_parent_node_0_parent_root_control/).when_present.select "AND"
      page.edit_loading.wait_while_present
      page.edit_tree_section.select(:id => /u\d+_node_1_parent_node_0_parent_node_0_parent_root_control/).when_present.select "OR"
      page.edit_loading.wait_while_present
      page.update_rule_btn
    end

    on CourseOfferingRequisites do |page|
      page.submit
    end

    on ManageCourseOfferings do |page|
      page.manage_course_offering_requisites
    end

    on CourseOfferingRequisites do |page|
      page.send(sections[sect])
    end
  end

  def create_course_rule( course, sect)
    on ManageCORequisites do |page|
      if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
        page.rule_dropdown.when_present.select /Must have successfully completed <course>/
      elsif( sect == "Antirequisite" || sect == "Course that Restricts Credits")
        page.rule_dropdown.when_present.select /Must not have successfully completed <course>/
      elsif( sect == "Corequisite")
        page.rule_dropdown.when_present.select /Must be concurrently enrolled in <course>/
      elsif( sect == "Repeatable for Credit")
        page.rule_dropdown.when_present.select /May not repeat <course>/
      end
      advanced_search("course code", course)
      page.preview_btn
    end
  end

  def create_text_rule( text)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Free Form Text/
      page.free_text_field.when_present.set text
      page.preview_btn
    end
  end

  def create_all_courses_rule( courses, sect)
    on ManageCORequisites do |page|
      if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
        page.rule_dropdown.when_present.select /Must have successfully completed all courses from <courses>/
      elsif( sect == "Antirequisite" || sect == "Course that Restricts Credits")
        page.rule_dropdown.when_present.select /Must not have successfully completed any courses from <courses>/
      elsif( sect == "Corequisite")
        page.rule_dropdown.when_present.select /Must be concurrently enrolled in all courses from <courses>/
      elsif( sect == "Repeatable for Credit")
        page.rule_dropdown.when_present.select /May not repeat any of <courses>/
      end
      page.multi_course_dropdown.when_present.select /Approved Courses/
      courses.each do |course|
        advanced_search("course code", course)
        page.add_line_btn
        page.adding.wait_while_present
      end
      page.preview_btn
    end
  end

  def create_number_courses_rule( courses, sect)
    on ManageCORequisites do |page|
      if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
        page.rule_dropdown.when_present.select /Must have successfully completed a minimum of <n> courses from <courses>/
        page.integer_field.when_present.set "1"
      elsif( sect == "Antirequisite")
        page.rule_dropdown.when_present.select /Must successfully complete no more than <n> credits from <courses>/
        page.integer_field.when_present.set "4"
      elsif( sect == "Corequisite")
        page.rule_dropdown.when_present.select /Must be concurrently enrolled in a minimum of <n> courses from <courses>/
        page.integer_field.when_present.set "1"
      elsif( sect == "Repeatable for Credit")
        page.rule_dropdown.when_present.select /May not repeat any of <courses>/
      elsif( sect == "Course that Restricts Credits")
        page.rule_dropdown.when_present.select /Must not have successfully completed any courses from <courses>/
      end
      page.multi_course_dropdown.when_present.select /Approved Courses/
      courses.each do |course|
        advanced_search("course code", course)
        page.add_line_btn
        page.adding.wait_while_present
      end
      page.preview_btn
    end
  end

  def test_multiline_text(section, text, boolean)
    sect = {"edit"=>:edit_tree_section, "logic"=>:preview_tree_section}
    test_text = text.split(/,/)
    test_text.each do |elem|
      if( section == "agenda")
        on CourseOfferingRequisites do |page|
          page.loading.wait_while_present
          if boolean == true
            page.agenda_management_section.text.should =~ /.*#{Regexp.escape(elem)}.*/
          else
            page.agenda_management_section.text.should_not =~ /.*#{Regexp.escape(elem)}.*/
          end
        end
      elsif section == "compare"
        on CourseOfferingRequisites do |page|
          page.loading.wait_while_present
          if boolean == true
            page.compare_tree.text.should =~ /.*#{Regexp.escape(elem)}.*\n.*#{Regexp.escape(elem)}.*/m
          else
            page.compare_tree.text.should_not =~ /.*#{Regexp.escape(elem)}.*\n.*#{Regexp.escape(elem)}.*/m
          end
        end
      else
        on ManageCORequisites do |page|
          page.loading.wait_while_present
          if boolean == true
            page.send(sect[section]).text.should =~ /.*#{Regexp.escape(elem)}.*/
          else
            page.send(sect[section]).text.should_not =~ /.*#{Regexp.escape(elem)}.*/
          end
        end
      end
    end
  end
end