package com.redhat.analytics.jiminy.htmlserver.service;

import com.redhat.analytics.jiminy.htmlserver.model.RatingsDAO;
import java.util.List;

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
