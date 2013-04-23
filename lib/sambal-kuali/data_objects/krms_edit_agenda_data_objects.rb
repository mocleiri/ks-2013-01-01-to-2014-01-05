class EditAgendaData
  include Foundry
  include DataFactory

  attr_accessor :select_rule

  def initialize(browser, opts={})
    @browser = browser

    defaults = {
    }

    options = defaults.merge(opts)

    set_options(options)
  end

  def find_krms_before_element( section, tag, node)
    sect = {"edit_tree"=>:edit_tree_section,"preview_tree"=>:preview_tree_section}
    on EditAgenda do |page|
      node_i = node.to_i
      node_i -= 1
      return page.send(sect[section]).element(:tag_name => tag, :id => /.*node_#{node_i}.*/).id
    end
  end

  def advanced_search(field, code)
    fields = {"course code"=>:lookup_course_code, "course title"=>:lookup_course_title}
    on EditAgenda do |page|
      page.search_link
      sleep 2
      page.send(fields[field]).set code
      sleep 2
      page.lookup_search_button
      sleep 2
      if field == "course code"
        page.lookup_results.a(:href => /#{Regexp.escape(code)}/).click
      else
        #TODO - find a way to return course code randomly when searching for title or description
      end
    end
  end
end