package io.radanalytics.jiminy.model;

import javax.validation.constraints.NotNull;

/**
 * RatingDAO<br>
 * 
 * This is a DAO object that is used between the controller and the repository for data storage.
 * @author Zak Hassan <zhassan@redhat.com>
 */
public class RatingsDAO {
    private long id;
    @NotNull  
    private Integer userid;
    @NotNull
    private Integer movieid;
    @NotNull
    private double rating;
    private Integer timestamp;
    private Product product;

    public RatingsDAO(){}

    public RatingsDAO(Ratings r){
        id=r.getId();
        userid=r.getUserid();
        movieid=r.getMovieId();
        rating=r.getRating();
        timestamp=r.getTimestamp();
    }

    public RatingsDAO(long id, Product product, Integer userid, Integer movieid, double rating, Integer timestamp) {
		super();
		this.id = id;
		this.userid = userid;
		this.movieid = movieid;
		this.rating = rating;
		this.timestamp = timestamp;
		this.product = product;
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

	 
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Integer getMovieid() {
		return movieid;
	}

	public void setMovieid(Integer movieid) {
		this.movieid = movieid;
	}

	@Override
	public String toString() {
		return "RatingsDAO [id=" + id + ", userid=" + userid + ", movieid=" + movieid + ", rating=" + rating
				+ ", timestamp=" + timestamp + "]";
	}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
