/**
 * Copyright 2013 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
package org.kuali.student.security.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This class provides tests for Spring Security Configuration
 *
 * @author Kuali Student Team
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
        locations = {
                "classpath:ks-spring-security.xml",
                "classpath:test-spring-security-config.xml"
        }
)
public class SpringSecurityTest {
    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private org.springframework.web.context.WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .addFilters(this.springSecurityFilterChain).build();
    }

    @Test
    public void testDeepUrlRequiresAuthentication() throws Exception {
        // for any deep content, we expect a redirect because of spring security
        mockMvc.perform(get("/some_deep_content"))
                .andExpect(redirectedUrl("http://localhost/login.jsp"));

    }

    @Test
    public void testNoSecurityForUnauthenticatedContent() throws Exception {
        List<String> pathsToTest = Arrays.asList("/logout.html",
                "/services/A",
                "/favicon.ico",
                "/login.jsp",
                "/index.jsp",
                "/a.css",
                "/b.js",
                "/c.png",
                "/d.gif",
                "/e.jpg",
                "/themes/ksboot/theme-derived.properties");

        // for each of the tested paths, we expect no security at all.
        // Content will be 404 Not Found as we are only testing Spring Security and not
        // the MVC layer
        for (String path : pathsToTest) {
            mockMvc.perform(get(path))
                    .andExpect(status().isNotFound());
        }
    }

    @Test
    public void testUserAuthenticatesSuccessfully() throws Exception {
        final String username = "user";

        // when supplying a username (with any password), we expect a redirect to /
        // furthermore, after authentication, principal should now be present in session
        mockMvc.perform(post("/j_spring_security_check").param("j_username", username).param("j_password", "anything"))
                .andExpect(redirectedUrl("/"))
                .andExpect(new ResultMatcher() {
                    @Override
                    public void match(MvcResult result) throws Exception {
                        HttpSession session = result.getRequest().getSession();
                        SecurityContext securityContext = (SecurityContext) session.getAttribute(SPRING_SECURITY_CONTEXT_KEY);
                        assertEquals(securityContext.getAuthentication().getName(), username);
                    }
                });
    }
}
