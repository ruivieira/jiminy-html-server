package com.redhat.analytics.jiminy.htmlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redhat.analytics.jiminy.htmlserver.model.Ratings;

/**
 * RatingRepository<br>
 * 
 * Using spring data jpa here to provide for easier persistence to the database. In the JpaRepository we pass in a key
 * which is the Model class and the data type of the primary key.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
@Repository
public interface RatingRepository extends JpaRepository<Ratings, Long> { 
 
}
