package com.redhat.analytics.jiminy.htmlserver.repository;

import com.redhat.analytics.jiminy.htmlserver.model.Ratings;

public class RatingRepository extends MongoRepository<Ratings, String> {
    Rating findByRating(int id);

    void delete(Rating user);

    List<Rating> findAll();


    Rating  findOne(String id);

    Rating save(Rating user);
}
