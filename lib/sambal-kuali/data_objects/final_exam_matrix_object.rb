class FinalExamMatrix

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :term_type

  def initialize(browser,opts = {})
    @browser = browser

    defaults = {
      :term_type => "Fall Term",
      :exam_type => "Standard",
      :rule_requirements => "TH at 06:00 AM"
    }

    options = defaults.merge(opts)
    set_options(options)
  end

  def edit opts = {}
    defaults = {
        :exam_type => @exam_type,
        :rule_requirements => @rule_requirements,
        :add_statement => false,
        :edit_statement => false,
        :rule => "If Course meets on <timeslot>",
        :days => "MWF",
        :start_time => "05:00",
        :end_time => "06:00",
        :time_ampm => "pm",
        :free_text => "Free Form Text",
        :defer_save => false
    }
    options = defaults.merge(opts)

    manage
    on(FEMatrixView).edit options[:rule_requirements], options[:exam_type]

    if options[:add_statement] == true
      on FEMatrixEdit do |page|
        page.add_statement
        page.loading.wait_while_present
        page.rule_dropdown.select options[:rule]

        if options[:rule] =~ /Course meets/
          sleep 10
          page.rule_days.set options[:days]
          page.rule_starttime.set options[:start_time]
          page.rule_starttime_ampm.select options[:time_ampm]
          page.rule_endtime.set options[:end_time]
          page.rule_endtime_ampm.select options[:time_ampm]
        else
          page.rule_freeformtext.set options[:free_text]
        end

        page.preview_change
        page.loading.wait_while_present
      end
    end

    if options[:edit_statement] == true
      on FEMatrixEdit do |page|
        select_statement options[:rule_requirements]
        page.edit
        page.loading.wait_while_present
        page.rule_dropdown.select options[:rule]

        if options[:rule] =~ /Course meets/
          page.rule_days.set options[:days]
          page.rule_starttime.set options[:start_time]
          page.rule_starttime_ampm.select options[:time_ampm]
          page.rule_endtime.set options[:end_time]
          page.rule_endtime_ampm.select options[:time_ampm]
        else
          page.rule_freeformtext.set options[:free_text]
        end

        page.preview_change
        page.loading.wait_while_present
      end
    end

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

  def select_statement( rule_requirements)
    on FEMatrixEdit do |page|
      parent = page.rule_tree_section.a( text: /[A-Z]+\.\s+#{rule_requirements}/).parent
      if parent.class !~ /ruleBlockSelected/
        page.rule_tree_section.a( text: /[A-Z]+\.\s+#{rule_requirements}/).click
      end
    end
  end
end
