# Created data used for testing
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in  )
#  @manageCOR = make ManageCORequisitesData
#  @editAgenda.create_data_advanced_search(section, course)
# Methods:
#  @advanced_search(field, code)
#  @check_data_existence
#  @check_new_data_existence
#  @create_data_advanced_search( sect)
#  @edit_data_advanced_search( sect)
#  @create_course_rule( course, sect)
#  @create_text_rule( text)
#  @create_all_courses_rule( courses, sect)
#  @create_number_courses_rule( courses, sect)
#  @edit_existing_node(node, field, code)
#  @add_new_node(field, node, code)
#  @create_new_group(sect, field, node, course, set)
#  @switch_tabs
#  @check_text_correct( text, correct, section)
#  @convert_text( text, page)
#  @test_text(section, text, boolean)
#  @test_multi_line_text( section, test_string, boolean)
#  @test_single_line_text( section, test_text, boolean)
#  @test_popup_text( text, boolean)
#  @change_operator(level, operator)
#  @test_node_level( level, node)
#  @move_around( node, direction)
#  @copy_cut_paste( node, node_after, action)
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

  def advanced_search(field, code)
    on ManageCORequisites do |page|
      page.edit_loading.wait_while_present
      if field == "course code"
        click_search_link( Regexp.new(".*editTree.+proposition\.courseInfo\.code"))
        page.lookup_course_code.when_present.set code
      elsif field == "courses code"
        click_search_link( Regexp.new(".*editTree.+proposition\.cluSet\.clus"))
        page.lookup_course_code.when_present.set code
      elsif field == "course title"
        click_search_link( Regexp.new(".*editTree.+proposition\.cluSet\.clus"))
        page.lookup_course_title.when_present.set code
      elsif field == "course set"
        click_search_link( Regexp.new(".*editTree.+proposition\.cluSet\.cluSets"))
        page.lookup_set_name.when_present.set code
      elsif field == "program code"
        click_search_link( Regexp.new(".*editTree.+proposition\.progCluSet\.clus"))
        page.lookup_course_code.when_present.set code
      elsif field == "class standing"
        click_search_link( Regexp.new(".*editTree.+proposition\.classStanding"))
        page.lookup_class_standing.when_present.set code
      elsif field == "org"
        click_search_link( Regexp.new(".*editTree.+proposition\.orgInfo\.id"))
        page.lookup_abrev_org.when_present.set code
      end
      page.lookup_search_button
      page.loading.wait_while_present
      page.lookup_results.a(:title => /.*#{Regexp.escape(code)}.*/i).when_present.click
    end
  end

  def click_search_link( regex)
    on ManageCORequisites do |page|
      elements = page.edit_tree_section.elements( :tag_name, 'a')
      elements.each do |elem|
        if elem.text == "Advanced Search" && page.edit_tree_section.a( id: elem.id).attribute_value('data-submit_data') =~ regex
          page.edit_tree_section.a(id: elem.id).click
          break
        end
      end
    end
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

  def check_new_data_existence
    on ManageCORequisites do |page|
      page.logic_tab.click
      page.edit_loading.wait_while_present
      text = page.logic_text.text
      array = text.split('(')
      page.update_rule_btn
      if array.length >= 3
        return 1
      else
        return 0
      end
    end
  end

  def create_data_advanced_search( sect)
    on ManageCORequisites do |page|
      create_course_rule( "add", "", "ENGL101", sect)
      create_course_rule( "add", "", "HIST639", sect)
      create_text_rule( "add", "", "free form text input value")
      create_all_courses_rule( "group", "A", "ENGL478,HIST416", "", "", sect)
      create_text_rule( "add", "", "Text")
      create_text_rule( "group", "D", "Text to copy")
      create_number_courses_rule( "add", "C", "1", "HIST395,HIST210", "", "", sect)
      page.loading.wait_while_present
      page.edit_tree_section.select(:id => /u\d+_node_\d+_parent_node_0_parent_root_control/).when_present.select "OR"
      page.edit_loading.wait_while_present
      page.edit_tree_section.select(:id => /u\d+_node_\d+_parent_node_\d+_parent_node_\d+_parent_node_0_parent_root_control/).when_present.select "OR"
      page.edit_loading.wait_while_present
    end
  end

  def create_less_data_advanced_search( sect)
    on ManageCORequisites do |page|
      create_course_rule( "add", "B", "ENGL101", sect)
      create_text_rule( "group", "A", "free form text input value")
      create_all_courses_rule( "add", "", "ENGL478,HIST416", "", "", sect)
      create_text_rule( "group", "D", "Text")
      create_number_courses_rule( "add", "C", "1", "HIST395,HIST210", "", "", sect)
      page.loading.wait_while_present
      page.edit_tree_section.select(:id => /u\d+_node_\d+_parent_node_0_parent_root_control/).when_present.select "OR"
      page.edit_loading.wait_while_present
      page.edit_tree_section.select(:id => /u\d+_node_\d+_parent_node_\d+_parent_node_0_parent_root_control/).when_present.select "OR"
      page.edit_loading.wait_while_present
    end
  end

  def create_course_rule( group, node, course, sect)
    add_new_node( group, node)
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

  def create_text_rule( group, node, text)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Free Form Text/
      page.free_text_field.when_present.set text
      page.preview_btn
    end
  end

  def create_all_courses_rule( group, node, course, set, range, sect)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
        page.rule_dropdown.when_present.select /Must have successfully completed all courses from <courses>/
      elsif( sect == "Antirequisite" || sect == "Course that Restricts Credits")
        page.rule_dropdown.when_present.select /Must not have successfully completed any courses from <courses>/
      elsif( sect == "Corequisite")
        page.rule_dropdown.when_present.select /Must be concurrently enrolled in all courses from <courses>/
      end
      add_courses( course, set, range)
      page.preview_btn
    end
  end

  def create_number_courses_rule( group, node, number, course, set, range, sect)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
        page.rule_dropdown.when_present.select /Must have successfully completed a minimum of <n> courses from <courses>/
        page.integer_field.when_present.set number
      elsif( sect == "Corequisite")
        page.rule_dropdown.when_present.select /Must be concurrently enrolled in a minimum of <n> courses from <courses>/
        page.integer_field.when_present.set number
      end
      add_courses( course, set, range)
      page.preview_btn
    end
  end

  def create_less_number_courses_rule( group, node, number, course, set, range, sect)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
        page.rule_dropdown.when_present.select /Must have successfully completed no more than <n> courses from <courses>/
        page.integer_field.when_present.set number
      elsif( sect == "Corequisite")
        page.rule_dropdown.when_present.select /Must be concurrently enrolled in a minimum of <n> courses from <courses>/
        page.integer_field.when_present.set number
      end
      add_courses( course, set, range)
      page.preview_btn
    end
  end

  def create_less_credits_rule( group, node, number, course, set, range)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must successfully complete no more than <n> credits from <courses>/
      page.integer_field.when_present.set number
      add_courses( course, set, range)
      page.preview_btn
    end
  end

  def create_any_credits_rule( group, node, course, set, range)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must not have successfully completed any credits from <courses>/
      add_courses( course, set, range)
      page.preview_btn
    end
  end

  def create_repeated_credit_rule( group, node, number)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /May be repeated for a maximum of <n> credits/
      page.integer_field.when_present.set number
      page.preview_btn
    end
  end

  def create_grade_courses_rule( group, node, course, set, range, type, grade, sect)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
        page.rule_dropdown.when_present.select /Must have earned a minimum grade of <gradeType> <grade> in <courses>/
      elsif( sect == "Antirequisite")
        page.rule_dropdown.when_present.select /Must not have earned a grade of <gradeType> <grade> or higher in <courses>/
      end
      choose_grade_type_grade( grade, type)
      add_courses( course, set, range)
      page.preview_btn
    end
  end

  def create_grade_number_courses_rule( group, node, course, set, range, type, grade, number)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must successfully complete a minimum of <n> courses from <courses> with a minimum grade of <gradeType> <grade>/
      page.integer_field.when_present.set number
      add_courses( course, set, range)
      choose_grade_type_grade( grade, type)
      page.preview_btn
    end
  end

  def create_gpa_courses_rule( group, node, course, set, range, gpa)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must have earned a minimum GPA of <GPA> in <courses>/
      page.integer_field.when_present.set gpa
      add_courses( course, set, range)
      page.preview_btn
    end
  end

  def create_gpa_duration_rule( group, node, gpa, type, duration)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must have earned a minimum cumulative GPA of <GPA> in <duration><durationType>/
      page.integer_field.when_present.set gpa
      page.duration_field.when_present.set duration
      page.duration_dropdown.when_present.select type
      page.preview_btn
    end
  end

  def create_gpa_rule( group, node, gpa)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must have earned a minimum cumulative GPA of <GPA>/
      page.integer_field.when_present.set gpa
      page.preview_btn
    end
  end

  def create_program_rule( group, node, program, sect)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
        page.rule_dropdown.when_present.select /Must have been admitted to the <program> program/
      elsif( sect == "Antirequisite")
        page.rule_dropdown.when_present.select /Must not have been admitted to the <program> program/
      end
      add_program( program)
      page.preview_btn
    end
  end

  def create_any_program_rule( group, node)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must be admitted to any program offered at the course campus location/
      page.edit_loading.wait_while_present
      page.preview_btn
    end
  end

  def create_permission_instructor_rule( group, node)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Permission of instructor required/
      page.edit_loading.wait_while_present
      page.preview_btn
    end
  end

  def create_course_term_rule( group, node, course, term, prior_or_as = "as of")
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must have successfully completed <course> #{Regexp.escape(prior_or_as)} <term>/
      advanced_search("course code", course)
      page.term_field.set term
      page.preview_btn
    end
  end

  def create_course_between_terms_rule( group, node, course, term1, term2)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must have successfully completed <course> between <term1> and <term2>/
      advanced_search("course code", course)
      page.term_field.set term1
      page.term_two_field.set term2
      page.preview_btn
    end
  end

  def create_program_class_standing_rule( group, node, program, stand)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must not have been admitted to the <program> program with a class standing of <class standing>/
      add_program( program)
      add_class_standing( stand)
      page.preview_btn
    end
  end

  def create_program_org_rule( group, node, org)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must have been admitted to a program offered by <org>/
      add_org(org)
      page.preview_btn
    end
  end

  def create_class_standing_rule( group, node, stand, equals, sect)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      if equals == "="
        if( sect == "Student Eligibility & Prerequisite" || sect == "Recommended Preparation")
          page.rule_dropdown.when_present.select /Student must be in a class standing of <class standing>/
        elsif( sect == "Antirequisite")
          page.rule_dropdown.when_present.select /Must not be in a class standing of <class standing>/
        end
      elsif equals == ">"
        page.rule_dropdown.when_present.select /Student must be in a class standing of <class standing> or greater/
      elsif equals == "<"
        page.rule_dropdown.when_present.select /Student must be in a class standing of <class standing> or less/
      end
      add_class_standing( stand)
      page.preview_btn
    end
  end

  def create_admin_org_rule( group, node, org)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Permission of <administering org> required/
      add_org(org)
      page.preview_btn
    end
  end

  def create_min_credits_org_rule( group, node, org, credit)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must have successfully completed a minimum of <n> credits from courses in the <org>/
      page.integer_field.when_present.set credit
      add_org(org)
      page.preview_btn
    end
  end

  def create_min_total_credits_rule( group, node, credit)
    add_new_node( group, node)
    on ManageCORequisites do |page|
      page.rule_dropdown.when_present.select /Must have earned a minimum of <n> total credits/
      page.integer_field.when_present.set credit
      page.preview_btn
    end
  end

  def add_courses( course, set, range)
    on ManageCORequisites do |page|
      courses = create_array( course)
      if courses != "" && courses != nil
        page.multi_course_dropdown.when_present.select /Approved Courses/
        if courses.length > 1
          courses.each do |elem|
            advanced_search("courses code", elem)
            page.add_line_btn
            page.adding.wait_while_present
          end
        else
          advanced_search("courses code", course)
          page.add_line_btn
          page.adding.wait_while_present
        end
      end
      sets = create_array( set)
      if sets != "" && sets != nil
        page.multi_course_dropdown.when_present.select /Course Sets/
        if sets.length > 1
          sets.each do |elem|
            advanced_search("course set", elem)
            page.add_line_btn
            page.adding.wait_while_present
          end
        else
          advanced_search("course set", set)
          page.add_line_btn
          page.adding.wait_while_present
        end
      end
      #if range != "" && range != nil         ###FIX##################################
      #  page.multi_course_dropdown.when_present.select /Course Ranges/
      #  advanced_search("course range", range)
      #  page.add_line_btn
      #  page.adding.wait_while_present
      #end                              ######################################
    end
  end

  def add_program( program)
    on ManageCORequisites do |page|
      programs = create_array( program)
      if programs != "" && programs != nil
        page.program_dropdown.when_present.select /Approved Programs/
        programs.each do |elem|
          advanced_search("program code", elem)
          page.add_line_btn
          page.adding.wait_while_present
        end
      end
    end
  end

  def add_class_standing( standing)
    on ManageCORequisites do |page|
      advanced_search("class standing", standing)
      page.edit_loading.wait_while_present
    end
  end

  def add_org( org)
    on ManageCORequisites do |page|
      advanced_search("org", org)
      page.edit_loading.wait_while_present
    end
  end

  def choose_grade_type_grade( grade, type)
    types = { "Completed Notation"=>:completed, "Letter"=>:letter, "A-F with Plus/Minus"=>:letter_plus_minus,
              "Percentage"=>:percentage, "Pass/Fail"=>:pass_fail, "Pass/No Pass"=>:pass_nopass}
    on ManageCORequisites do |page|
      page.send(types[type])
      page.edit_loading.wait_while_present
      page.grade_dropdown.when_present.select grade
    end
  end

  def edit_existing_node(node, field, code)
    on ManageCORequisites do |page|
      page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).when_present.click
      page.edit_btn
      if field == "course"
        advanced_search("course code", code)
      elsif field == "courses"
        page.multi_course_dropdown.when_present.select /Approved Courses/
        advanced_search("courses code", code)
        page.add_line_btn
        page.adding.wait_while_present
      elsif field == "text"
        page.free_text_field.when_present.set code
      end
      page.preview_btn
    end
  end

  def add_new_node( group, node)
    on ManageCORequisites do |page|
      if node != "" && node != nil && page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).exists?
        page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).when_present.click
      end
      if group == "group"
        page.group_btn
      else
        page.add_btn
      end
    end
  end

  def create_array( string)
    if string != "" && string != nil
      strings = string.split(/,/)
    else
      strings = string
    end
    return strings
  end

  def switch_tabs
    on ManageCORequisites do |page|
      page.edit_loading.wait_while_present
      tab = page.tab_section.li(:class => /ui-state-active/).text
      if tab == "Edit Rule"
        page.logic_tab.when_present.click
      else
        page.object_tab.when_present.click
      end
    end
  end

  def convert_text( text, page)
    if page == "agenda" || page == "logic"
      if text =~ /^(.+)\s\((.+)\)$/
        converted = $1
        array = $2.split(/, /)
        array.each do |elem|
          converted += "," + elem
        end
      else
        converted = text
      end
    else
      converted = text
    end
    return converted
  end

  def test_text( section, text)
    string = ".*"
    if (section == "edit" && text =~ /^.+\(.+\)$/) || text !~ /,/
      string += Regexp.escape(text) + ".*"
    elsif text =~ /^.+\(.+\).+$/
      array = text.split(/,/)
      array.each do |elem|
        if elem =~ /\(/
          string += Regexp.escape(elem) + ","
        else
          string += Regexp.escape(elem) + ".*"
        end
      end
    else
      array = text.split(/,/)
      array.each do |elem|
        if section == "compare"
          string += Regexp.escape(elem) + "\n" + Regexp.escape(elem) + ".*"
        else
          string += Regexp.escape(elem) + ".*"
        end
      end
    end
    return Regexp.new(string, Regexp::MULTILINE)
  end

  def change_operator(level, operator)
    on ManageCORequisites do |page|
      page.loading.wait_while_present
      if level == "primary"
        page.edit_tree_section.select(:id => /u\d+_node_\d_parent_node_0_parent_root_control/).when_present.select operator
      elsif level == "secondary"
        page.edit_tree_section.select(:id => /u\d+_node_\d_parent_node_\d_parent_node_0_parent_root_control/).when_present.select operator
      elsif level == "tertiary"
        page.edit_tree_section.select(:id => /u\d+_node_\d_parent_node_\d_parent_node_\d_parent_node_0_parent_root_control/).when_present.select operator
      end
    end
  end

  def test_node_level( level, node)
    on ManageCORequisites do |page|
      page.loading.wait_while_present
      id = page.edit_tree_section.span(:text => /.*#{node}\..*/).id
      if level == "primary"
        test_primary = /u\d+_node_\d_parent_node_0_parent_root_span/
        if id !~ test_primary
          raise "\nError: ID did not match primary level\n" + test_primary.to_s
        end
      elsif level == "secondary"
        test_secondary = /u\d+_node_\d_parent_node_\d_parent_node_0_parent_root_span/
        if id !~ test_secondary
          raise "\nError: ID did not match secondary level\n" + test_secondary.to_s
        end
      elsif level == "tertiary"
        test_tertiary = /u\d+_node_\d_parent_node_\d_parent_node_\d_parent_node_0_parent_root_span/
        if id !~ test_tertiary
          raise "\nError: ID did not match tertiary level\n" + test_tertiary.to_s
        end
      end

    end
  end

  def move_around( node, direction)
    on ManageCORequisites do |page|
      if page.edit_tree_section.html =~ /li.+class.+ruleBlockSelected/
        selection = page.edit_tree_section.li(:class => /ruleBlockSelected/).text
        if selection !~ /.*#{Regexp.escape(node)}\..*/
          page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).when_present.click
        end
      else
        page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).when_present.click
      end
      if direction == "down"
        page.down_btn
      elsif direction == "up"
        page.up_btn
      elsif direction == "out"
        page.left_btn
      elsif direction == "in"
        page.right_btn
      elsif direction == "out in"
        page.left_btn
        page.right_btn
      elsif direction == "out up in"
        page.left_btn
        page.up_btn
        page.right_btn
      end
    end
  end

  def copy_cut_paste( node, node_after, action)
    on ManageCORequisites do |page|
      if node != "" && node != nil && page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).exists?
        page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).when_present.click
      end
      if action == "copy"
        page.copy_btn
      elsif action == "cut"
        page.cut_btn
      end
      if node_after != "" && node_after != nil && page.edit_tree_section.span(:text => /.*#{Regexp.escape(node_after)}\..*/).exists?
        page.edit_tree_section.span(:text => /.*#{Regexp.escape(node_after)}\..*/).when_present.click
      end
      page.paste_btn
    end
  end

  def copy_cut_paste_group( level, node, action)
    on ManageCORequisites do |page|
      if level == "primary"
        page.edit_tree_section.span(:id => /u\d+_node_\d+_parent_node_0_parent_root_span/).click
      elsif level == "secondary"
        elements = page.edit_tree_section.elements(:class => /.*compoundNode.*/)
        elements.each do |elem|
          if elem.id =~ /u\d+_(node_\d+_parent_node_\d+_parent_node_0_parent_root)/
            id = $1
            page.edit_tree_section.span(:id => /u\d+_#{id}_span/).click
            break
          end
        end
      elsif level == "tertiary"
        page.edit_tree_section.span(:id => /u\d+_node_\d+_parent_node_\d+_parent_node_\d+_parent_node_0_parent_root_span/).click
      end
      if action == "copy"
        page.copy_btn
      elsif action == "cut"
        page.cut_btn
      end
      if node != "" && node != nil && page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).exists?
        page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).when_present.click
      end
      page.paste_btn
    end
  end
end