Given /^It is "After" the first day of classes$/ do
  @term_for_test = "201301"
  @term = make AcademicTerm, :term_name=>"Spring 2013"
  @term.search
  on CalendarSearch do |page|
     page.edit @term.term_name
   end

  @keydate = make KeyDate
  @keydate.edit :key_date_type => "First Day of Classes", :start_date => "03/06/2013"

  #on AcademicTermPage do |page|
  #   page.term_make_official_button(0)
  #end

end

Given /^It is "Before" the first day of classes$/ do
  @term_for_test = "201512"
end