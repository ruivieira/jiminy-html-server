package com.redhat.analytics.jiminy.htmlserver.service;

import com.redhat.analytics.jiminy.htmlserver.model.RatingsDAO;
import java.util.List;

public interface RatingService {
 
    RatingsDAO create(RatingsDAO user);

    RatingsDAO delete(long id);

    List<RatingsDAO> findAll();

    RatingsDAO findById(long id);

    RatingsDAO update(RatingsDAO users);

    void deleteAll();

  

}
