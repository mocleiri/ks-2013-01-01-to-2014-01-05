package com.sigmasys.bsinas.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.Clob;
import java.util.*;


public final class CommonUtils {

    private static final String PROPERTIES_PATH = "bsinas.properties";

    private static final Log logger = LogFactory.getLog(CommonUtils.class);


    private CommonUtils() {
    }

    public static Properties getProperties(String name, Class<?> clazz) {
        try {
            Properties props = new Properties();
            InputStream in = clazz.getClassLoader().getResourceAsStream(name);
            if (in == null) {
                logger.warn("Resource '" + name + "' is not found");
                return null;
            }
            props.load(in);
            return props;
        } catch (Exception e) {
            logger.error("Exception occurred while loading properties: ", e);
            throw new RuntimeException("Exception occurred while loading properties: ", e);
        }
    }

    public static Properties getProperties(String name) {
        return getProperties(name, CommonUtils.class);
    }

    public static Properties getProperties() {
        return getProperties(PROPERTIES_PATH);
    }

    public static String getResourceAsString(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = CommonUtils.class.getClassLoader();
        }
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return getResourceAsString(resource, classLoader);
    }

    public static String getStreamAsString(InputStream inputStream) {
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(inputStream);
            byte[] buffer = new byte[2048];
            StringBuilder stringBuffer = new StringBuilder();
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                stringBuffer.append(new String(buffer, 0, bytesRead));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.warn(e.getMessage(), e);
                }
            }
        }
    }

    public static String getResourceAsString(String resource, ClassLoader classLoader) {
        try {
            return getStreamAsString(classLoader.getResourceAsStream(resource));
        } catch (Exception e) {
            logger.error("Cannot load resource defined as " + resource, e);
            throw new RuntimeException("Cannot load resource defined as " + resource, e);
        }
    }

    public static String getModuleBaseUrl(HttpServletRequest request) {
        // Initializing base service URL, i.e.
        // http://localhost:8080/sonar/org.bsinas.Application/Application.html
        // will return /org.finra.sonar.Application/
        String requestedUri = request.getRequestURI();
        int contextEnd = request.getContextPath().length();
        int folderEnd = requestedUri.lastIndexOf('/') + 1;
        return requestedUri.substring(contextEnd, folderEnd);
    }

    public static String nvl(String value) {
        return (value != null) ? value : "";
    }

    /**
     * Fetch the entire contents of a text file, and return it in a String.
     * This style of implementation does not throw Exceptions to the caller.
     *
     * @param file is a file which already exists and can be read.
     */
    public static String getText(File file) {
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader input = new BufferedReader(new FileReader(file));
            try {
                String lineSeparator = System.getProperty("line.separator");
                if (lineSeparator == null) {
                    lineSeparator = "\n";
                }
                for (String line; (line = input.readLine()) != null; ) {
                    builder.append(line);
                    builder.append(lineSeparator);
                }
                return builder.toString();
            } finally {
                input.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static String clobToString(Clob clob) {
        try {
            StringWriter writer = new StringWriter();
            IOUtils.copy(clob.getCharacterStream(), writer);
            return writer.toString();
        } catch (Exception e) {
            String msg = "Cannot convert CLOB (" + clob + ") to java.util.String";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

}
