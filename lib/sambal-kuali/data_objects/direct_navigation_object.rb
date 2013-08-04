# Stores constants for direct navigation URL's
# class attributes are initialized with the constants to act as a repository for direct links
# Current Usage: Navigation to pages that cannot be navigated to by hyperlink for Authorization Tests
class DirectNavigation
  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :edit_course_offering,
                :edit_activity_offering,
                :manage_course_offering,
                :create_course_offering,
                :course_offering_results,
                :single_course_results,
                :manage_registration_group

  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :edit_course_offering=> "#{$test_site}/kr-krad/courseOffering?editCrossListedCoAlias=false&showHome=false&courseOfferingInfo.id=8ff7a167-9a14-450b-9901-dbc3a72d0133&methodToCall=maintenanceEdit&dataObjectClassName=org.kuali.student.enrollment.class2.courseoffering.dto.CourseOfferingEditWrapper&formKey=317e1602-3132-4506-8fba-05694804d8cb&cacheKey=s4j8mcnbqzgkc516z8r5",
        :edit_activity_offering=>"#{$test_site}/kr-krad/activityOffering?showHome=false&courseOfferingId=b8bfd4cd-a804-41d0-8659-f4a1a3771e92&methodToCall=maintenanceEdit&history=null%255E%2524%255Enull%255E%2524%255EHome%255E%2524%255Ehttp%253A%252F%252Fenv2.ks.kuali.org%252Fportal.do%255E%2524%255Enull%2524%255E%2524courseOfferingManagementView%255E%2524%255EsearchInputPage%255E%2524%255EManage%2BCourse%2BOfferings%255E%2524%255Ehttp%253A%252F%252Fenv2.ks.kuali.org%252Fkr-krad%252FcourseOfferingManagement%253FpageId%253DsearchInputPage%2526methodToCall%253Dstart%2526withinPortal%253Dfalse%2526viewId%253DcourseOfferingManagementView%2526formKey%253Dbb17bf70-210e-4cfd-be30-940cc828b5af%2526showHome%253Dfalse%255E%2524%255Ebb17bf70-210e-4cfd-be30-940cc828b5af&aoInfo.id=ff255717-2a11-4a97-ac8a-cf4a38433f79&dataObjectClassName=org.kuali.student.enrollment.class2.courseoffering.dto.ActivityOfferingWrapper",
        :manage_course_offering=>"#{$test_site}/kr-krad/courseOfferingManagement?viewId=courseOfferingManagementView&methodToCall=start&withinPortal=false&formKey=544fc9d2-4b1d-4c4a-a28c-e5de1a34b7eb&cacheKey=arxeqbry3vrovky0197s4&pageId=searchInputPage",
        :course_offering_results=>"#{$test_site}/kr-krad/courseOfferingManagement?viewId=courseOfferingManagementView&methodToCall=start&withinPortal=false&formKey=544fc9d2-4b1d-4c4a-a28c-e5de1a34b7eb&cacheKey=qx892pmpk1px877losv&pageId=manageCourseOfferingsPage",
        :single_course_results=>"#{$test_site}/kr-krad/courseOfferingManagement?formKey=544fc9d2-4b1d-4c4a-a28c-e5de1a34b7eb&cacheKey=55fld3imscj26ddjren271&pageId=manageTheCourseOfferingPage",
        :create_course_offering=>"#{$test_site}/kr-krad/courseOfferingCreate?methodToCall=start&dataObjectClassName=org.kuali.student.enrollment.class2.courseoffering.dto.CourseOfferingCreateWrapper&hideReturnLink=true&formKey=1eea52b4-f0ac-420b-8b54-a0855babe289&cacheKey=c0gozz2z65sc39pgx2ey7&pageId=courseOfferingCreatePage"
    }
    options = defaults.merge(opts)
    set_options(options)
  end

  def setup_navigation
    @course_offering = make CourseOffering, :term=>Rollover::MAIN_TEST_TERM_SOURCE, :course=>"CHEM132"
    @course_offering.manage
    on ManageCourseOfferings do |page|
      page.edit('A')
    end
    @edit_activity_offering = @browser.url
    on ActivityOfferingMaintenance do |page|
      page.cancel
    end
  end
end