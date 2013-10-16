class FinalExamMatrix

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  attr_accessor :term_type, :courses

  def initialize(browser,opts = {})
    @browser = browser

    defaults = {
      :term_type => "Fall Term",
      :exam_type => "Standard",
      :rule_requirements => "TH at 06:00 AM",
      :rule => "If Course meets on <timeslot>",
      :days => "MWF",
      :start_time => "05:00",
      :end_time => "06:00",
      :time_ampm => "pm",
      :free_text => "Free Form Text",
      :courses => "ENGL101",
      :facility => "MTH",
      :room => "0304",
      :rdl_days => "Day 1",
      :courses_type => "Approved Courses",
      :defer_save => false
    }

    options = defaults.merge(opts)
    set_options(options)
  end

  def create
    manage

    if @exam_type == "Standard"
      on(FEMatrixView).add_standard_fe_rule
    else
      on(FEMatrixView).add_common_fe_rule
    end

    on FEMatrixEdit do |page|
      page.add_statement
      sleep 10
      page.rule_dropdown.select @rule

      if @exam_type == "Standard"
        set_standard_rule @rule
      else
        set_common_rule @rule
      end

      page.rdl_days.select @rdl_days
      page.rdl_starttime.set @start_time
      page.rdl_starttime_ampm.select @time_ampm
      page.rdl_endtime.set @end_time
      page.rdl_endtime_ampm.select @time_ampm
      if @exam_type == "Common"
        page.rdl_facility.set @facility
        page.rdl_room.set @room
      end

      page.preview_change
      page.loading.wait_while_present

      page.update_rule unless @defer_save == true
      page.loading.wait_while_present
    end
  end

  def edit opts = {}
    defaults = {
        :exam_type => @exam_type,
        :rule_requirements => @rule_requirements,
        :add_statement => false,
        :edit_statement => false,
        :rule => @rule,
        :standard_days => @standard_days,
        :start_time => @start_time,
        :end_time => @end_time,
        :time_ampm => @time_ampm,
        :free_text => @free_text,
        :defer_save => @defer_save
    }
    options = defaults.merge(opts)

    manage
    on(FEMatrixView).edit options[:rule_requirements], options[:exam_type]

    if options[:add_statement] == true
      on FEMatrixEdit do |page|
        page.add_statement
        page.loading.wait_while_present
        page.rule_dropdown.select options[:rule]

        if options[:exam_type] == "Standard"
          set_standard_rule options[:rule]
        else
          set_common_rule options[:rule]
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

        if options[:exam_type] == "Standard"
          set_standard_rule options[:rule]
        else
          set_common_rule options[:rule]
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

  def set_standard_rule rule
    on FEMatrixEdit do |page|
      if rule =~ /<timeslot>/
        page.rule_days.set @days
        page.rule_starttime.set @start_time
        page.rule_starttime_ampm.select @time_ampm
        page.rule_endtime.set @end_time
        page.rule_endtime_ampm.select @time_ampm
      else
        page.rule_freeformtext.set @free_text
      end
    end
  end

  def set_common_rule rule
    on FEMatrixEdit do |page|
      if rule =~ /<Course>/
        page.proposition_section.a( text: /Advanced Search/).click
        page.lookup_course_code.when_present.set @courses
        page.lookup_search
        page.return_course_code(@courses).a( text: /Select/).click
      elsif rule =~ /<Courses>/
        page.courses_type_dropdown @courses_type
        courses_array = @courses.split(/,/)
        courses_array.each do |course|
          page.proposition_section.a( text: /Advanced Search/).click
          page.lookup_course_code.when_present.set course
          page.lookup_search
          page.return_course_code(course).a( text: /Select/).click
          page.add_line
        end
      else
        page.rule_freeformtext.set @free_text
      end
    end
  end
end
