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
      :exam_type => "Standard",
      :rule_requirements => "TH at 11:00 AM - 12:15 PM."
    }

    options = defaults.merge(opts)
    set_options(options)
  end

  def edit opts = {}
    defaults = {
        :exam_type => @exam_type,
        :rule_requirements => @rule_requirements,
        :defer_save => false
    }
    options = defaults.merge(opts)

    manage
    on(FEMatrixView).edit options[:rule_requirements], options[:exam_type]

    on(FEMatrixEdit).update_rule unless options[:defer_save] == true

    set_options(options)
  end

  def search
    go_to_manage_final_exam_matrix
  end

  def manage
    search
    on ManageFEMatrix do |page|
      page.term_type_select.select @term_type
      page.show
    end
  end
end
