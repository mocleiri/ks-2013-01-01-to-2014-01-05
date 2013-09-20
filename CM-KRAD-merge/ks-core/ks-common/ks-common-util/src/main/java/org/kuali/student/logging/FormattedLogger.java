/*
 * Copyright 2007 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl2.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import static org.apache.log4j.Level.*;

/**
 * Class with static methods wrapping {@link Log} methods. Automatically sets up Log for you. It's called the <code>FormattedLogger</code> because
 * it handles everything in ansi-C standard printf format. For example, <code>printf("The epoch time is now %d", new Date().getTime())</code>.<br/>
 * <br/>
 *  
 * To use these just do
 * <code>
 * import org.kuali.student.logging.FormattedLogger.*
 * </code>
 * 
 * @see java.util.logging.Logger
 * @see java.util.logging.Level
 * @author OpenCollab/rSmart KRAD CM Conversion Alliance!
 */
public class FormattedLogger {
    
    /**
     * Applies a pattern with parameters to create a {@link String} used as a logging message
     *  
     * 
     * @param pattern to format against
     * @param objs an array of objects used as parameters to the <code>pattern</code>
     * @return Logging Message
     */
    private static final String getMessage(String pattern, Object ... objs) {
        StringWriter retval = new StringWriter();
        PrintWriter writer = new PrintWriter(retval);
        
        writer.printf(pattern, objs);
        
        return retval.toString();
    }
    
    /**
     * Uses {@link StackTraceElement[]} from {@link Throwable} to determine the calling class. Then, the {@link Log} is retrieved for it by
     * convention
     * 
     * 
     * @return Log for the calling class
     */
    private static final Logger getLog() {
        try {
            return Logger.getLogger(new Throwable().getStackTrace()[3].getClassName());
        }
        catch (Exception e) {
            return Logger.getLogger(FormattedLogger.class.getName());
        }
    }

    /**
     * Wraps {@link Log#debug(String)}
     * 
     * @param pattern to format against
     * @param objs an array of objects used as parameters to the <code>pattern</code>
     */
    public static final void debug(String pattern, Object ... objs) {
        Logger log = getLog();
        if (log.isEnabledFor(DEBUG)) {
            log.debug(getMessage(pattern, objs));
        }
    }
    
    public static final boolean isDebuggingEnabled() {
        return getLog().isEnabledFor(DEBUG);
    }
    
    /**
     * Wraps {@link Logger#throwing(String)}
     * 
     * @param the thing that was thrown
     */
    public static final void throwing(final Throwable thrown) {
        final StackTraceElement element = new Throwable().getStackTrace()[3];
        final Logger log = Logger.getLogger(element.getClassName());
        log.trace(element.getClassName() + element.getMethodName(), thrown);
    }

    
    /**
     * Wraps {@link Log#info(String)}
     * 
     * @param pattern to format against
     * @param objs an array of objects used as parameters to the <code>pattern</code>
     */
    public static final void info(String pattern, Object ... objs) {
        Logger log = getLog();
        if (log.isEnabledFor(INFO)) {
            log.info(getMessage(pattern, objs));
        }
    }

    /**
     * Wraps {@link Logger#config(String)}
     * 
     * @param pattern to format against
     * @param objs an array of objects used as parameters to the <code>pattern</code>
     */
    public static final void trace(String pattern, Object ... objs) {
        Logger log = getLog();
        if (log.isEnabledFor(TRACE)) {
            log.trace(getMessage(pattern, objs));
        }
    }


    /**
     * Wraps {@link Logger#warning(String)}
     * 
     * @param pattern to format against
     * @param objs an array of objects used as parameters to the <code>pattern</code>
     */
    public static final void warn(String pattern, Object ... objs) {
        Logger log = getLog();
        if (log.isEnabledFor(WARN)) {
            log.warn(getMessage(pattern, objs));
        }
    }

    /**
     * Wraps {@link Logger#severe(String)}
     * 
     * @param pattern to format against
     * @param objs an array of objects used as parameters to the <code>pattern</code>
     */
    public static final void error(String pattern, Object ... objs) {
        Logger log = getLog();
        if (log.isEnabledFor(ERROR)) {
            log.error(getMessage(pattern, objs));
        }
    }
}