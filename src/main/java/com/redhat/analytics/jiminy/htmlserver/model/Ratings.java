package com.redhat.analytics.jiminy.htmlserver.model;

//import org.springframework.data.annotation.Id;

/**
 * Rating Model class
 *
 * @author Zak Hassan
 */
public class Ratings {

//    @Id
    private String id;
    private int userid;
    private int product;
    private double rating;


    public Ratings(int userid, int product, double rating) {
        this.userid = userid;
        this.product = product;
        this.rating = rating;
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
