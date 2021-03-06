package io.radanalytics.jiminy.service;

import java.util.List;
import static java.util.stream.Collectors.toList;

import io.radanalytics.jiminy.model.Ratings;
import io.radanalytics.jiminy.model.RatingsDAO;
import io.radanalytics.jiminy.RatingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PostgresRatingService<br>
 * 
 * Provides the interface between the controller and the data access layer.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
@Service
public class PostgresRatingService implements RatingService {

    @Autowired
    RatingRepository repository;

    @Override
    public RatingsDAO create(RatingsDAO r) {
        Ratings rating= repository.save(new Ratings(r.getUserid(), r.getMovieid(), r.getRating(), 1 ));
        return new RatingsDAO(rating);
    }

    private RatingsDAO convertToDAO( Ratings ratings){
        return new RatingsDAO(ratings);
    }

    @Override
    public RatingsDAO delete(long id) {
        Ratings ratings= repository.findOne(id);
        repository.delete(ratings);
        return new RatingsDAO(ratings);
    }

    @Override
    public List<RatingsDAO> findAll() {
        return repository.findAll().stream().map(this::convertToDAO).collect(toList());
    }

    @Override
    public RatingsDAO findById(long id){
        Ratings ratings= repository.findOne(id);
        return new RatingsDAO(ratings);
    }

    @Override
    public RatingsDAO update(RatingsDAO rate) {
        Ratings rating= repository.findOne(rate.getId());
        if(rating != null){
            return convertToDAO(rating);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}