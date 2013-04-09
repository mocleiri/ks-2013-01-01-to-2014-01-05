class ManageCourseOfferings < BasePage

  #expected_title /Kuali :: Manage Course Offering/

  wrapper_elements
  frame_element
  validation_elements

  expected_element :term

  element(:error_message_course_not_found) { |b| b.frm.li(class: "uif-errorMessageItem") }

  element(:previous_course_link){ |b| b.frm.link(id: "u229") } # Persistent ID needed!
  element(:list_all_course_link){ |b| b.frm.link(id: "u232") } # Persistent ID needed!
  element(:next_course_link){ |b| b.frm.link(id: "u235") }     # Persistent ID needed!

  element(:term) { |b| b.frm.text_field(name: "termCode") }
  element(:input_code) { |b| b.frm.text_field(name: "inputCode") }
  action(:show) { |b| b.frm.button(text: "Show").click; sleep 2; b.loading.wait_while_present(600) }

  value(:course_title) { |b| b.ao_results_div.h3.text }

  element(:delete_cluster_div) { |b| b.frm.div(id: "ClusterDeleteConfirmationPage") }
  action(:confirm_delete_cluster) {|b| b.delete_cluster_div.button(text: "Delete Cluster").click; b.loading.wait_while_present }

  element(:manage_offering_links_div) { |b| b.frm.div(id: "KS-CourseOfferingManagement-TheCourseOfferingLinks")}
  element(:view_co_details_link) { |b| b.manage_offering_links_div.link(text: "View") }
  element(:edit_course_offering_link) { |b| b.frm.link(id: "edit_co")}
  action(:edit_course_offering) { |b| b.edit_course_offering_link.click; b.loading.wait_while_present(200) }
  action(:delete_course_offering_link) { |b| b.manage_offering_links_div.link(id: "delete_co") }
  action(:delete_course_offering) { |b| b.delete_course_offering_link.click; b.loading.wait_while_present }

  #value(:cross_listed_as) { |b| b.frm.span(id: "u362_span").text }
  value(:cross_listed_as_text) { |b| b.frm.span(text: /Crosslisted as/).text }

  element(:cross_listed_message_div) { |b| b.frm.div(id: "KS-CourseOfferingManagement-AliasMessageSection") }
  value(:cross_listed_message) { |b| b.cross_listed_message_div.span.text }

  action(:select_all) { |b| b.frm.link(id: "KS-CourseOfferingManagement-SelectAll").click; b.loading.wait_while_present }

  #NB - CO Toolbar is not on this page - this one element is listed here to allow nagivation to single CO when a CO List is
  # not expected (ie search for ENGL206, returns ENGL206 and ENG206A)
  action(:create_co_button){ |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Add-CO")}

  element(:add_activity_button){ |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Add-AO-ClusterTab") }
  action(:add_activity){ |b| b.add_activity_button.click; b.loading.wait_while_present}

  element(:add_activity_popup_div){ |b| b.frm.div(id: "KS-CourseOfferingManagement-AddActivityOfferingPopupForm") }
  element(:format) { |b| b.add_activity_popup_div.select(name: "formatOfferingIdForNewAO") }
  element(:activity_type) { |b| b.add_activity_popup_div.select(name: "activityIdForNewAO") }
  element(:cluster) { |b| b.add_activity_popup_div.select(name: "clusterIdForNewAO") }
  element(:quantity) { |b| b.add_activity_popup_div.text_field(name: "noOfActivityOfferings") }
  element(:add_button) { |b| b.add_activity_popup_div.button }
  action(:complete_add_activity) { |b| b.add_button.click; b.loading.wait_while_present }

  action(:draft_activity_button){ |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Draft-AO-ClusterTab") }
  action(:draft_activity){ |b| b.draft_activity_button.click; b.loading.wait_while_present}

  element(:approve_activity_button){ |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Approve-AO-ClusterTab")}
  action(:approve_activity){ |b| b.approve_activity_button.click; b.loading.wait_while_present}

  element(:delete_aos_button) { |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-Delete-AO-ClusterTab") }
  action(:delete_aos) { |b| b.delete_aos_button.click}

  element(:add_cluster_button) { |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-AddCluster-AO-ClusterTab") }
  action(:add_cluster) { |b| b.add_cluster_button.click; b.loading.wait_while_present }


  element(:rename_cluster_popup_div){ |b| b.frm.div(id: "KS-CourseOfferingManagement-RenameAOCPopupForm") }
  element(:rename_private_name) { |b| b.rename_cluster_popup_div.text_field(id: "privateClusterNameForRename_control") }
  element(:rename_published_name) { |b| b.rename_cluster_popup_div.text_field(id: "publishedClusterNameForRename_control") }
  action(:rename_aoc_button) { |b| b.rename_cluster_popup_div.button(text: "Rename").click; b.loading.wait_while_present }

  element(:add_cluster_popup_div){ |b| b.frm.div(id: "KS-CourseOfferingManagement-AddAOCPopupForm") }
  element(:format_aoc_select) { |b| b.add_cluster_popup_div.select(name: "formatOfferingIdForViewRG") }
  element(:private_name_add) { |b| b.add_cluster_popup_div.text_field(name: "privateClusterNamePopover") }
  element(:published_name_add) { |b| b.add_cluster_popup_div.text_field(name: "publishedClusterNamePopover") }
  element(:add_button_aoc) { |b| b.add_cluster_popup_div.button(text: "Add") }
  action(:complete_add_aoc) { |b| b.add_button_aoc.click; b.loading.wait_while_present }

  element(:move_aos_button) { |b| b.frm.button(id: "KS-CourseOfferingManagement-ToolBar-MoveTo-AO-ClusterTab") }
  action(:move_aos) { |b| b.move_aos_button.click; b.loading.wait_while_present }

  element(:move_ao_cluster_popup_div){ |b| b.frm.div(id: "KS-CourseOfferingManagement-MoveAOCPopupForm") }
  element(:select_cluster) { |b| b.move_ao_cluster_popup_div.select(name: "clusterIdForAOMove") }
  element(:move_ao_button) { |b| b.move_ao_cluster_popup_div.button(text: "Move") }
  action(:complete_move_ao) { |b| b.move_ao_button.click; b.loading.wait_while_present }

  def approve_co_confirm
    puts "exists? #{approve_co_popup_div.checkbox(index: 0).exists?}"
    approve_co_popup_div.checkbox(index: 0).click
    loading.wait_while_present(180)
  end

  def approve_co_cancel
    puts "exists? #{approve_co_popup_div.checkbox(index: 1).exists?}"
    approve_co_popup_div.checkbox(index: 1).click
    loading.wait_while_present(180)
  end


  #element(:activity_offering_results_div) { |b| b.frm.div(id: "KS-ARGCourseOfferingManagement-ActivityOfferingListSection") }
  element(:activity_offering_results_div) { |b| b.frm.div(id: "KS-CourseOfferingManagement-AOClustersCollection") }
  element(:activity_offering_results_table) { |b| b.activity_offering_results_div.table }

  AO_SELECT = 0
  AO_CODE = 1
  AO_STATUS = 2
  AO_TYPE = 3
  AO_MAX_ENR = 4
  AO_DAYS = 5
  AO_ST_TIME = 6
  AO_END_TIME = 7
  AO_BLDG = 8
  AO_ROOM = 9
  AO_INSTRUCTOR = 10
  AO_ACTIONS = 11

  action(:go) { |b| b.frm.button(text: "Go").click; b.loading.wait_while_present }

  def view_activity_offering(code)
    view_activity_offering_link(code).click
    loading.wait_while_present
  end

  def view_activity_offering_link(code)
    activity_offering_results_table.link(text: code)
  end

  def target_row(code)
#    activity_offering_results_table.row(text: /\b#{Regexp.escape(code)}\b/).wait_until_present(60)
    activity_offering_results_table.row(text: /\b#{Regexp.escape(code)}\b/)
  end

  def course_list_returned?(subject_code)
    activity_offering_results_table.row(text: /#{subject_code}/).exists?
  end

  def ao_db_id(code)
    target_row(code).cells[AO_CODE].link.attribute_value("href").scan(/aoInfo.id=(.*)&dataObjectClassName/)[0][0]
  end

  def ao_status(code)
    target_row(code).cells[AO_STATUS].text
  end

  def row_by_status(aostatus)
    activity_offering_results_table.row(text: /\b#{Regexp.escape(aostatus)}\b/)
  end


  def select_ao_by_status(aostatus)
    if row_by_status(aostatus).exists? then
      row_by_status(aostatus).checkbox.set
      return row_by_status(aostatus).cells[AO_CODE].text
    end
  end

  def copy_link(code)
    target_row(code).link(text: /\b#{Regexp.escape("Copy")}\b/)
  end

  def copy(code)
    copy_link(code).click
    loading.wait_while_present
  end

  def edit_link(code)
    target_row(code).link(text: /\b#{Regexp.escape("Edit")}\b/)
  end

  def edit(code)
    begin
      edit_link(code).click

      if browser.alert.exists?
        browser.alert.ok
      end

    rescue Timeout::Error => e
      puts "rescued target_row edit"
    end
    loading.wait_while_present(120)
  end

  def select_aos(code_list)
    for code in code_list
      if !target_row(code).nil?
        target_row(code).checkbox.set
      end
    end
  end

  def deselect_aos(code_list)
    for code in code_list
      if !target_row(code).nil?
        target_row(code).checkbox.clear
      end
    end
  end

  def select_ao(code)
    if !target_row(code).nil?
      target_row(code).checkbox.set
    end
  end

  def deselect_ao(code)
    if !target_row(code).nil?
      target_row(code).checkbox.clear
    end
  end

  def ao_status(code, status)
    retVal = false
    row_text = target_row(code).text

    if row_text.include? status
      retVal = true
    end
    retVal
  end

  def ao_schedule_data(aoCode)
    retVal = nil
    retVal = target_row(aoCode).text
  end

  def codes_list
    codes = []
    activity_offering_results_table.rows.each { |row| codes << row[AO_CODE].text }
    codes.delete_if { |code| code == "CODE" }
    codes.delete_if { |code| code.strip == "" }
    codes
  end

  def add_ao input_format, input_quantity
    format.select(input_format)
    loading.wait_while_present(120)
    activity_type.select(activity_type.options[0].text)
    loading.wait_while_present(120)
    cluster.select(cluster.options[0].text)
    loading.wait_while_present(120)
    quantity.set(input_quantity)
    complete_add_activity
  end

  #def cross_listed_as(crossListedCoCode)
  #
  #  course_title
  #end

  def check_all_ao_status(aoStatus)
    retVal = true
    activity_offering_results_table.rows.each {|row|
      if !(row[AO_STATUS].text.eql? aoStatus)
        retVal = false
        break
      end
    }
    retVal
  end

  def check_aos_status(aoStatus, aos)
    retVal = true
    aos.each { |code|
      if(!ao_status(code, aoStatus))
        retVal = false
        break
      end
    }
    retVal
  end

  def has_cross_listed_message(co_code)
    retVal = nil
    cross_listed_message_div.present?.should == true
    retVal = cross_listed_message.include? co_code

    retVal
  end

  ########################## cluster tab

  element(:cluster_list_div)  { |b| b.frm.div(id: "KS-CourseOfferingManagement-AOClustersCollection").div(class: "uif-stackedCollectionLayout") }

  def cluster_div_list
    div_list = []
    if cluster_list_div.exists?
      div_list = cluster_list_div.divs(class: "uif-group uif-boxGroup uif-horizontalBoxGroup uif-collectionItem uif-boxCollectionItem")
    end
    puts "div list #{div_list.length}"
    div_list
  end

  def cluster_div_private_name(cluster_div_element)
    #cluster_div_element.fieldset.label.text[/(?<=Cluster: )\S+/]
    tmp_text = cluster_div_element.fieldset.label.text
    end_of_private_name = -1
    end_of_private_name = tmp_text.index('(')-2 unless tmp_text.index('(') == nil
    tmp_text[9..end_of_private_name]
  end

  def cluster_list_item_div(private_name)
    cluster_div_list.each do |div_element|
      if cluster_div_private_name(div_element) == private_name then
        return div_element
      end
    end
    #img_id = cluster_list_div.span(text: /#{Regexp.escape("#{private_name}")}/).image().id
    #div_id = img_id[0..-5]    #eg changes  u532_line0_exp to u532_line0
    #cluster_list_div.div(id: "#{div_id}")
  end

  def cluster_name_text(private_name)
    cluster_list_item_div(private_name).span().text()
  end

  def cluster_published_name(private_name)
    cluster_list_item_div(private_name).span().text[/(?<=\()\S+(?=\))/] #get the text between parenthesis
                                                                        #full_name = cluster_list_item_div(private_name).span().text()
                                                                        #full_name.slice(full_name.index('(')+1..-2)
  end

  def remove_cluster(private_name)
    cluster_list_item_div(private_name).link(text: "Delete").click
    loading.wait_while_present
  end

  def rename_cluster(private_name)
    cluster_list_item_div(private_name).link(text: "Rename").click
    loading.wait_while_present
  end

  def get_cluster_status_msg(private_name)
    cluster_list_item_div(private_name).div(id: /KS-ManageRegistrationGroups-StateAndActionLinks_line/).span.text()
  end

  def get_cluster_first_error_msg(private_name)
    cluster_list_item_div(private_name).li(class: "uif-errorMessageItem").text()
  end

  def get_cluster_error_msgs(private_name)
    msg_list = []
    cluster_list_item_div(private_name).ul(class: "uif-validationMessagesList").lis(class:  "uif-errorMessageItem").each do |li|
      msg_list <<  li.text()
    end
    msg_list.to_s
  end

  def get_cluster_first_warning_msg(private_name)
    cluster_list_item_div(private_name).li(class: "uif-warningMessageItem").text()
  end

  def get_cluster_warning_msgs(private_name)
    msg_list = []
    cluster_list_item_div(private_name).uls(class: "uif-validationMessagesList").each do |ul|
      ul.lis(class:  "uif-warningMessageItem").each do |li|
        msg_list <<  li.text()
      end
    end
    msg_list.to_s
  end

  def get_cluster_ao_row(private_name, ao_code)
    cluster_list_item_div(private_name).table.row(text: /\b#{Regexp.escape(ao_code)}\b/)
  end

  def get_cluster_assigned_ao_list(private_name)
    assigned_ao_list = []

    cluster_ao_table = cluster_list_item_div(private_name).table
    if cluster_ao_table.exists? then
      cluster_ao_table.rows[1..-1].each do |row|
        assigned_ao_list << row.cells[AO_CODE].text
      end
      assigned_ao_list.delete_if{|ao| ao == "" }
    else
      assigned_ao_list = []
    end
    assigned_ao_list
  end

  def select_cluster_for_ao_move(source_private_name,target_private_name)
    cluster_list_item_div(source_private_name).select().select(target_private_name)
  end

  def get_ao_type(private_name, ao_code)
    cluster_list_item_div(private_name).table.row(text: /\b#{Regexp.escape(ao_code)}\b/).cells[AO_TYPE].text
  end

  def get_max_enr(private_name, ao_code)
    cluster_list_item_div(private_name).table.row(text: /\b#{Regexp.escape(ao_code)}\b/).cells[AO_MAX_ENR].text
  end

  def move_ao_from_cluster_submit(private_name)
    cluster_list_item_div(private_name).button(id: /move_ao_button_line/).click
    loading.wait_while_present
  end

  def view_cluster_reg_groups(private_name)
    cluster_list_item_div(private_name).link(text: /View Registration Groups/).click
  end

  def get_cluster_reg_groups_list(private_name)
    assigned_ao_list = []

    cluster_ao_table = cluster_list_item_div(private_name).table
    if cluster_ao_table.exists? then
      cluster_ao_table.rows[1..-1].each do |row|
        assigned_ao_list << row.cells[1].text
      end
      assigned_ao_list.delete_if{|ao| ao == "" }
    else
      assigned_ao_list = []
    end
    assigned_ao_list
  end

end