package org.kuali.student.lum.program.client.core.edit;

import org.kuali.student.common.ui.client.configurable.mvc.views.VerticalSectionView;
import org.kuali.student.common.ui.client.widgets.field.layout.element.MessageKeyInfo;
import org.kuali.student.lum.common.client.configuration.AbstractSectionConfiguration;
import org.kuali.student.lum.program.client.ProgramConstants;
import org.kuali.student.lum.program.client.ProgramSections;
import org.kuali.student.lum.program.client.properties.ProgramProperties;

/**
 * @author Igor
 */
public class CoreCatalogInformationEditConfiguration extends AbstractSectionConfiguration {

    public CoreCatalogInformationEditConfiguration() {
        rootSection = new VerticalSectionView(ProgramSections.CATALOG_INFO_EDIT, ProgramProperties.get().program_menu_sections_catalogInfo(), ProgramConstants.PROGRAM_MODEL_ID);
    }

    @Override
    protected void buildLayout() {
        configurer.addField(rootSection, ProgramConstants.DESCRIPTION + "/plain", new MessageKeyInfo(ProgramProperties.get().catalogInformation_descr()));
        configurer.addField(rootSection, ProgramConstants.CATALOG_DESCRIPTION + "/plain", new MessageKeyInfo(ProgramProperties.get().catalogInformation_catalogDescr()));
        configurer.addField(rootSection, ProgramConstants.PUBLICATION_TARGETS, new MessageKeyInfo(ProgramProperties.get().catalogInformation_catalogPublicationTargets()));
        configurer.addField(rootSection, ProgramConstants.MORE_INFORMATION, new MessageKeyInfo(ProgramProperties.get().catalogInformation_referenceUrl()));
    }
}
