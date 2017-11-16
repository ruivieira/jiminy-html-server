package com.redhat.analytics.jiminy.htmlserver.model;

import javax.validation.constraints.NotNull;

/**
 * RatingDAO
 */
public class RatingsDAO {

    private String id;
    @NotNull
    private int userid;
    @NotNull
    private int product;
    @NotNull
    private double rating;

    public RatingsDAO(Ratings r){
        id=r.getId();
        userid=r.getUserid();
        product=r.getProduct();
        rating=r.getRating();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
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
