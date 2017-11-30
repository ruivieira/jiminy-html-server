package com.redhat.analytics.jiminy.htmlserver.repository;

import com.redhat.analytics.jiminy.htmlserver.model.Ratings;


import java.util.List;

//@Repository
public interface RatingRepository { //extends CrudRepository<Ratings, Long> { //extends MongoRepository<Ratings, Integer> {

    void delete(Ratings user);

    List<Ratings> findAll();


    Ratings findOne(long id);

    Ratings save(Ratings rating);
}
