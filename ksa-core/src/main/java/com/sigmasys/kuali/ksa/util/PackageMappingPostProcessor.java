package com.sigmasys.kuali.ksa.util;

import com.sigmasys.kuali.ksa.annotation.AnnotationUtils;

import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

import javax.persistence.Entity;
import java.util.Set;

/**
 * PackageMappingPostProcessor is used to narrow the JPA scan scope.
 *
 * @author Michael Ivanov
 */
public class PackageMappingPostProcessor implements PersistenceUnitPostProcessor {

    private String[] packageNames;

    public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo pui) {
        Set<Class> annotatedClasses = AnnotationUtils.findAnnotatedClasses(Entity.class, packageNames);
        for (Class entityClass : annotatedClasses) {
            pui.addManagedClassName(entityClass.getName());
        }
        pui.setExcludeUnlistedClasses(true);
    }

    public void setPackageNames(String[] packageNames) {
        this.packageNames = packageNames;
    }
}