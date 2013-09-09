class DisplayScheduleOfClasses < BasePage

  # contrary to standard convention, we provide a direct URL to this view in order to supply an optional parameter
  # to force the display of the "Activity Offering Display"-selector widget
  page_url "#{$test_site}/kr-krad/scheduleOfClassesSearch?viewId=scheduleOfClassesSearchView&pageId=scheduleOfClassesSearchInputPage&methodToCall=start&showAoDisplayWidget=true"

  expected_element :term

  wrapper_elements
  frame_element

  element(:term) { |b| b.frm.div(data_label: "Term").select() }
  element(:course_search_parm) { |b| b.frm.text_field(id: "course_search_text_control") }
  element(:course_search_lookup) { |b| b.frm.link(id: "lookup_searchCourseCode") }

  element(:instructor_search_parm) { |b| b.frm.text_field(id: "instructor_search_text_control") }
  action(:instructor_search_lookup) { |b| b.frm.link(id: "KS-Personnel-LookupView").click; b.loading.wait_while_present }

  element(:department_search_parm) { |b| b.frm.text_field(id: "department_search_text_control") }
  action(:department_search_lookup) { |b| b.frm.link(id: "lookup_searchDepartment").click; b.loading.wait_while_present }

  element(:title_description_search_parm) { |b| b.frm.text_field(id: "title_description_search_text_control") }
  #element(:title_description_search_lookup) { |b| b.frm.link(id: "lookup_searchTitleDesc") }

  element(:type_of_search_element) { |b| b.frm.div(data_label: "Type of Search").select() }

  def select_type_of_search(type_of_search)
    type_of_search_element.select type_of_search
    loading.wait_while_present
  end

  element(:rendering_selection) { |b| b.frm.select(id: "KS-ScheduleOfClasses-AoDisplaySelector_control") }

  def select_rendering(rendering)
    rendering_selection.select_value rendering
    loading.wait_while_present
  end

  FLAT_RENDERING = "FLAT"
  AO_CLUSTER_RENDERING = "CLUSTER"
  REG_GROUP_RENDERING = "REG_GROUP"

  element(:course_not_found_info_message_div) { |b| b.frm.div(id: "u96") }

  action(:show) { |b| b.frm.button(id: "show_button").click; b.loading.wait_while_present}

  element(:course_search_text_info_message) { |b| b.frm.span(id: "course_search_text_info_message") }

  element(:results_table) { |b| b.frm.div(id: "KS-ScheduleOfClasses-CourseOfferingListSection").table() }
  element(:details_row) { |b| b.frm.tr(class: "detailsRow") }
  element(:details_table) { |b| b.frm.tr(class: "detailsRow").table() }

  element(:cluster_header_1) { |b| b.details_row.span(class: "uif-headerText-span", index:1) }
  element(:cluster_header_2) { |b| b.details_row.span(class: "uif-headerText-span", index:2) }

  element(:results_activities_table) { |b| b.frm.div(id: /findThisId_.*/).table() }

  # Course table
  EXPAND_ACTION_COLUMN = 0
  COURSE_CODE_COLUMN = 1
  TITLE_COLUMN = 2
  CREDITS_COLUMN = 3

  # Activities table
  CODE_COL = 0
  ICON_COL = 9

  def target_course_row(course_code)
    results_table.wait_until_present
    results_table.row(text: /\b#{course_code}\b/)
  end

  def get_results_course_list()
    course_list = []
    results_table.wait_until_present
    results_table.rows[1..-1].each do |row|
      course_list << row[COURSE_CODE_COLUMN].text
    end
    course_list.delete_if { |course| course == "" }
    course_list
  end

  def get_course_code(row)
     row.cells[COURSE_CODE_COLUMN].text
  end

  def get_cluster_headers
    header_list = []
    header_list << cluster_header_1.text
    header_list << cluster_header_2.text
  end

  def course_expand(course_code)
    target_course_row(course_code).cells[EXPAND_ACTION_COLUMN].image().click
    loading.wait_while_present
    details_table.wait_until_present
  end

  def course_title(course_code)
    target_course_row(course_code).cells[TITLE_COLUMN].text()
  end

  def credits(course_code)
    target_course_row(course_code).cells[CREDITS_COLUMN].text()
  end

  def course_ao_information_table(course_code) #must call 'course_expand' first
    target_course_row(course_code).table
  end

  def course_description(course_code) #must call 'course_expand' first
    target_course_row(course_code).div(id: /findThisId/).p.text
  end

  REG_GROUP_COLUMN = 0
  AO_CODE_COLUMN = 0
  TYPE_COLUMN = 1
  DAYS_COLUMN = 2
  ST_TIME_COLUMN = 3
  END_TIME_COLUMN = 4
  BUILDING_COLUMN = 5
  ROOM_COLUMN = 6
  INSTRUCTOR_COLUMN = 7
  MAX_ENR_COLUMN = 8

  def get_ao_list(course_code) #course details must be expanded
    ao_list = []
    course_ao_information_table(course_code).rows[1..-1].each do |row|
      ao_list << row[AO_CODE_COLUMN].text
    end
    ao_list
  end

  def get_instructor_list #course details must be expanded
    instructor_list = []
    details_table.rows[1..-1].each do |row|
      instructor_list << row[INSTRUCTOR_COLUMN].text
    end
    instructor_list
  end

  def get_reg_group_list #course details must be expanded
    reg_group_list = []
    details_table.rows[1..-1].each do |row|
      reg_group_list << row[REG_GROUP_COLUMN].text
    end
    reg_group_list.pop  #remove last element, as it will be an empty string
    reg_group_list
  end

  def ao_information_target_row(course_code,activity_offering_code)
    course_ao_information_table(course_code).rows.each do |row|
      if row.cells[AO_CODE_COLUMN].text ==  activity_offering_code
        return row
      end
    end
    raise "row not found in course information table - course code: #{course_code}, ao_code: #{activity_offering_code}"
  end

  def self.ao_details_table_accessor_maker(method_name, column)
    define_method method_name.to_s do |course_code, activity_offering_code|
      ao_info(course_code, activity_offering_code,column)
    end
  end

  ao_details_table_accessor_maker :get_ao_type, TYPE_COLUMN
  ao_details_table_accessor_maker :get_ao_days, DAYS_COLUMN
  ao_details_table_accessor_maker :get_ao_start_time, ST_TIME_COLUMN
  ao_details_table_accessor_maker :get_ao_end_time, END_TIME_COLUMN
  ao_details_table_accessor_maker :get_ao_building, BUILDING_COLUMN
  ao_details_table_accessor_maker :get_ao_room, ROOM_COLUMN
  ao_details_table_accessor_maker :get_ao_instructor, INSTRUCTOR_COLUMN
  ao_details_table_accessor_maker :get_ao_max_enr, MAX_ENR_COLUMN

  private
  def ao_info(course_code, activity_offering_code,column)
    ao_information_target_row(course_code,activity_offering_code).cells[column].text
  end
end