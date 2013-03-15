Given /^It is "After" the first day of classes$/ do
  @term = make AcademicTerm, :term_name=>"Winter 2016"
  @term.search
  on CalendarSearch do |page|
     page.edit @term.term_name
  end

  on AcademicTermPage do |page|
    if page.key_date_exist(0,0,0) and page.key_date_type(0,0,0) == "First Day of Classes"
      @keydate = make KeyDate
      @keydate.edit  :key_date_type => "First Day of Classes", :start_date => (Date.today - 1).strftime("%m/%d/%Y")
    else
      @keydate = make KeyDate, :key_date_type => "First Day of Classes", :start_date => (Date.today - 1).strftime("%m/%d/%Y"), :end_date=>(Date.today - 1).strftime("%m/%d/%Y")
      @keydategroup = make KeyDateGroup, :key_dates=>Array.new(1){@keydate}
      @keydategroup.create
    end
    end
end

Given /^It is "Before" the first day of classes$/ do
  @term = make AcademicTerm, :term_name=>"Winter 2016"
  @term.search
  on CalendarSearch do |page|
    page.edit @term.term_name
  end
  on AcademicTermPage do |page|
    if page.key_date_exist(0,0,0) and page.key_date_type(0,0,0) == "First Day of Classes"
      @keydate = make KeyDate
      @keydate.edit :key_date_type => "First Day of Classes", :start_date => (Date.today + 1).strftime("%m/%d/%Y")
    else
      @keydate = make KeyDate, :key_date_type => "First Day of Classes", :start_date => (Date.today + 1).strftime("%m/%d/%Y"), :end_date=>(Date.today + 1).strftime("%m/%d/%Y")
      @keydategroup = make KeyDateGroup, :key_dates=>Array.new(1){@keydate}
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
  step "I manage a course offering in my department"
  on ManageCourseOfferings do |page|
    page.edit("A")
  end
end