<%--

    Copyright 2005-2012 The Kuali Foundation

    Licensed under the Educational Community License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.opensource.org/licenses/ecl2.php

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@ include file="/WEB-INF/jsp/tldHeader.jsp"%>

<tiles:useAttribute name="field" classname="org.kuali.rice.krad.uif.field.IframeField"/>

<%--
    Standard HTML Iframe element
    
 --%>

<iframe id="${field.id}" src="${field.source}" 
        width="${field.width}" height="${field.height}" hspace="${field.hspace}" vspace="${field.vspace}" 
        frameborder="${field.frameborder}" title="${field.title}">
</iframe>