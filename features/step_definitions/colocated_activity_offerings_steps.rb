And /^I create a number of jointly offered COs with an AO in each$/ do

  # BSCI181
  @bsci_co = create CourseOffering, :term => Rollover::OPEN_SOC_TERM, :course => "BSCI181", :delivery_format => "Lecture", :grade_format => "Lecture"
  puts 'sleeping to allow document-creation to finish so we dont run into a locked-record issue (dont laugh, its happening at time of writing)...'
  sleep 5
  @bsci_co.manage
  on ManageCourseOfferings do |page|
    page.add_activity
    format = page.format.options[1].text
    page.add_ao format, 1
    puts page.codes_list
    @bsci_co.ao_list = page.codes_list
  end
  puts @bsci_co.course + ' created'

  # CHEM181
  @chem_co = create CourseOffering, :term => Rollover::OPEN_SOC_TERM, :course => "CHEM181", :delivery_format => "Lecture", :grade_format => "Lecture"
  puts 'sleeping to allow document-creation to finish so we dont run into a locked-record issue (dont laugh, its happening at time of writing)...'
  sleep 5
  @chem_co.manage
  on ManageCourseOfferings do |page|
    page.add_activity
    format = page.format.options[1].text
    page.add_ao format, 1
    puts page.codes_list
    @chem_co.ao_list = page.codes_list
  end
  puts @chem_co.course + ' created'

  # PHYS181
  @phys_co = create CourseOffering, :term => Rollover::OPEN_SOC_TERM, :course => "PHYS181", :delivery_format => "Lecture", :grade_format => "Lecture"
  puts 'sleeping to allow document-creation to finish so we dont run into a locked-record issue (dont laugh, its happening at time of writing)...'
  sleep 5
  @phys_co.manage
  on ManageCourseOfferings do |page|
    page.add_activity
    format = page.format.options[1].text
    page.add_ao format, 1
    puts page.codes_list
    @phys_co.ao_list = page.codes_list
  end
  puts @phys_co.course + ' created'

end