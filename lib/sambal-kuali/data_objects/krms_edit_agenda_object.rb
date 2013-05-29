class EditAgendaData
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

  def find_krms_before_element( section, tag, node, comp)
    sect = {"edit_tree"=>:edit_tree_section,"preview_tree"=>:preview_tree_section}
    compounds = {"outer compound"=>"_parent_node_0_parent_root_control"}
    on EditAgenda do |page|
      node_i = node.to_i
      node_i -= 1
      return page.send(sect[section]).element(:tag_name => tag, :id => /.*node_#{node_i}#{Regexp.escape(compounds[comp])}.*/).id
    end
  end

  def advanced_search(field, code)
    fields = {"course code"=>:lookup_course_code, "course title"=>:lookup_course_title, "course set"=>:lookup_set_name}
    on EditAgenda do |page|
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
    sleep 6 #adding sleep, moving through the tree too fast causes test to crash
  end

  def navigate( course)
    on KRMSManageCourseOfferings do |page|
      page.loading.wait_while_present
      page.term.when_present.set "201301"
      page.input_code.when_present.set course
      page.show
      page.loading.wait_while_present
      page.manage_course_offering_requisites
    end
  end

  def check_data_existence
    on ManageCOAgendas do |page|
      page.loading.wait_while_present
      if page.rule_edit_links.exists?
        return 1
      else
        return 0
      end
    end
  end

  def create_data_advanced_search( sect, course)
    sections = {"Student Eligibility & Prerequisite"=>:eligibility_prereq, "Antirequisite"=>:antirequisite,
                "Corequisite"=>:corequisite, "Recommended Preparation"=>:recommended_prep,
                "Repeatable for Credit"=>:repeatable_credit, "Course that Restricts Credits"=>:resctricted_credit}

    navigate(course)

    on ManageCOAgendas do |page|
      page.loading.wait_while_present
      page.send(sections[sect])
    end

    check = check_data_existence
    if( check == 0)
      on ManageCOAgendas do |page|
        page.rule_add
      end

      on EditAgenda do |page|
        page.add_btn
        if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
          page.rule_dropdown.when_present.select /Must have successfully completed <course>/
        elsif( sect == "Antirequisite" || sect == "Course that Restricts Credits")
          page.rule_dropdown.when_present.select /Must not have successfully completed <course>/
        elsif( sect == "Corequisite")
          page.rule_dropdown.when_present.select /Must be concurrently enrolled in <course>/
        elsif( sect == "Repeatable for Credit")
          #page.rule_dropdown.when_present.select /Must have successfully completed <course>/
        end
        advanced_search("course code", "ENGL101")
        page.preview_btn

        page.add_btn
        if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
          page.rule_dropdown.when_present.select /Must have successfully completed <course>/
        elsif( sect == "Antirequisite" || sect == "Course that Restricts Credits")
          page.rule_dropdown.when_present.select /Must not have successfully completed <course>/
        elsif( sect == "Corequisite")
          page.rule_dropdown.when_present.select /Must be concurrently enrolled in <course>/
        elsif( sect == "Repeatable for Credit")
          #page.rule_dropdown.when_present.select /Must have successfully completed <course>/
        end
        advanced_search("course code", "HIST639")
        page.preview_btn

        page.add_btn
        page.rule_dropdown.when_present.select /Free Form Text/
        page.free_text_field.when_present.set "free form text input value"
        page.preview_btn

        page.edit_tree_section.span(:text => /.*A\..*/).when_present.click
        page.group_btn
        if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
          page.rule_dropdown.when_present.select /Must have successfully completed all courses from <courses>/
        elsif( sect == "Antirequisite" || sect == "Course that Restricts Credits")
          page.rule_dropdown.when_present.select /Must not have successfully completed any courses from <courses>/
        elsif( sect == "Corequisite")
          page.rule_dropdown.when_present.select /Must be concurrently enrolled in all courses from <courses>/
        elsif( sect == "Repeatable for Credit")
          #page.rule_dropdown.when_present.select /Must have successfully completed <course>/
        end
        page.multi_course_dropdown.when_present.select /Approved Courses/
        advanced_search("course code", "ENGL478")
        page.add_line_btn
        page.adding.wait_while_present
        advanced_search("course code", "HIST416")
        page.add_line_btn
        page.adding.wait_while_present
        page.preview_btn

        page.add_btn
        page.rule_dropdown.when_present.select /Free Form Text/
        page.free_text_field.when_present.set "Text"
        page.preview_btn

        page.edit_tree_section.span(:text => /.*F\..*/).when_present.click
        page.group_btn
        page.rule_dropdown.when_present.select /Free Form Text/
        page.free_text_field.when_present.set "Text to copy"
        page.preview_btn

        page.edit_tree_section.span(:text => /.*D\..*/).when_present.click
        page.add_btn
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
          #page.rule_dropdown.when_present.select /Must have successfully completed <course>/
        elsif( sect == "Course that Restricts Credits")
          page.rule_dropdown.when_present.select /Must not have successfully completed any courses from <courses>/
        end
        page.multi_course_dropdown.when_present.select /Approved Courses/
        advanced_search("course code", "HIST395")
        page.add_line_btn
        page.adding.wait_while_present
        advanced_search("course code", "HIST210")
        page.add_line_btn
        page.adding.wait_while_present
        page.preview_btn

        page.loading.wait_while_present
        page.edit_tree_section.select(:id => /u\d+_node_3_parent_node_0_parent_root_control/).when_present.select "OR"
        page.edit_loading.wait_while_present
        page.edit_tree_section.select(:id => /u\d+_node_1_parent_node_2_parent_node_0_parent_node_0_parent_root_control/).when_present.select "OR"

        page.edit_loading.wait_while_present
        page.update_rule_btn
      end

      on ManageCOAgendas do |page|
        page.submit
      end

      on KRMSManageCourseOfferings do |page|
        page.manage_course_offering_requisites
      end

      on ManageCOAgendas do |page|
        page.send(sections[sect])
      end
    end
  end

  def create_string_for_testing( section,text)
    if( text !~ /.*\(.+,.+\).*/)
      array = text.split(/,/)

      array.each do |elem|
        new_text += ".*" + elem
      end

      return new_text
    else
      return text
    end
  end
end