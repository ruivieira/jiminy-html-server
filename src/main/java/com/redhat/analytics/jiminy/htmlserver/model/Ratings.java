package com.redhat.analytics.jiminy.htmlserver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Ratings<br>
 * 
 * Rating Model class used for persistence with postgres datastore backend.
 * @author Zak Hassan <zhassan@redhat.com>
 */
@Entity
@Table(name = "ratings")
public class Ratings implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Integer userid;
 	private Integer movieid;
	private double rating;
	private Integer timestamp;

	public Ratings(){
		
	}
	public Ratings(Integer userid, Integer movieid, double rating, Integer timestamp) {
		
		this.userid = userid;
		this.movieid = movieid;
		this.rating = rating;
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getMovieId() {
		return movieid;
	}

	public void setMovieId(Integer movieId) {
		this.movieid = movieId;
	}

	@Override
	public String toString() {
		return "Ratings [id=" + id + ", userid=" + userid + ", movieId=" + movieid + ", rating=" + rating
				+ ", timestamp=" + timestamp + "]";
	}
}
