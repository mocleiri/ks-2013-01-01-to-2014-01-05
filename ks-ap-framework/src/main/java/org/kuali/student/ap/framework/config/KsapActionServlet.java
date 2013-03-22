package org.kuali.student.ap.framework.config;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.BigIntegerConverter;
import org.apache.commons.beanutils.converters.BooleanConverter;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.CharacterConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.collections.iterators.IteratorEnumeration;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionServlet;
import org.kuali.rice.core.api.config.ConfigurationException;
import org.kuali.rice.core.framework.config.module.ModuleConfigurer;
import org.kuali.rice.core.framework.config.module.WebModuleConfiguration;

/**
 * @deprecated TODO: KSAP-26 Move KsapAbstractModuleConfigurer to Rice.
 */
public class KsapActionServlet extends ActionServlet {

	private static final long serialVersionUID = 7937712460359668856L;

	private static final Logger LOG = Logger.getLogger(KsapActionServlet.class);

    // KULRICE-8176: KFS Notes/Attachments Tab Functionality for Note Text Error - Visible/Special characters, spaces, or tabs
    private String parameterEncoding = "";

    /**
     * <p>Initialize other global characteristics of the controller servlet.</p>
     * Overridden to remove the ConvertUtils.deregister() command that caused problems
     * with the concurrent data dictionary load.  (KULRNE-4405)
     *
     * @exception javax.servlet.ServletException if we cannot initialize these resources
     */
    @Override
    protected void initOther() throws ServletException {

        String value = null;
        value = getServletConfig().getInitParameter("config");
        if (value != null) {
            config = value;
        }

        // Backwards compatibility for form beans of Java wrapper classes
        // Set to true for strict Struts 1.0 compatibility
        value = getServletConfig().getInitParameter("convertNull");
        if ("true".equalsIgnoreCase(value)
                || "yes".equalsIgnoreCase(value)
                || "on".equalsIgnoreCase(value)
                || "y".equalsIgnoreCase(value)
                || "1".equalsIgnoreCase(value)) {

            convertNull = true;
        }

        if (convertNull) {
            ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
            ConvertUtils.register(new BigIntegerConverter(null), BigInteger.class);
            ConvertUtils.register(new BooleanConverter(null), Boolean.class);
            ConvertUtils.register(new ByteConverter(null), Byte.class);
            ConvertUtils.register(new CharacterConverter(null), Character.class);
            ConvertUtils.register(new DoubleConverter(null), Double.class);
            ConvertUtils.register(new FloatConverter(null), Float.class);
            ConvertUtils.register(new IntegerConverter(null), Integer.class);
            ConvertUtils.register(new LongConverter(null), Long.class);
            ConvertUtils.register(new ShortConverter(null), Short.class);
        }

        // KULRICE-8176: KFS Notes/Attachments Tab Functionality for Note Text Error - Visible/Special characters, spaces, or tabs
        parameterEncoding = getServletConfig().getInitParameter("PARAMETER_ENCODING");
    }

    KualiActionServletConfig serverConfigOverride = null;

    @Override
    public ServletConfig getServletConfig() {
        if ( serverConfigOverride == null ) {
            ServletConfig sConfig = super.getServletConfig();

            if ( sConfig == null ) {
                return null;
            }
            serverConfigOverride = new KualiActionServletConfig(sConfig);
        }
        return serverConfigOverride;
    }

    /**
     * A custom ServletConfig implementation which dynamically includes web content based on the installed modules in the RiceConfigurer object.
     *   Accomplishes this by implementing custom
     * {@link #getInitParameter(String)} and {@link #getInitParameterNames()} methods.
     */
    private class KualiActionServletConfig implements ServletConfig {

        private ServletConfig wrapped;
        private Map<String,String> initParameters = new HashMap<String, String>();

        public KualiActionServletConfig(ServletConfig wrapped) {
            this.wrapped = wrapped;
            // copy out all the init parameters so they can be augmented
            @SuppressWarnings("unchecked")
            final Enumeration<String> initParameterNames = wrapped.getInitParameterNames();
            while ( initParameterNames.hasMoreElements() ) {
                String paramName = initParameterNames.nextElement();
                initParameters.put( paramName, wrapped.getInitParameter(paramName) );
            }
            // loop over the installed modules, adding their struts configuration to the servlet
            // if they have a web interface
            final Collection<Object> riceModules = AbstractKsapModuleConfigurer.getCurrentContextConfigurers();

            if ( LOG.isInfoEnabled() ) {
                LOG.info( "Configuring init parameters of the KualiActionServlet from riceModules: " + riceModules );
            }
            Object[] tempModules = new Object[riceModules.size()];
            tempModules = riceModules.toArray();

            for(int i = 0; i < tempModules.length; i++){
                try{
                    AbstractKsapModuleConfigurer module = (AbstractKsapModuleConfigurer) tempModules[i];
                    if ( module.shouldRenderWebInterface() ) {
                        WebModuleConfiguration webModuleConfiguration = module.getWebModuleConfiguration();
                        if (webModuleConfiguration == null) {
                            throw new ConfigurationException("Attempting to load WebModuleConfiguration for module '" + module.getModuleName() + "' but no configuration was provided!");
                        }
                        if ( LOG.isInfoEnabled() ) {
                            LOG.info( "Configuring Web Content for Module: " + webModuleConfiguration.getModuleName()
                                    + " / " + webModuleConfiguration.getWebModuleStrutsConfigName()
                                    + " / " + webModuleConfiguration.getWebModuleStrutsConfigurationFiles()
                                    + " / Base URL: " + webModuleConfiguration.getWebModuleBaseUrl() );
                        }
                        if ( !initParameters.containsKey( webModuleConfiguration.getWebModuleStrutsConfigName() ) ) {
                            initParameters.put( webModuleConfiguration.getWebModuleStrutsConfigName(), webModuleConfiguration.getWebModuleStrutsConfigurationFiles() );
                        }
                    }
                }catch(Exception e){
                    ModuleConfigurer module = (ModuleConfigurer) tempModules[i];
                    if ( module.shouldRenderWebInterface() ) {
                        WebModuleConfiguration webModuleConfiguration = module.getWebModuleConfiguration();
                        if (webModuleConfiguration == null) {
                            throw new ConfigurationException("Attempting to load WebModuleConfiguration for module '" + module.getModuleName() + "' but no configuration was provided!");
                        }
                        if ( LOG.isInfoEnabled() ) {
                            LOG.info( "Configuring Web Content for Module: " + webModuleConfiguration.getModuleName()
                                    + " / " + webModuleConfiguration.getWebModuleStrutsConfigName()
                                    + " / " + webModuleConfiguration.getWebModuleStrutsConfigurationFiles()
                                    + " / Base URL: " + webModuleConfiguration.getWebModuleBaseUrl() );
                        }
                        if ( !initParameters.containsKey( webModuleConfiguration.getWebModuleStrutsConfigName() ) ) {
                            initParameters.put( webModuleConfiguration.getWebModuleStrutsConfigName(), webModuleConfiguration.getWebModuleStrutsConfigurationFiles() );
                        }
                    }
                }
            }

        }

        @Override
        public String getInitParameter(String name) {
            return initParameters.get(name);
        }

        @Override
        @SuppressWarnings("unchecked")
        public Enumeration<String> getInitParameterNames() {
            return new IteratorEnumeration( initParameters.keySet().iterator() );
        }

        @Override
        public ServletContext getServletContext() {
            return wrapped.getServletContext();
        }
        @Override
        public String getServletName() {
            return wrapped.getServletName();
        }
    }

    /**
     *  KULRICE-8176: KFS Notes/Attachments Tab Functionality for Note Text Error - Visible/Special characters, spaces, or tabs
     *
     * @see org.apache.struts.action.ActionServlet#process(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (StringUtils.isNotBlank(parameterEncoding)) {
            request.setCharacterEncoding(parameterEncoding);
            response.setCharacterEncoding(parameterEncoding);
        }

        super.process(request, response);
    }
}
