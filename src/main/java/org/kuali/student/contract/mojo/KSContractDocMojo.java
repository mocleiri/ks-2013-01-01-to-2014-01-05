package org.kuali.student.contract.mojo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.List;

import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.joda.time.DateTime;
import org.kuali.student.common.mojo.AbstractKSMojo;
import org.kuali.student.contract.model.ServiceContractModel;
import org.kuali.student.contract.model.impl.ServiceContractModelCache;
import org.kuali.student.contract.model.impl.ServiceContractModelQDoxLoader;
import org.kuali.student.contract.model.util.DateUtility;
import org.kuali.student.contract.model.util.HtmlContractWriter;
import org.kuali.student.contract.model.validation.ServiceContractModelValidator;

/**
 * The plugin entrypoint which is used to generate the html wiki doc of the service interface.
 * @goal kscontractdoc
 * @phase site
 * @requiresProject true
 */
public class KSContractDocMojo extends AbstractKSMojo {

    /**
     * @parameter expression="${htmlDirectory}" default-value="${project.build.directory}/site/services/contractdocs"
     */
    private File htmlDirectory;

    public File getHtmlDirectory() {
        return htmlDirectory;
    }
  
    public void setHtmlDirectory(File htmlDirectory) {
        this.htmlDirectory = htmlDirectory;
    }

    @Override
    public void execute() throws MojoExecutionException {
    	
    	MavenProject project = (MavenProject) getPluginContext().get("project");
    	
    	String formattedDate = DateUtility.asYMDHMInEasternTimeZone(new DateTime());
    	
        ServiceContractModel model = null;
        HtmlContractWriter writer = null;
        getLog().info("publishing wiki contracts");
        model = this.getModel();
        this.validate(model);
        getLog().info("publishing to = " + this.htmlDirectory.toString());
        writer = new HtmlContractWriter(htmlDirectory.toString(), model);
        writer.write(project.getVersion(), formattedDate);


    }
}
