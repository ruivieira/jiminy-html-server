package com.redhat.analytics.jiminy.htmlserver.service;

import com.redhat.analytics.jiminy.htmlserver.model.Ratings;
import com.redhat.analytics.jiminy.htmlserver.model.RatingsDAO;
import com.redhat.analytics.jiminy.htmlserver.repository.RatingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDBRatingService implements RatingService {

    @Autowired
    RatingRepository repository;


    @Override
    public RatingsDAO create(RatingsDAO r) {
        Ratings rating= repository.save(new Ratings(r.getId(), r.getProduct(), r.getRating()));
        return new RatingsDAO(rating);
    }

    @Override
    public RatingsDAO delete(Integer id) {
        Ratings ratings= findById(id);
        repository.delete(ratings);
        return new RatingsDAO(ratings);
    }

    @Override
    public List<RatingsDAO> findAll() {
        return null;
    }

    @Override
    public RatingsDAO findById(String id) {
        return null;
    }

    @Override
    public RatingsDAO update(RatingsDAO users) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
