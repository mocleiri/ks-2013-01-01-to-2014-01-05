When /^I create a Course Offering with selected lecture Formats$/ do
  @course_offering = create CourseOffering, :term=> Rollover::OPEN_SOC_TERM, :course => "ENGL222", :grade_format => "Quiz", :delivery_format => "Lecture/Quiz"
  @course_offering = create CourseOffering, :term=> Rollover::OPEN_SOC_TERM, :course => "ENGL222", :grade_format => "Quiz", :delivery_format => "Lecture/Quiz"
end

And /^I create a Course Offering with selected Delivery Formats$/ do
  @course_offering = create CourseOffering, :term=> Rollover::OPEN_SOC_TERM, :course => "CHEM132", :grade_format => "Lab", :delivery_format => "Lab"
  @course_offering = create CourseOffering, :term=> Rollover::OPEN_SOC_TERM, :course => "CHEM132", :grade_format => "Lab", :delivery_format => "Lab"
end

Then /^the new Course Offering should contain only the selected delivery formats$/ do
  @course_offering.search_by_subjectcode
  @course_offering.view_course_details
  on ManageCourseDetails do  |page|
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

Then /^the new Course Offering should be displayed in the list of available offerings\.$/ do
  @course_offering.search_by_subjectcode
  @course_offering.view_course_details
end

And /^I create a Course Offering from catalog with Activity Offerings assigned to subterms$/ do
  @course_offering = create CourseOffering, :term=> @term.term_code,
                            :course => "CHEM132",
                            :grade_format => "Lab",
                            :delivery_format => "Lab" ,
                            :suffix => ""

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

And /^I create a Course Offering from catalog with Activity Offerings assigned to subterms in my admin org$/ do
  @course_offering = create CourseOffering, :term=> @term.term_code,
                            :course => "ENGL211",
                            :grade_format => "Lecture",
                            :delivery_format => "Lecture" ,
                            :suffix => ""
  #@course_offering = make CourseOffering, :course => "ENGL211MECJ6", :term => "208508"
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
  @course_offering = create CourseOffering, :term=> @term.term_code,
                            :course => "CHEM132",
                            :grade_format => "Lab",
                            :delivery_format => "Lab" ,
                            :suffix => ""
  #@course_offering = make CourseOffering, :term=>@term.term_code, :course => "CHEM132"

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
