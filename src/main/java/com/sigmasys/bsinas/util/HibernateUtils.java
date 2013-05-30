package com.sigmasys.bsinas.util;


import net.sf.beanlib.PropertyInfo;
import net.sf.beanlib.hibernate.HibernateBeanReplicator;
import net.sf.beanlib.hibernate.UnEnhancer;
import net.sf.beanlib.hibernate3.Hibernate3BeanReplicator;
import net.sf.beanlib.provider.JavaBeanDetailedPropertyFilter;
import net.sf.beanlib.spi.BeanTransformerSpi;
import net.sf.beanlib.spi.CustomBeanTransformerSpi;
import org.hibernate.Hibernate;

/**
 * HibernateUtils.
 * It is primarily used for GWT serialization.
 *
 * @author ivanovm
 */
public class HibernateUtils {

    private static final HibernateBeanReplicator hibernateBeanReplicator;

    static {
        // Using Javassist instead of CGLIB (performance enhancement) at the global level
        UnEnhancer.setDefaultCheckCGLib(false);
        // Creating a hibernate bean replicator to copy Hibernate-managed entities
        hibernateBeanReplicator = new Hibernate3BeanReplicator();
        hibernateBeanReplicator.initDetailedPropertyFilter(JavaBeanDetailedPropertyFilter.ALWAYS_PROPAGATE);
        hibernateBeanReplicator.initCustomTransformerFactory(new LazyKillingBeanTransformerFactory());
    }


    private HibernateUtils() {
    }


    /**
     * A custom bean transformer that sets non-initialized Hibernate entity properties to NULL
     */
    private static class LazyKillingBeanTransformerFactory implements CustomBeanTransformerSpi.Factory {
        @Override
        public CustomBeanTransformerSpi newCustomBeanTransformer(BeanTransformerSpi beanTransformer) {
            return new CustomBeanTransformerSpi() {
                @Override
                public boolean isTransformable(Object from, Class<?> toClass, PropertyInfo propertyInfo) {
                    // apply custom transformation for the uninitialized properties
                    return !Hibernate.isInitialized(from);
                }

                @Override
                public <T> T transform(Object in, Class<T> toClass, PropertyInfo propertyInfo) {
                    // custom transform by not replicating the uninitialized properties
                    return null;
                }
            };
        }
    }

    public static <T> T detach(T entity) {
        // Using Javassist instead of CGLIB (performance enhancement) per thread
        UnEnhancer.setCheckCGLibForThisThread(false);
        // Making a copy with HibernateBeanReplicator
        return hibernateBeanReplicator.deepCopy(entity);
    }


}
