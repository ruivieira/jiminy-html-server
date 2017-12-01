package com.redhat.analytics.jiminy.htmlserver.rest;

public class ProductType {
	
	String id;
	double rating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public ProductType(String id, double rating) {
		super();
		this.id = id;
		this.rating = rating;
	}

	public ProductType() {
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", rating=" + rating + "]";
	}

}
