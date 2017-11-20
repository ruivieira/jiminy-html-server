package com.redhat.analytics.jiminy.htmlserver.repository;

import com.redhat.analytics.jiminy.htmlserver.model.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Ratings, Integer> {

    void delete(Ratings user);

    List<Ratings> findAll();

    Ratings  findOne(int id);

    Ratings save(Ratings rating);
}
