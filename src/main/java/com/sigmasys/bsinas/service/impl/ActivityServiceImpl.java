package com.sigmasys.bsinas.service.impl;

import com.sigmasys.bsinas.model.Activity;
import com.sigmasys.bsinas.service.ActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Activity Service implementation
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("activityService")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class ActivityServiceImpl extends GenericPersistenceService implements ActivityService {


    private List<Activity> getActivities(Long id) {
        Query query = em.createQuery("select act from Activity act " +
                " left outer join fetch act.type t " +
                ((id != null) ? " where act.id = :id " : "") +
                " order by act.timestamp desc");
        if (id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    /**
     * Returns Activity by ID
     *
     * @param id Activity ID
     * @return Activity instance
     */
    @Override
    public Activity getActivity(Long id) {
        List<Activity> activities = getActivities(id);
        return (activities != null && !activities.isEmpty()) ? activities.get(0) : null;
    }

    /**
     * Returns all activities sorted by ID in the descendant order
     *
     * @return List of activities
     */
    @Override
    public List<Activity> getActivities() {
        return getActivities((Long) null);
    }

    /**
     * Returns all activities sorted by ID in the descendant order for the given Account ID.
     *
     * @param userId Account ID
     * @return List of activities
     */
    @Override
    public List<Activity> getActivities(String userId) {
        Query query = em.createQuery("select act from Activity act " +
                " left outer join fetch act.type t " +
                " where act.creatorId = :userId " +
                " order by act.timestamp desc");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    /**
     * Persists the activity in the database.
     * Creates a new entity when ID is null and updates the existing one otherwise.
     *
     * @param activity Activity instance
     * @return Activity ID
     */
    @Override
    @Transactional(readOnly = false)
    public Long persistActivity(Activity activity) {
        return persistEntity(activity);
    }

    /**
     * Removes the activity from the database.
     *
     * @param id Activity ID
     * @return true if the Activity entity has been deleted
     */
    @Override
    @Transactional(readOnly = false)
    public boolean deleteActivity(Long id) {
        return deleteEntity(id, Activity.class);
    }

}
