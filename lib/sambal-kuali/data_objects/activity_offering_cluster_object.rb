# stores test data for creating/editing and validating activity offering clusters and provides convenience methods for navigation and data entry
#
# ActivityOfferingCluster objects are always children of a CourseOffering
#
# ActivityOfferingCluster objects are parents of 0 to many RegistrationGroups objects
#
# class attributes are initialized with default data unless values are explicitly provided
#
# Typical usage: (with optional setting of explicit data value in [] )
#  @cluster = make ActivityOfferingCluster, [:is_constrained=>true,:private_name=>"test1_pri",:published_name=>"test1_pub"...]
#  @cluster.create
# OR alternatively 2 steps together as
#  @cluster = create ActivityOfferingCluster, [:is_constrained=>true,:private_name=>"test1_pri",:published_name=>"test1_pub"...]
# Note the use of the ruby options hash pattern re: setting attribute values
class ActivityOfferingCluster

  include Foundry
  include DataFactory
  include DateFactory
  include StringFactory
  include Workflows

  #generally set using options hash
  attr_accessor :private_name,
                :published_name,
                :is_valid,
                :expected_msg,
                :to_assign_ao_list,
                :assigned_ao_list,
                :ao_list

  alias_method :valid?, :is_valid

  # provides default data:
  #  defaults = {
  #    :private_name=>"#{random_alphanums(5).strip}_pri",
  #    :published_name=>"#{random_alphanums(5).strip}_pub",
  #    :is_valid=>true,
  #    :expected_msg=>"",
  #    :ao_list=>[]
  #  }
  # initialize is generally called using TestFactory Foundry .make or .create methods
  def initialize(browser, opts={})
    @browser = browser

    defaults = {
        :private_name=>"#{random_alphanums(5).strip}_pri",
        :published_name=>"#{random_alphanums(5).strip}_pub",
        :is_valid=>true,
        :expected_msg=>"",
        :ao_list =>[]
    }
    options = defaults.merge(opts)
    set_options(options)
  end

  # while on manage reg groups page, sets up activity offering cluster based on class attributes
  def create
      on ManageCourseOfferings do |page|
        page.add_cluster
        #page.format_aoc_select -- use default format
        page.private_name_add.set @private_name
        page.published_name_add.set @published_name
        page.complete_add_aoc
      end
  end

  def init_existing(cluster_div)
    on ManageCourseOfferings do |page|
      @private_name = page.cluster_div_private_name(cluster_div)
      @public_name = page.cluster_published_name(cluster_div)

      assigned_ao_list = page.get_cluster_div_assigned_ao_list(cluster_div)

      assigned_ao_list.each do |ao|

        ao_obj_temp = make ActivityOffering#, :code => ao, :activity_type => page.get_ao_type(temp_aoc.private_name, ao), :max_enrollment => page.get_max_enr(temp_aoc.private_name, ao)
        ao_obj_temp.init_existing(page.get_cluster_div_ao_row(cluster_div,ao))
        @ao_list.push(ao_obj_temp)
      end
    end
  end

  def add_activity_offering(ao_object)
    @ao_list << ao_object.create
  end

  # moves activity offering from cluster to target cluster
  #
  # @param ao_code [String] activity offering code
  # @param target cluster [ActivityOfferingCluster] target cluster object
  def move_ao_to_another_cluster(ao_code, target_cluster)
    on ManageCourseOfferings do |page|
      row = page.get_cluster_ao_row(@private_name,ao_code)
      row.cells[0].checkbox.set
      page.move_aos
      page.select_cluster.select(target_cluster.private_name)
      page.complete_move_ao
    end
    #TODO: update ao_list for each cluster
    #target_cluster.ao_list << ao_code
    #ao_list.delete(ao_code)
  end

  # removes activity offering from cluster (ao becomes unassigned)
  #
  # @param ao_code [String] activity offering code
  def remove_ao(ao_code)
    on ManageRegistrationGroups do |page|
      row = page.get_cluster_ao_row(@private_name,ao_code)
      row.link(text: "Remove").click
      page.loading.wait_while_present
      @assigned_ao_list.delete(ao_code)
    end
  end

# deletes the activity offering cluster
  def delete
    on ManageCourseOfferings do |page|
      page.remove_cluster(@private_name)
      page.confirm_delete_cluster
      #begin
      #  page.cluster_list_item_div(@private_name).wait_while_present(60)
      #rescue Watir::Exception::UnknownObjectException
        #ignore
      #end
    end
    @assigned_ao_list = []
  end

#initiates generates all reg groups operation
  def generate_all_reg_groups
    on ManageRegistrationGroups do |page|
      page.generate_all_reg_groups
    end
  end

  # renames cluster
  #
  # @param opts [Hash] key => value for attribute to be updated
  #
  # defaults = {
  #    :private_name=>"#{random_alphanums(5).strip}_pri",
  #    :published_name=>"#{random_alphanums(5).strip}_pub",
  #    :expect_success=>true
  #}
  def rename(opts={})

    defaults = {
        :private_name=>"#{random_alphanums(5).strip}_pri",
        :published_name=>"#{random_alphanums(5).strip}_pub",
        :expect_success=>true
    }
    options = defaults.merge(opts)

     on ManageCourseOfferings do |page|
       page.rename_cluster(@private_name)
       set_options(options) unless !options[:expect_success]
       page.rename_private_name.set @private_name
       page.rename_published_name.set @published_name
       page.rename_aoc_button
     end
  end

end
