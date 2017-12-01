package com.redhat.analytics.jiminy.htmlserver.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * RatingDAO
 */
public class RatingsDAO {
    private long id;
    @NotNull  
    private Integer userid;
    @NotNull
    private Integer product;
    @NotNull
    private double rating;
    private Integer timestamp;
    public RatingsDAO(){}

    public RatingsDAO(Ratings r){
        id=r.getId();
        userid=r.getUserid();
        product=r.getProduct();
        rating=r.getRating();
        timestamp=r.getTimestamp();
    }

    public RatingsDAO(long id, Integer userid, Integer product, double rating, Integer timestamp) {
		super();
		this.id = id;
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

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
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

	@Override
    public String toString() {
        return "RatingsDAO{" +
                "id='" + id + '\'' +
                ", userid=" + userid +
                ", product=" + product +
                ", rating=" + rating +
                '}';
    }
}
