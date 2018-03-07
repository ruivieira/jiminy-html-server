package io.radanalytics.jiminy.model;

/**
 * ProductType<br>
 * 
 * This class is enclosed by the RankType and is used in the second call to the predictor. See RankType javadocs for
 * more details.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
public class ProductType {
	
	long id;
    String description;
	double rating;

    public static double filterRating(double rating) {
        if (rating > 5.0) {
            return 5.0;
        } else if (rating < 0.0) {
            return 0.0;
        }
        return rating;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = filterRating(rating);
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType(long id, String description, double rating) {
		super();
		this.id = id;
		this.rating = filterRating(rating);
		this.description = description;
	}

	public ProductType() {
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", rating=" + rating + "]";
	}

}
