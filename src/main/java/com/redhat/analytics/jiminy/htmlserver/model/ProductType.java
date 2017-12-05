package com.redhat.analytics.jiminy.htmlserver.model;

/**
 * ProductType<br>
 * 
 * This class is enclosed in RankType and is used in the second call to the predictor. See RankType javadocs for
 * more details.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
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
