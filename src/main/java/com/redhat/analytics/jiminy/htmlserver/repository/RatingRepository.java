package com.redhat.analytics.jiminy.htmlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redhat.analytics.jiminy.htmlserver.model.Ratings;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, Long> { 
 
}
