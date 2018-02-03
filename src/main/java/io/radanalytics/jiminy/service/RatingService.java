package io.radanalytics.jiminy.service;

import java.util.List;

import io.radanalytics.jiminy.model.RatingsDAO;

/**
 * RatingService<br>
 * 
 * Simple interface for what operations would be required of this service.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
public interface RatingService {
 
    RatingsDAO create(RatingsDAO user);

    RatingsDAO delete(long id);

    List<RatingsDAO> findAll();

    RatingsDAO findById(long id);

    RatingsDAO update(RatingsDAO users);

    void deleteAll();

}
