package com.sigmasys.kuali.ksa.config;

import org.kuali.rice.core.api.config.property.ConfigContext;
import org.kuali.rice.ksb.messaging.config.KSBConfigurer;
import org.springframework.context.ApplicationEvent;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * KSB configurer extension
 *
 * @author Michael Ivanov
 */
@Transactional(timeout = 300, readOnly = true)
public class KsbConfigurer extends KSBConfigurer {

    public static final String ENABLE_MESSAGING_PARAM_NAME = "message.enable";

    private static final String MESSAGE_CLIENT_SPRING = "classpath:org/kuali/rice/ksb/config/KsbMessageClientSpringBeans.xml";
    private static final String OJB_MESSAGE_CLIENT_SPRING = "classpath:org/kuali/rice/ksb/config/KsbOjbMessageClientSpringBeans.xml";

    private boolean enableMessaging;

    @PostConstruct
    private void postConstruct() {
        enableMessaging = ConfigContext.getCurrentContextConfig().getBooleanProperty(ENABLE_MESSAGING_PARAM_NAME, true);
    }

    @Override
    public List<String> getPrimarySpringFiles() {
        List<String> springFiles = super.getPrimarySpringFiles();
        if (!enableMessaging) {
            springFiles.remove(MESSAGE_CLIENT_SPRING);
            springFiles.remove(OJB_MESSAGE_CLIENT_SPRING);
        }
        return springFiles;
    }

    @Override
    protected void doAdditionalModuleStartLogic() {
        // KSA application does not need to use remote services during startup so do nothing
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        super.onApplicationEvent(applicationEvent);
    }

}
