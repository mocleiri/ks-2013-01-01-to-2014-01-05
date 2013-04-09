And /^I create a number of COs with an AO in each$/ do

  # BSCI181
  @bsci_co = create CourseOffering, :term => "201201", :course => "BSCI181", :delivery_format => "Lecture", :grade_format => "Lecture"
  @bsci_co.create_ao :ao_code => "A"
  puts @bsci_co.course + ' created'

  # CHEM181
  @chem_co = create CourseOffering, :term => "201201", :course => "CHEM181", :delivery_format => "Lecture", :grade_format => "Lecture"
  @chem_co.create_ao :ao_code => "A"
  puts @chem_co.course + ' created'

  # PHYS181
  @phys_co = create CourseOffering, :term => "201201", :course => "PHYS181", :delivery_format => "Lecture", :grade_format => "Lecture"
  @phys_co.create_ao :ao_code => "A"
  puts @phys_co.course + ' created'

end

When /^I indicate multiple activities for colocation, selecting to "(jointly share|separately manage)" enrollments$/ do |max_enrollment_flag|

### TESTING -- NEXT LINES ARE TEMPORARY -- DELETE IF FOUND (brandon.gresham)
#@bsci_co = make CourseOffering, :term => "201201", :course => "BSCI1817JCUL", :ao_list => ["A"], :delivery_format => "Lecture", :grade_format => "Lecture"
#@chem_co = make CourseOffering, :term => "201201", :course => "CHEM181ZN8DK", :ao_list => ["A"], :delivery_format => "Lecture", :grade_format => "Lecture"
#@phys_co = make CourseOffering, :term => "201201", :course => "PHYS181MQXUZ", :ao_list => ["A"], :delivery_format => "Lecture", :grade_format => "Lecture"


  @bsci_co.manage
  on ManageCourseOfferings do |page|
    page.edit( @bsci_co.ao_list[0] )
  end

  on ActivityOfferingMaintenance do |page|
    page.select_colocated_checkbox

    page.colocated_co_input_field.value = @chem_co.course
    page.colocated_ao_input_field.value = @chem_co.ao_list[0]
    page.click_colocated_add_button

    page.colocated_co_input_field.value = @phys_co.course
    page.colocated_ao_input_field.value = @phys_co.ao_list[0]
    page.click_colocated_add_button


    if(max_enrollment_flag == 'jointly share')
      page.select_separately_manage_enrollment_radio #toggling to this and back is required or an error generates on submit
      page.select_jointly_share_enrollment_radio
      page.colocated_shared_max_enrollment_input_field.value = '10'
    else # ie: 'separately manage'
      page.select_separately_manage_enrollment_radio
      page.colocated_shared_max_enrollment_table_first_ao_input.value = '10'
    end

    page.click_submit_button
  end

end

Then /^the AO indicates it is colocated$/ do

  @bsci_co.manage
  on ManageCourseOfferings do |page|
    $colocated_tooltip_text = page.target_row('A')[1].image.alt.upcase

    $chem_expected = @chem_co.course.upcase + ' ' + @chem_co.ao_list[0].upcase
    $phys_expected = @phys_co.course.upcase + ' ' + @phys_co.ao_list[0].upcase

    $colocated_tooltip_text.should include $chem_expected
    $colocated_tooltip_text.should include $phys_expected

  end

  puts 'done'
  sleep 10
end