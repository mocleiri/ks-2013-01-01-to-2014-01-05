package com.sigmasys.bsinas.service;

import com.sigmasys.bsinas.model.Activity;

import java.util.List;

/**
 * Activity Service
 * <p/>
 *
 * @author Michael Ivanov
 */
public interface ActivityService {

    /**
     * Returns Activity by ID
     *
     * @param id Activity ID
     * @return Activity instance
     */
    Activity getActivity(Long id);

    /**
     * Returns all activities sorted by ID in the descendant order
     *
     * @return List of activities
     */
    List<Activity> getActivities();

    /**
     * Returns all activities sorted by ID in the descendant order for the given Account ID.
     *
     * @param userId Account ID
     * @return List of activities
     */
    List<Activity> getActivities(String userId);

    /**
     * Persists the activity in the database.
     * Creates a new entity when ID is null and updates the existing one otherwise.
     *
     * @param activity Activity instance
     * @return Activity ID
     */
    Long persistActivity(Activity activity);

    /**
     * Removes the activity from the database.
     *
     * @param id Activity ID
     * @return true if the Activity entity has been deleted
     */
    boolean deleteActivity(Long id);

}
