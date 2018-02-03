package io.radanalytics.jiminy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.radanalytics.jiminy.model.Ratings;

/**
 * RatingRepository<br>
 * 
 * Using Spring Data JPA here to provide for easier persistence to the database. In the JpaRepository we pass in a key
 * which is the Model class and the data type of the primary key.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
@Repository
public interface RatingRepository extends JpaRepository<Ratings, Long> {
 
}
