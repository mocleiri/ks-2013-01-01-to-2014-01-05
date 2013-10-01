class ActivityOfferingMaintenance < ActivityOfferingMaintenanceBase

  #expected_title /Kuali :: Edit Activity Offering/

  expected_element :mainpage_section

  element(:ao_header_text) { |b| b.frm.div(class: "uif-viewHeader-contentWrapper uif-sticky").h1.span.text }

  action(:prev_ao) { |b| b.frm.link(id: "edit_ao_prev").click; b.loading.wait_while_present }
  element(:prev_ao_text) { |b| b.frm.link(id: "edit_ao_prev").text }
  element(:select_ao_menu) { |b| b.frm.select(id: "edit_ao_select_control") }
  action(:next_ao) { |b| b.frm.link(id: "edit_ao_next").click; b.loading.wait_while_present }
  element(:next_ao_text) { |b| b.frm.link(id: "edit_ao_next").text }

  element(:sticky_footer) { |b| b.frm.div(class: "ks-uif-footer uif-stickyFooter uif-stickyButtonFooter") }
  element(:save_cancel_div) { |b| b.frm.div(id: "ActivityOfferingEdit_SubmitCancel") }
  element(:save_button) { |b| b.save_cancel_div.button(text: "Save Progress") }
  action(:save) { |b| sleep 2; b.loading.wait_while_present; sleep 2; b.save_button.click; b.loading.wait_while_present(120) }
  action(:send_to_scheduler_checkbox) { |b| b.frm.checkbox(id: "send_RDLs_to_scheduler_control") }
  value(:send_RDLs_to_scheduler_msg) { |b| b.label(id: "send_RDLs_to_scheduler_label").text }
  action(:send_to_scheduler) { |b| b.send_to_scheduler_checkbox.set }

  element(:submit_button) { |b| b.save_cancel_div.button(text: "Update") }
  action(:submit) { |b| sleep 2; b.loading.wait_while_present; sleep 2; b.submit_button.click; b.loading.wait_while_present(120) }
  action(:cancel) { |b| b.save_cancel_div.link(text: "Cancel").click; b.loading.wait_while_present }
  element(:sticky_footer_div) { |b| b.frm.div(class: "ks-uif-footer uif-stickyFooter uif-stickyButtonFooter", index: 1) }
  element(:send_revised_delivery_logistics_checkbox) { |b| b.sticky_footer_div.checkbox(name: "document.newMaintainableObject.dataObject.sendRDLsToSchedulerAfterMSE") }
  action(:send_revised_delivery_logistics) { |b| b.send_revised_delivery_logistics_checkbox.click }

  #unsaved changes dialog - appears when navigating between AOs
  element(:save_continue_alert_div) { |b| b.frm.div(id: "ActivityOfferingEdit-NavigationConfirmation") }
  element(:cancel_save_link) { |b| b.save_continue_alert_div.link(text: "Cancel") }
  action(:cancel_save) { |b| b.cancel_save_link.click }
  element(:save_and_continue_button) { |b| b.frm.button(id: "edit_ao_save_and_continue") }
  action(:save_and_continue) { |b| b.save_and_continue_button.click; b.loading.wait_while_present }
  element(:continue_without_saving_button) { |b| b.frm.button(id: "edit_ao_cancel") }
  action(:continue_without_saving) { |b| b.continue_without_saving_button.click; b.loading.wait_while_present }
  #end of dialog elements

  element(:activity_code) { |b| b.frm.text_field(name: "document.newMaintainableObject.dataObject.aoInfo.activityCode") }

  value(:subterm) { |b| b.frm.div(id: "subterm_name").span.text }
  element(:change_subterm_element) { |b| b.frm.link(id: "change_link") }
  element(:change_subterm_popup) { |b| b.frm.div(id: "KS-ActivityOfferingEdit-SubtermsPopupForm") }

  def change_subterm(subterm_type)
    change_subterm_element.click
    change_subterm_popup.select.select subterm_type
  end

  # Co-located
  element(:colocated_checkbox) { |b| b.frm.checkbox(id: "is_co_located_control") }
  action(:select_colocated_checkbox) { |b| b.colocated_checkbox.click() }
  element(:colocated_co_input_field) { |b| b.frm.text_field(id: "ActivityOfferingEdit-CoLocatedActivities-CoInputField_add_control") }
  element(:colocated_ao_input_field) { |b| b.frm.text_field(id: "ActivityOfferingEdit-CoLocatedActivities-AoInputField_add_control") }
  element(:colocated_add_button) { |b| b.frm.button(id: "ActivityOfferingEdit-CoLocatedActivities_add") }
  element(:add_colocate_ao_confirmation_dialog) { |b| b.div(id: "ActivityOfferingEdit-CoLocatedAddLineDialog") }
  action(:add_colocate_ao_confirmation_add) { |b| b.add_colocate_ao_confirmation_dialog.button(id: "edit_ao_add_colocate_line").click; b.loading.wait_while_present }

  action(:add_colocated) { |b| b.colocated_add_button.click(); b.adding.wait_while_present; b.colocated_co_input_field.wait_until_present; b.colocated_ao_input_field.wait_until_present; b.colocated_add_button.wait_until_present; }
  element(:jointly_share_enrollment_radio) { |b| b.radio(id: "share_seats_control_0") }
  action(:select_jointly_share_enrollment_radio) { |b| b.jointly_share_enrollment_radio.set }
  element(:separately_manage_enrollment_radio) { |b| b.radio(id: "share_seats_control_1") }
  action(:select_separately_manage_enrollment_radio) { |b| b.separately_manage_enrollment_radio.wait_until_present; b.separately_manage_enrollment_radio.set; b.colocated_shared_max_enrollment_table_first_ao_input.wait_until_present }
  element(:colocated_shared_max_enrollment_input_field) { |b| b.frm.text_field(id: "shared_max_enr_control") }
  element(:colocated_shared_max_enrollment_table) { |b| b.frm.div(id: "enr_shared_table").table() }
  element(:colocated_shared_max_enrollment_table_first_ao_input) { |b| b.colocated_shared_max_enrollment_table[1][1].text_field }

  element(:total_maximum_enrollment) { |b| b.frm.text_field(id: "maximumEnrollment_control") }

  element(:mainpage_section){|b| b.frm.div(id:"ActivityOffering-MaintenanceView")}

  element(:add_logistics_div) { |b| b.frm.div(id: "ActivityOffering-DeliveryLogistic-New") }
  element(:add_tba){ |b|b.add_logistics_div.div(data_label: "TBA").checkbox()}
  element(:add_days) { |b| b.add_logistics_div.div(data_label: "Days").text_field() }
  element(:add_start_time) { |b| b.add_logistics_div.div(data_label: "Start Time").text_field() }
  element(:add_start_time_ampm) { |b| b.add_logistics_div.select(name: "document.newMaintainableObject.dataObject.newScheduleRequest.startTimeAMPM") }
  element(:add_end_time) { |b| b.add_logistics_div.div(data_label: "End Time").text_field() }
  element(:add_end_time_ampm) { |b| b.add_logistics_div.select(name: "document.newMaintainableObject.dataObject.newScheduleRequest.endTimeAMPM") }
  element(:add_facility) { |b| b.add_logistics_div.div(data_label: "Facility").text_field() }
  action(:lookup_facility) { |b| b.add_logistics_div.div(data_label: "Facility").button().click; b.loading.wait_while_present }
  element(:add_room) { |b| b.add_logistics_div.div(data_label: "Room").text_field() }
  action(:lookup_room) { |b| b.add_logistics_div.div(data_label: "Room").button().click; b.loading.wait_while_present }

  action(:facility_features) { |b| b.frm.link(id: "ActivityOffering-DeliveryLogistic-New-Features-Section_toggle").click; b.loading.wait_while_present }
  element(:feature_list){ |b|b.frm.select(id: "featuresList_control")}

  element(:add_new_delivery_logistics_button) { |b| b.button(id: "add_rdl_button") }
  action(:add_new_delivery_logistics) { |b| b.add_new_delivery_logistics_button.click; b.adding.wait_while_present }

  element(:view_requested_delivery_logistics_link) { |b| b.frm.link(id: "ActivityOffering-DeliveryLogistic-Requested_toggle") }
  action(:view_requested_delivery_logistics) { |b| b.view_requested_delivery_logistics_link.click; b.loading.wait_while_present }

  element(:delete_requested_delivery_logistics_button) { |b| b.requested_logistics_table.button(text: "delete") } #TODO: identify button by row (days + start_time)
  action(:delete_requested_delivery_logistics) { |b| b.delete_requested_delivery_logistics_button.click; b.loading.wait_while_present }

  PERS_ACTION_COLUMN = 4

  element(:personnel_id) { |b| b.personnel_div.text_field(name: "document.newMaintainableObject.dataObject.instructors[0].offeringInstructorInfo.personId") }
  element(:personnel_name) { |b| b.personnel_div.text_field(name: "document.newMaintainableObject.dataObject.instructors[0].offeringInstructorInfo.personName") }
  element(:personnel_effort) { |b| b.personnel_div.text_field(name: "document.newMaintainableObject.dataObject.instructors[0].sEffort") }

  element(:add_person_id) { |b| b.personnel_table.rows[1].cells[ID_COLUMN].text_field() }

  action(:lookup_person) { |b| b.personnel_table.rows[1].cells[ID_COLUMN].button().click; b.loading.wait_while_present }
  element(:add_affiliation) { |b| b.personnel_table.rows[1].cells[AFFILIATION_COLUMN].select() }
  element(:add_inst_effort) { |b| b.personnel_table.rows[1].cells[INST_EFFORT_COLUMN].text_field() }
  action(:delete_personnel_element) { |b| b.personnel_table.rows[1].cells[PERS_ACTION_COLUMN].button() }
  action(:delete_personnel) { |b| b.delete_personnel_element.click; b.loading.wait_while_present }

  element(:add_personnel_element) { |b| b.frm.button(id: "ao-personnelgroup-addline") }
  action(:add_personnel) { |b| b.add_personnel_element.click; b.loading.wait_while_present }

  TBA = 0
  DAYS = 1
  START_TIME = 2
  END_TIME = 3
  FACILITY = 4
  ROOM = 5
  FEATURES = 6
  ACTIONS = 7

  def jump_to_ao(ao_name)
    select_ao_menu.select(ao_name)
  end

  def edit_rdl_row(row)
    row.cells[ACTIONS].link(text: "Edit").click
    loading.wait_while_present(120)
  end

  def delete_rdl_row(row)
    row.cells[ACTIONS].button(text: "Delete").click
  end

  def get_inst_effort(id)
    target_person_row(id).cells[INST_EFFORT_COLUMN].text_field.value
  end

  def get_affiliation(id)
    target_person_row(id).cells[AFFILIATION_COLUMN].select.selected_options[0].text
    #target_person_row(id).cells[AFFILIATION_COLUMN].text
  end

  def update_affiliation(id, affiliation)
    target_person_row(id).select affiliation
  end
  
  def update_inst_effort(id, effort)
    target_person_row(id).text_field.set effort
  end

  def delete_id(id)
    target_person_row(id).button.click
    loading.wait_while_present
  end


  SEATS_ACTION_COLUMN = 5

  #seat pool validation elements
  element(:seatpool_error_list) { |b| b.frm.ul(class: "uif-validationMessagesList") }
  element(:seatpool_info_list) { |b| b.frm.ul(class: "uif-validationMessagesList") }
  value(:seatpool_first_msg) { |b| b.seatpool_info_list.li.text }

  element(:add_pool_priority) { |b| b.seat_pools_table.rows[1].cells[PRIORITY_COLUMN].text_field() }
  element(:add_pool_seats) { |b| b.seat_pools_table.rows[1].cells[SEATS_COLUMN].text_field() }
  value(:add_pool_name)  { |b| b.seat_pools_table.rows[1].cells[POP_NAME_COLUMN].text_field().text }
  
  action(:lookup_population_name) { |index, b| b.seat_pools_table.rows[index].button(title: "Search Field").click; b.loading.wait_while_present }
  
  element(:add_pool_expiration_milestone) { |b| b.seat_pools_table.rows[1].cells[EXP_MILESTONE_COLUMN].select() }
  element(:add_pool_element) { |b| b.frm.button(id: "ao-seatpoolgroupZ_add")}
  action(:add_seat_pool) { |b| b.add_pool_element.click; b.loading.wait_while_present }

  element(:seat_pools_div) { |b| b.frm.div(id: "ao-seatpoolgroup") }
  element(:seat_pools_table) { |b| b.frm.table(id: "ao-seatpoolgroup-table") }

  def target_pool_row(pop_name)
    #seat_pools_table.row(text: /#{Regexp.escape(pop_name)}/)
   # i = 0
   # seat_pools_table.rows.each do |row|
   #   if i > 0
    seat_pools_table.rows[1..seat_pools_table.rows.count].each do |row|
        if (row.cells[POP_NAME_COLUMN].text_field.value =~ /#{pop_name}/)
          return row
        end
      end
      #i+=1
    #end
  end

  def add_pool_row_index
   add_seat_pool
   sp_index=1
   seat_pools_table.rows[1..seat_pools_table.rows.count].each do |row|
        if (row.cells[POP_NAME_COLUMN].text_field.value == "")
          return sp_index
        end
     sp_index+=1
   end
   return sp_index
  end

  def remove_seatpool(pop_name)
    target_pool_row(pop_name).button(text: "delete").click
    loading.wait_while_present
  end

  def remove_seatpool_by_index(sp_index)
    seat_pools_table.rows[sp_index].button(text: "delete").click
    loading.wait_while_present
  end

  def update_priority(pop_name, priority)
    target_pool_row(pop_name).cells[PRIORITY_COLUMN].text_field.set priority
    target_pool_row(pop_name).cells[PRIORITY_COLUMN].text_field.fire_event "onblur"
  end

  def update_priority_by_index(sp_index, priority)
    seat_pools_table.rows[sp_index].cells[PRIORITY_COLUMN].text_field.set priority
    seat_pools_table.rows[sp_index].cells[PRIORITY_COLUMN].text_field.fire_event "onblur"
  end

  def update_seats(pop_name, seats)
    target_pool_row(pop_name).cells[SEATS_COLUMN].text_field.set seats
    target_pool_row(pop_name).cells[SEATS_COLUMN].text_field.fire_event "onblur"
  end

  def update_seats_by_index(sp_index, seats)
    seat_pools_table.rows[sp_index].cells[SEATS_COLUMN].text_field.set seats
    seat_pools_table.rows[sp_index].cells[SEATS_COLUMN].text_field.fire_event "onblur"
  end


  def update_expiration_milestone(pop_name, milestone)
    target_pool_row(pop_name).cells[EXP_MILESTONE_COLUMN].select.select(milestone)
  end

  def update_expiration_milestone_by_index(sp_index, milestone)
    seat_pools_table.rows[sp_index].cells[EXP_MILESTONE_COLUMN].select.select(milestone)
  end

  def get_priority(pop_name)
    target_pool_row(pop_name).cells[PRIORITY_COLUMN].text_field.value #cell is hard-coded, getting this value was very problematic
  end

  def get_seats(pop_name)
    target_pool_row(pop_name).cells[SEATS_COLUMN].text_field.value #cell is hard-coded, getting this value was very problematic
  end

  def get_expiration_milestone(pop_name)
    target_pool_row(pop_name).cells[EXP_MILESTONE_COLUMN].select.selected_options[0].text #cell is hard-coded, getting this value was very problematic
  end

  element(:course_url) { |b| b.frm.text_field(name: "document.newMaintainableObject.dataObject.aoInfo.activityOfferingURL") }
  element(:requires_evaluation) { |b| b.frm.checkbox(name: "document.newMaintainableObject.dataObject.aoInfo.isEvaluated") }
  element(:honors_flag) { |b| b.frm.checkbox(name: "document.newMaintainableObject.dataObject.aoInfo.isHonorsOffering") }

  #validation error dialog
  element(:validation_error_dialog_div)  { |b| b.frm.div(class: "fancybox-wrap fancybox-desktop fancybox-type-html fancybox-opened") }
  value(:validation_error_dialog_text) { |b| b.validation_error_dialog_div.div(index: 2).text }
  action(:close_validation_error_dialog) { |b| b.validation_error_dialog_div.div(title: "Close").click}
  #validation error dialog

end