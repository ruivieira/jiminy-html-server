package com.redhat.analytics.jiminy.htmlserver.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Rating Model class
 *
 * @author Zak Hassan
 */
@Entity
@Table(name = "ratings")
public class Ratings implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Integer userid;
    private Integer product;
    private double rating;
    private Integer timestamp;


    public Ratings(Integer userid, Integer product, double rating) {
        this.userid = userid;
        this.product = product;
        this.rating = rating;
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

    public Integer getTimestamp() {    return timestamp; }

    public void setTimestamp(Integer timestamp) {   this.timestamp = timestamp; }


    @Override
    public String toString() {
        return "Ratings{" +
                "id='" + id + '\'' +
                ", userid=" + userid +
                ", product=" + product +
                ", rating=" + rating +
                '}';
    }

    public void update(RatingsDAO r){

        id=r.getId();
        userid=r.getUserid();
        product=r.getProduct();
        rating=r.getRating();
    }
}
