package io.radanalytics.jiminy;

import io.radanalytics.jiminy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RatingRepository<br>
 * 
 * Using Spring Data JPA here to provide for easier persistence to the database. In the JpaRepository we pass in a key
 * which is the Model class and the data type of the primary key.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
 
}
