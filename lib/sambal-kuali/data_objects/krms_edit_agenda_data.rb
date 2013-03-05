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
      return page.send(sect[section]).element(:tag_name => tag, :id => /.*node_#{node_i}.*/).option(selected: "selected").text
    end
  end

  def find_krms_element( section, tag, node)
    sect = {"edit_tree"=>:edit_tree_section,"preview_tree"=>:preview_tree_section}
    on EditAgenda do |page|
      if tag == "select"
        return page.send(sect[section]).element(:tag_name => tag, :id => /.*node_#{Regexp.escape(node)}.*/).id
      else
        elements = page.send(sect[section]).elements(:tag_name => tag, :id => /.*node_#{Regexp.escape(node)}.*/) #
        elements.each do |elem|
          type = elem.attribute_value "type"
          if tag == "input" && type == "text"
            return elem.id
          end
        end
      end
    end
  end
end