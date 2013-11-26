When /^two users are concurrently editing the same course offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"CHEM132")
  orig_co_code = @course_offering.course

  @course_offering.manage
  @course_offering.edit_offering :suffix => random_alphanums(2).upcase

  @browser1 = @browser
  @browser2 = Watir::Browser.new :firefox

  @browser = @browser2
  log_in "admin", "admin"

  @course_offering_concurrent = make CourseOffering, :course=>orig_co_code, :term=>@course_offering.term
  @course_offering_concurrent.manage
  @course_offering_concurrent.edit_offering :suffix => random_alphanums(2).upcase

  @browser = @browser1
end

When /^the first user updates the suffix and saves the course offering$/ do
  @browser = @browser1

  @course_offering.save
end

When /^the second user updates the suffix and saves the course offering$/ do
  @browser = @browser2

  @course_offering_concurrent.save
end

When /^the update for the first user is successful$/ do
  @browser = @browser1

  @course_offering.manage
end

When /^the second user gets a VersionMismatchError$/ do
  @browser = @browser2

  on CourseOfferingEdit do |page|
    #add verify error message
    true.should == false
  end
  @browser = @browser1
end
