When /^I create a Course Offering with "([^"]*)" delivery Formats$/ do |format_type|
  delivery_format_list = []
  if format_type == "selected lecture"
    delivery_format_list << (make DeliveryFormat, :format => "Lecture", :grade_format => "Course Offering", :final_exam_activity => "Lecture")
  else
    delivery_format_list << (make DeliveryFormat, :format => "Lecture", :grade_format => "Course Offering", :final_exam_activity => "Lecture")
    delivery_format_list << (make DeliveryFormat, :format => "Discussion/Lecture", :grade_format => "Course Offering", :final_exam_activity => "Lecture")
  end
  @course_offering = create CourseOffering, :term=> Rollover::OPEN_SOC_TERM, :course => "ENGL222", :delivery_format_list => delivery_format_list
end

And /^I create a Course Offering with random Delivery Formats$/ do
  @course_offering = create CourseOffering, :term=> Rollover::OPEN_SOC_TERM
end

Then /^the new Course Offering should contain only the selected delivery formats$/ do
  @course_offering.search_by_subjectcode
  @course_offering.view_course_details
  on CourseOfferingInquiry do  |page|
    @course_offering.delivery_format_list.each do |del_option|
      page.get_delivery_format(del_option.format).should == del_option.format
      page.get_grade_roster_level(del_option.format).should == del_option.grade_format
    end
    page.close
  end

end

And /^I copy a course offering from an existing offering$/ do
  @course_offering = create CourseOffering, :term=> Rollover::FINAL_EDITS_SOC_TERM, :course => "CHEM132", :create_from_existing=>(make CourseOffering, :term=> "201201", :course => "CHEM132")
end

And /^I copy a course offering from an existing offering and choose to exclude instructor information$/ do
  @course_offering = create CourseOffering, :term=> Rollover::FINAL_EDITS_SOC_TERM, :course => "CHEM132", :exclude_instructor => true, :create_from_existing=>(make CourseOffering, :term=> "201201", :course => "CHEM132")
end

Then /^the new Course Offering should be displayed in the list of available offerings\.$/ do
  @course_offering.search_by_subjectcode
  @course_offering.view_course_details
end

Then /^the new Course Offering should not contain any instructor information in its activity offerings$/ do
  @course_offering.manage
  @course_offering.get_instructor_list.should == ""
end

And /^I create a Course Offering from catalog with Activity Offerings assigned to subterms$/ do
  delivery_format_list = []
  delivery_format_list << (make DeliveryFormat, :format => "Lab", :grade_format => "Lab", :final_exam_activity => "Lab")

  @course_offering = create CourseOffering, :term=> @term.term_code,
                            :course => "CHEM132",
                            :delivery_format_list => delivery_format_list

  @rdl_list = {}
  @rdl_list["MT"] = make DeliveryLogistics, :days => "MT", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => "PHYS", :room => "4102"

  @activity_offering = create ActivityOffering, :parent_course_offering => @course_offering,  :subterm => @subterm_list[0].subterm_type,
                              :format => "Lab Only", :activity_type => "Lab" , :requested_delivery_logistics_list => @rdl_list
  @activity_offering.save

  @rdl_list2 = {}
  @rdl_list2["WF"] = make DeliveryLogistics, :days => "WF", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => "PHYS", :room => "4102"
  @activity_offering2 = create ActivityOffering,  :parent_course_offering => @course_offering, :subterm => @subterm_list[1].subterm_type,
                               :format => "Lab Only", :activity_type => "Lab" , :requested_delivery_logistics_list => @rdl_list2

  @activity_offering2.save
end

And /^I create a Course Offering with an Activity Offerings assigned to subterms$/ do
  step 'I create a Course Offering from catalog with Activity Offerings assigned to subterms in my admin org'
end

And /^I create a Course Offering from catalog with Activity Offerings assigned to subterms in my admin org$/ do
  delivery_format_list = []
  delivery_format_list << (make DeliveryFormat, :format => "Lecture", :grade_format => "Lecture", :final_exam_activity => "Lecture")

  @course_offering = create CourseOffering, :term=> @term.term_code,
                            :course => "ENGL211",
                            :delivery_format_list => delivery_format_list

  @rdl_list = {}
  @rdl_list["MT"] = make DeliveryLogistics, :days => "MT", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => "PHYS", :room => "4102"

  @activity_offering = create ActivityOffering, :parent_course_offering => @course_offering,  :subterm => @subterm_list[0].subterm_type,
                              :format => "Lecture Only", :activity_type => "Lecture" , :requested_delivery_logistics_list => @rdl_list
  @activity_offering.save

  @rdl_list2 = {}
  @rdl_list2["WF"] = make DeliveryLogistics, :days => "WF", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => "PHYS", :room => "4102"
  @activity_offering2 = create ActivityOffering,  :parent_course_offering => @course_offering, :subterm => @subterm_list[1].subterm_type,
                               :format => "Lecture Only", :activity_type => "Lecture" , :requested_delivery_logistics_list => @rdl_list2

  @activity_offering2.save
end

And /^I create a Course Offering from catalog with Activity Offerings$/ do
  delivery_format_list = []
  delivery_format_list << (make DeliveryFormat, :format => "Lab", :grade_format => "Lab", :final_exam_activity => "Lab")

  @course_offering = create CourseOffering, :term=> @term.term_code,
                            :course => "CHEM132",
                            :delivery_format_list => delivery_format_list

  @rdl_list = {}
  @rdl_list["MT"] = make DeliveryLogistics, :days => "MT", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => "PHYS", :room => "4102"

  @activity_offering = create ActivityOffering, :parent_course_offering => @course_offering, # :subterm => @subterm_list[0].subterm_type,
                              :format => "Lab Only", :activity_type => "Lab" , :requested_delivery_logistics_list => @rdl_list
  @activity_offering.save

  @rdl_list2 = {}
  @rdl_list2["WF"] = make DeliveryLogistics, :days => "WF", :start_time => "10:00", :start_time_ampm => "am", :end_time => "10:50", :end_time_ampm => "am", :facility => "PHYS", :room => "4102"
  @activity_offering2 = create ActivityOffering,  :parent_course_offering => @course_offering, #:subterm => @subterm_list[1].subterm_type,
                               :format => "Lab Only", :activity_type => "Lab" , :requested_delivery_logistics_list => @rdl_list2
  @activity_offering2.save
end
