class FinalExamMatrix

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :term_type

  WINTER_TERM_TYPE = "Winter Term"
  FALL_TERM_TYPE = "Fall Term"

  def initialize(browser,opts = {})
    @browser = browser

    defaults = {
      :term_type => "Fall Term",
      :rule_requirements => ""
    }

    options = defaults.merge(opts)
    set_options(options)
  end

  def edit
    manage
    on(FEMatrixView).edit @rule_requirements



    on(EditAcademicTerms).save :exp_success => options[:exp_success] #unless options.length >= 1 #don't save if only :exp_success element

    set_options(options)
  end

  def search
    go_to_manage_final_exam_matrix
  end

  def manage
    search
    on ManageFEMatrix do |page|
      page.select_term_type.select @term_type
      page.show
    end
  end
end
