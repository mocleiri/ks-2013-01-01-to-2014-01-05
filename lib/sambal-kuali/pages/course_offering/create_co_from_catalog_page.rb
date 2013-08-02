class CreateCOFromCatalog < BasePage

  #expected_title /Kuali :: Create Course Offering/

  wrapper_elements
  frame_element
  validation_elements

  expected_element :suffix

  value(:target_term) { |b| b.frm.div(data_label: "Term").span.text }
  value(:course_code) { |b| b.frm.div(data_label: "Course Code").span.text }

  element(:suffix) { |b| b.frm.div(data_label: "Course Number Suffix").text_field() }

  element(:grading_reg_opts_div) { |b| b.frm.div(id: "KS-GradingAndRegOptions") }
  element(:grading_letter) { |b| b.grading_reg_opts_div.radio(text: "Letter") }
  element(:pass_fail_checkbox) { |b| b.grading_reg_opts_div.checkbox(name: "document.newMaintainableObject.dataObject.passFailStudentRegOpts") }
  element(:credit_type_fixed) { |b| b.div(id: "KS-CourseOfferingEdit-CreditType_OptionTypeSelector").radio(text: "Fixed") }
  element(:credit_type_fixed_select ) { |b| b.select(id: "KS-CourseOfferingEdit-CreditType_OptionTypeFixed_control") }

  element(:delivery_assessment_opt_div) { |b| b.frm.div(id: "KS-CourseOfferingEdit-DeliveryAndAssessment") }
  element(:final_exam_option_div) { |b| b.frm.div(id: "finalExamType") }
  action(:final_exam_option_standard) { |b| b.frm.radio(value: "STANDARD").set; b.loading.wait_while_present}
  action(:final_exam_option_alternate) { |b| b.frm.radio(value: "ALTERNATE").set; b.loading.wait_while_present }
  action(:final_exam_option_none) { |b| b.frm.radio(value: "NONE").set; b.loading.wait_while_present }

  #element(:cross_listed_co_check_boxes) { |b| b.frm.dvi(id:"KS-CoListed-Checkbox-Group")}
  element(:cross_listed_co_check_box) { |b| b.checkbox(id: "KS-COEditListed-Checkbox-Group_control_0") }

  element(:joint_defined_courses_table) { |b| b.div(id: "KS-Catalog-JointCourse-Section").table() }
  element(:create_new_joint_defined_course_first_row) { |b| b.joint_defined_courses_table.rows[1].cells[3].link}
  action(:create_new_joint_defined_course_row_1) { |b| b.joint_defined_courses_table.rows[1].cells[3].link.click }
  action(:create_new_joint_defined_course_row_2) { |b| b.joint_defined_courses_table.rows[2].cells[3].link.click }
  element(:joint_defined_course_row_1) { |b| b.joint_defined_courses_table.rows[1].text }
  element(:joint_defined_course_row_2) { |b| b.joint_defined_courses_table.rows[2].text }

  element(:sticky_footer_div) { |b| b.frm.div(id: "u48") } #static id required
  #element(:sticky_footer_div) { |b| b.frm.div(class: "ks-uif-footer uif-stickyFooter uif-stickyButtonFooter") }
  action(:create_offering) { |b| b.frm.button(id: "ks-uif-primaryActionButton").click; b.loading.wait_while_present }
  action(:cancel) { |b| b.sticky_footer_div.link(text: "Cancel").click; b.loading.wait_while_present }

  #element(:delivery_format_add_element) {|b| b.frm.delivery_formats_table.rows[1].cells[ACTIONS_COLUMN].button(text: "add")  }
  #action(:delivery_format_add) {|b| b.delivery_format_add_element.click; b.loading.wait_while_present   }

  element(:delivery_formats_table) { |b| b.frm.div(id: "KS-CourseOffering-FormatOfferingSubSection").table() }
  FORMAT_COLUMN = 0
  GRADE_ROSTER_LEVEL_COLUMN = 1
  FINAL_EXAM_COLUMN = 2
  ACTIONS_COLUMN = 5

  element(:format_select) {|b| b.delivery_formats_table.rows[1].cells[FORMAT_COLUMN].select }
  element(:grade_roster_level_select) {|b| b.delivery_formats_table.rows[1].cells[GRADE_ROSTER_LEVEL_COLUMN].select }
  element(:final_exam_driver_select)  {|b| b.delivery_formats_table.rows[1].cells[FINAL_EXAM_COLUMN].select }
  #action(:add_format_btn) { |b| b.frm.button(text: "Add").click; b.loading.wait_while_present }
  action(:delete_format_btn) {|b| b.frm.button(id: "KS-CourseOffering-FormatOfferingSubSection_del_line0") }

  def add_random_delivery_format
    begin
      selected_options = {:del_format => select_random_option(format_select), :grade_format => select_random_option(grade_roster_level_select), :final_exam_driver => select_random_option(final_exam_driver_select)}
    rescue
      selected_options = {:del_format => select_random_option(format_select), :grade_format => select_random_option(grade_roster_level_select)}
    end

    #add_format_btn
    return selected_options
  end

  def select_grade_roster_level(format)
    delivery_format_row(format).cells[GRADE_ROSTER_LEVEL_COLUMN].select().select(format)
  end

  def select_final_exam_driver(format)
    delivery_format_row(format).cells[FINAL_EXAM_COLUMN].select().select(format)
  end

  def delivery_format_row(format)
    delivery_formats_table.row(text: /#{Regexp.escape(format)}/)
  end

  def select_random_option(select_element)
    options = select_element.options.map{|option| option.text}
    options.delete_if{|a| a.index("Select") != nil or  a == "" }
    sel_opt = rand(options.length)
    if options != []
      select_element.select(options[sel_opt])
      loading.wait_while_present
      return options[sel_opt]
    else
      return nil
    end
  end

end