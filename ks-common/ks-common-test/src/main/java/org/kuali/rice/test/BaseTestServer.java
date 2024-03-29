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
package org.kuali.rice.test;

import org.kuali.rice.core.api.lifecycle.Lifecycle;
import org.mortbay.jetty.Server;

/**
 * Abstract class to provide convenience methods for starting and stopping a
 * Jetty Server instance.
 * 
 * @author Kuali Rice Team (rice.collab@kuali.org)
 * @since 0.9
 */
public abstract class BaseTestServer implements Lifecycle {

    private Server server;

    protected abstract Server createServer();

    public Server getServer() {
        return this.server;
    }

    public void start() throws Exception {
        this.server = createServer();
        if (this.server == null) {
        	throw new RuntimeException("Server not successfully created for class: " + getClass().getName());
        }
        this.server.start();
    }

    public void stop() throws Exception {
        if (this.server != null) {
        	this.server.stop();
        }
    }

    public boolean isStarted() {
        if (this.server == null) {
        	return false;
        }
    	return this.server.isStarted();
    }
}
