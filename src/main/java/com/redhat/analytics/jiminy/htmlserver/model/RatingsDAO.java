package com.redhat.analytics.jiminy.htmlserver.model;

import javax.validation.constraints.NotNull;

/**
 * RatingDAO
 */
public class RatingsDAO {

    private Integer id;
    @NotNull
    private Integer userid;
    @NotNull
    private Integer product;
    @NotNull
    private double rating;

    public RatingsDAO(Ratings r){
        id=r.getId();
        userid=r.getUserid();
        product=r.getProduct();
        rating=r.getRating();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserid() {
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
