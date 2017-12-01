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
 * Rating Model class
 *
 * @author Zak Hassan
 */
@Entity
@Table(name = "productratings")
public class Ratings implements Serializable {
	@GenericGenerator(name = "usersSequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "usersSequence"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })

	@Id
	@GeneratedValue(generator = "usersSequenceGenerator")
	private long id;
	private Integer userid;
	private Integer product;
	private double rating;
	private Integer timestamp;

	public Ratings(Integer userid, Integer product, double rating, Integer timestamp) {
		this.userid = userid;
		this.product = product;
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

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
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

	@Override
	public String toString() {
		return "Ratings{" + "id='" + id + '\'' + ", userid=" + userid + ", product=" + product + ", rating=" + rating
				+ '}';
	}
}
