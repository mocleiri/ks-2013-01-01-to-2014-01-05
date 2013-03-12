Given /^It is "After" the first day of classes$/ do
  @term = make AcademicTerm, :term_name=>"Winter 2016"
  @term.search
  on CalendarSearch do |page|
     page.edit @term.term_name
   end

  @keydate = make KeyDate, :key_date_type => "First Day of Classes", :start_date => (Date.today - 1).strftime("%m/%d/%Y"), :end_date=>(Date.today - 1).strftime("%m/%d/%Y")

  @keydategroup = make KeyDateGroup, :key_dates=>Array.new(1){@keydate}
  @keydategroup.create
end

Given /^It is "Before" the first day of classes$/ do
  @term = make AcademicTerm, :term_name=>"Winter 2016"
  @term.search
  on CalendarSearch do |page|
    page.edit @term.term_name
  end

  @keydate = make KeyDate
  @keydate.edit :key_date_type => "First Day of Classes", :start_date => (Date.today + 1).strftime("%m/%d/%Y")
end