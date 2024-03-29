/**
 * Copyright 2005-2011 The Kuali Foundation
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
package org.kuali.rice.krms.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.kuali.rice.krms.api.engine.TermResolutionException;
import org.kuali.rice.krms.api.engine.TermResolver;
import org.kuali.rice.krms.api.repository.term.TermResolverDefinition;
import org.kuali.rice.krms.api.repository.term.TermSpecificationDefinition;
import org.kuali.rice.krms.framework.type.TermResolverTypeService;

public class TestTermResolverTypeService implements TermResolverTypeService {

    public TestTermResolverTypeService() {
        this.toString();
    }

    // @Override
    public TermResolver<?> loadTermResolver(
            final TermResolverDefinition termResolverDefinition) {
        
        if ("testResolver1".equals(termResolverDefinition.getName())) {
            return new TermResolver<String>() {

                //@Override
                public Set<String> getPrerequisites() {
                    HashSet<String> results = new HashSet<String>();
                    
                    Set<TermSpecificationDefinition> prereqDefs = termResolverDefinition.getPrerequisites();
                    if (prereqDefs != null) for (TermSpecificationDefinition def : prereqDefs) {
                        results.add(def.getName());
                    }
                    
                    return results;
                }

                // @Override
                public String getOutput() {
                    TermSpecificationDefinition def = termResolverDefinition.getOutput();
                    return def.getName();
                }

                //@Override
                public Set<String> getParameterNames() {
                    return Collections.unmodifiableSet(termResolverDefinition.getParameterNames());
                }

               // @Override
                public int getCost() {
                    return 1;
                }

                //@Override
                public String resolve(
                        Map<String, Object> resolvedPrereqs,
                        Map<String, String> parameters)
                        throws TermResolutionException {
                    return "RESULT1";
                }
                
            };
        }
        return null;
    }

}
