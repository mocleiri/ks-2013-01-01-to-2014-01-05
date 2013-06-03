package com.sigmasys.bsinas.service.impl;

import com.sigmasys.bsinas.config.ConfigService;
import com.sigmasys.bsinas.model.*;
import com.sigmasys.bsinas.service.PersistenceService;
import com.sigmasys.bsinas.service.UserSessionManager;
import com.sigmasys.bsinas.service.aop.LoggingInterceptor;
import com.sigmasys.bsinas.util.RequestUtils;
import org.aopalliance.aop.Advice;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Generic JPA persistence service
 * <p/>
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("persistenceService")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class GenericPersistenceService implements PersistenceService {

    @PersistenceContext(unitName = Constants.PROSAM_PERSISTENCE_UNIT)
    protected EntityManager em;

    @Autowired
    protected UserSessionManager userSessionManager;

    @Autowired
    protected ConfigService configService;


    /**
     * Adds AOP advice to the current instance.
     */
    @Override
    public List<Advice> getAdvices(BeanFactory beanFactory) {
        LinkedList<Advice> advices = new LinkedList<Advice>();
        if (configService != null &&
                Boolean.valueOf(configService.getParameter(Constants.LOGGING_ENABLED_PARAM_NAME))) {
            // Setting up the logging interceptor
            LoggingInterceptor loggingInterceptor = beanFactory.getBean(LoggingInterceptor.class);
            loggingInterceptor.setTargetObject(this);
            advices.add(loggingInterceptor);
        }
        return advices;
    }

    /**
     * Returns Identifiable entity by ID
     *
     * @param id Entity ID
     * @return Identifiable instance
     */
    @Override
    public <T extends Identifiable> T getEntity(Serializable id, Class<T> entityClass) {
        return em.find(entityClass, id);
    }

    /**
     * Removes Identifiable entity by ID
     *
     * @param id Entity ID
     * @return Identifiable instance
     */
    @Override
    @Transactional(readOnly = false)
    public <T extends Identifiable> boolean deleteEntity(Serializable id, Class<T> entityClass) {
        String entityName = entityClass.getSimpleName();
        Query query = em.createQuery("delete from " + entityName + " where id = :id");
        query.setParameter("id", id);
        int updatedRows = query.executeUpdate();
        return updatedRows > 0;
    }

    /**
     * Returns the list of all Identifiable entities for the given class with the default search criteria.
     *
     * @param entityClass Entity Class
     * @return List of Identifiable objects
     */
    @Override
    public <T extends Identifiable> List<T> getEntities(Class<T> entityClass) {
        return getEntities(entityClass, (Pair<String, SortOrder>[]) null);
    }


    /**
     * Returns the list of all Identifiable entities for the given class with the default search criteria.
     *
     * @param entityClass Entity Class
     * @param orderBy     array of fields used in "order by" clause, can be null
     * @return List of Identifiable objects
     */
    @Override
    public <T extends Identifiable> List<T> getEntities(Class<T> entityClass, Pair<String, SortOrder>... orderBy) {
        return getEntities(entityClass, null, null, null, orderBy);
    }

    /**
     * Returns the list of all Identifiable entities for the given class.
     *
     * @param entityClass Entity Class
     * @param predicates  Predicates, can be null
     * @param orderBy     optional array of fields used in "order by" clause, can be null
     * @return List of Identifiable objects
     */
    @Override
    public <T extends Identifiable> List<T> getEntities(Class<T> entityClass,
                                                        List<Predicate> predicates,
                                                        Integer offset,
                                                        Integer limit,
                                                        Pair<String, SortOrder>... orderBy) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> selection = criteriaQuery.from(entityClass);
        selection.alias(entityClass.getSimpleName().toLowerCase());

        criteriaQuery.select(selection);

        if (orderBy != null && orderBy.length > 0) {
            Order[] orders = new Order[orderBy.length];
            int i = 0;
            for (Pair<String, SortOrder> order : orderBy) {
                Path field = selection.get(order.getA());
                SortOrder sortOrder = order.getB();
                orders[i++] = (SortOrder.ASC == sortOrder) ? criteriaBuilder.asc(field) : criteriaBuilder.desc(field);
            }
            criteriaQuery.orderBy(orders);
        }

        if (!CollectionUtils.isEmpty(predicates)) {
            criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        }

        Query query = em.createQuery(criteriaQuery);

        if (offset != null) {
            query.setFirstResult(offset);
        }

        if (limit != null) {
            query.setMaxResults(limit);
        }


        return query.getResultList();
    }


    /**
     * Persists the Identifiable entity in the database.
     * Creates a new entity when ID is null and updates the existing one otherwise.
     *
     * @param entity Identifiable instance
     * @return Entity ID
     */
    @Override
    @Transactional(readOnly = false)
    public <T extends Serializable> T persistEntity(Identifiable entity) {

        if (entity instanceof AuditableEntity) {
            AuditableEntity auditableEntity = (AuditableEntity) entity;
            String userId = (RequestUtils.getThreadRequest() != null) ?
                    userSessionManager.getUserId(RequestUtils.getThreadRequest()) : null;
            Date currentDate = new Date();
            auditableEntity.setLastUpdate(currentDate);
            if (auditableEntity.getId() == null) {
                auditableEntity.setCreatorId(userId);
                auditableEntity.setCreationDate(currentDate);
            } else {
                auditableEntity.setEditorId(userId);
            }
        }

        // Persisting the JPA entity with Entity Manager
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }

        em.flush();

        return (T) entity.getId();
    }

    protected <T extends AuditableEntity> T getAuditableEntityByCode(String code, Class<T> entityType) {
        Query query = em.createQuery("select e from " + entityType.getSimpleName() + " e where e.code = :code");
        query.setParameter("code", code);
        List<T> entities = query.getResultList();
        return (entities != null && !entities.isEmpty()) ? entities.get(0) : null;
    }

}
