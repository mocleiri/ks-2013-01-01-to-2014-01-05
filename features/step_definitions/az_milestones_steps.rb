Given /^It is "After" the first day of classes$/ do
  @term = make AcademicTerm, :term_name=>Rollover::PUBLISHED_MILESTONES_SOC_TERM_NAME
  @term.search
  on CalendarSearch do |page|
    page.edit @term.term_name
  end

  on EditAcademicTerms do |page|
    @tindex = page.get_term_index(@term.term_name)

    if page.key_date_exist(@tindex,0,0) and page.key_date_type(@tindex,0,0) == "First Day of Classes"
      @keydate = make KeyDate
      @keydate.edit  :key_date_type => "First Day of Classes", :start_date => (Date.today - 1).strftime("%m/%d/%Y"),  :term_index=> @tindex
    else
      @keydate = make KeyDate, :key_date_type => "First Day of Classes", :start_date => (Date.today - 1).strftime("%m/%d/%Y"), :end_date=>(Date.today - 1).strftime("%m/%d/%Y"), :term_index=> @tindex
      @keydategroup = make KeyDateGroup, :key_dates=>Array.new(1){@keydate}, :term_index=> @tindex
      @keydategroup.create
    end
  end
end

Given /^It is "Before" the first day of classes and "Before" the first day to add classes/ do
  step "I am logged in as a Schedule Coordinator"
  @term = make AcademicTerm, :term_name=> Rollover::PUBLISHED_MILESTONES_SOC_TERM_NAME, :term_type=>AcademicTerm::WINTER_TERM_TYPE
  @term.edit

  @keydategroup = make KeyDateGroup, :key_date_group_type=> "Instructional", :term_index=> @tindex, :term_type=> @term.term_type
  @keydate = make KeyDate, :parent_key_date_group => @keydategroup, :key_date_type => "First Day of Classes", :start_date => (Date.today + 5).strftime("%m/%d/%Y"), :end_date=>(Date.today + 5).strftime("%m/%d/%Y"), :term_index=> @tindex
  @keydategroup.key_dates = Array.new(1){@keydate}
  @keydategroup.create

  @keydategroup = make KeyDateGroup,:key_date_group_type=> "Registration", :term_index=> @tindex, :term_type=> @term.term_type
  @keydate2 = make KeyDate, :parent_key_date_group => @keydategroup, :key_date_type => "Registration Period 1", :start_date => (Date.today + 1).strftime("%m/%d/%Y"), :end_date=>(Date.today + 4).strftime("%m/%d/%Y"), :term_index=> @tindex, :date_range => true
  @keydategroup.key_dates = Array.new(1){@keydate2}
  @keydategroup.create
    #end
  #end
  step "I am logged in as a Department Schedule Coordinator"
end

Given /^It is "Before" the first day of classes and "After" the first day to add classes/ do
  @term = make AcademicTerm, :term_name=>Rollover::PUBLISHED_MILESTONES_SOC_TERM_NAME
  @term.search
  on CalendarSearch do |page|
    page.edit @term.term_name
  end
  on EditAcademicTerms do |page|

    @tindex = page.get_term_index(@term.term_name)

    if page.key_date_exist(@tindex,0,0) and page.key_date_type(@tindex,0,0) == "First Day of Classes"
      @keydate = make KeyDate
      @keydate.edit :key_date_type => "First Day of Classes", :start_date => (Date.today + 1).strftime("%m/%d/%Y"), :term_index=> @tindex
    else
      @keydate = make KeyDate, :key_date_type => "First Day of Classes", :start_date => (Date.today + 5).strftime("%m/%d/%Y"), :end_date=>(Date.today + 5).strftime("%m/%d/%Y"), :term_index=> @tindex
      @keydategroup = make KeyDateGroup, :key_dates=> Array.new(1){@keydate}, :term_index=> @tindex
      @keydategroup.create
    end

    if page.key_date_exist(@tindex,1,0) and page.key_date_type(@tindex,1,0) == "Registration Period 1"
      @keydate2 = make KeyDate
      @keydate2.edit :key_date_type => "Registration Period 1", :start_date => (Date.today - 4).strftime("%m/%d/%Y"), :end_date=>(Date.today +1).strftime("%m/%d/%Y"), :term_index=> @tindex, :key_date_group=> 1
    else
      @keydate2 = make KeyDate, :key_date_type => "Registration Period 1", :start_date => (Date.today - 4).strftime("%m/%d/%Y"), :end_date=>(Date.today +1).strftime("%m/%d/%Y"), :term_index=> @tindex
      @keydategroup = make KeyDateGroup,:key_date_group_type=> "Registration", :key_dates=>Array.new(1){@keydate2}, :term_index=> @tindex
      @keydategroup.create
    end
  end
end

When /^I do not have access to copy an activity offering$/ do
  on ManageCourseOfferings do |page|
    page.copy_link("A").present?.should == false
  end
end
Then /^I edit an activity offering in my department$/ do
  step "I manage a course offering in my admin org"
  on ManageCourseOfferings do |page|
    page.edit("A")
  end
end

Given /^It is "After" the first day to add classes$/ do
  @term = make AcademicTerm, :term_name=>Rollover::PUBLISHED_MILESTONES_SOC_TERM_NAME
  @term.search
  on CalendarSearch do |page|
    page.edit @term.term_name
  end

  on EditAcademicTerms do |page|

    @tindex = page.get_term_index(@term.term_name)

    if page.key_date_exist(@tindex,0,0) and page.key_date_type(@tindex,0,0) == "First Day of Classes"
      @keydate = make KeyDate
      @keydate.edit  :key_date_type => "First Day of Classes", :start_date => (Date.today - 1).strftime("%m/%d/%Y")
    else
      @keydate = make KeyDate, :key_date_type => "First Day of Classes", :start_date => (Date.today - 1).strftime("%m/%d/%Y"), :end_date=>(Date.today - 1).strftime("%m/%d/%Y")
      @keydategroup = make KeyDateGroup, :key_dates=>Array.new(1){@keydate}
      @keydategroup.create
    end
  end
end

When /^I do not have access to edit maximum enrollment$/ do
  on ActivityOfferingMaintenance do |page|
    page.total_maximum_enrollment.present?.should == false
  end
end