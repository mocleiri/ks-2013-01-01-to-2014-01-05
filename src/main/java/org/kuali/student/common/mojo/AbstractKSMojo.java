/**
 * 
 */
package org.kuali.student.common.mojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.project.MavenProject;
import org.kuali.student.contract.model.ServiceContractModel;
import org.kuali.student.contract.model.impl.ServiceContractModelCache;
import org.kuali.student.contract.model.impl.ServiceContractModelQDoxLoader;
import org.kuali.student.contract.model.validation.ServiceContractModelValidator;

/**
 * 
 * The basic Kuali Student Mojo that defines things like the source lookup path.
 * 
 * @author ocleirig
 * 
 */
public abstract class AbstractKSMojo extends AbstractMojo {

	/**
	 * @parameter
	 **/
	private List<String> sourceDirs;

	public AbstractKSMojo() {
		super();
	}

	public List<String> getSourceDirs() {
		return sourceDirs;
	}

	public void setSourceDirs(List<String> sourceDirs) {
		this.sourceDirs = sourceDirs;
	}

	protected final ServiceContractModel getModel() {

		Set<String> modelSourceDirectories = new LinkedHashSet<String>();

		MavenProject project = (MavenProject) getPluginContext().get("project");
		/*
		 * Default to the source directory that the plugin is run from.
		 */

		if (sourceDirs == null) {
			modelSourceDirectories.add(project.getBuild().getSourceDirectory());
		} else {
				modelSourceDirectories.addAll(sourceDirs);
		}
		if (modelSourceDirectories.size() == 0)
			throw new RuntimeException("No Source Directories are defined");

		ServiceContractModel instance = new ServiceContractModelQDoxLoader(
				new ArrayList<String>(modelSourceDirectories));
		return new ServiceContractModelCache(instance);
	}

	protected final boolean validate(ServiceContractModel model) {
		Collection<String> errors = new ServiceContractModelValidator(model)
				.validate();
		if (errors.size() > 0) {

			StringBuilder buf = new StringBuilder();
			buf.append(errors.size()).append(
					" errors found while validating the data.");
			int cnt = 0;
			for (String msg : errors) {
				cnt++;
				buf.append("\n");
				buf.append("*error*").append(cnt).append(":").append(msg);
			}

			buf.append(errors.size()).append(
					" errors found while validating the data.");
			return false;
		}
		return true;
	}

}
