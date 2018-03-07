package io.radanalytics.jiminy.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private String genres;

    public Product() {

    }

    public Product(String description, String genres) {

        this.description = description;
        this.genres = genres;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Product [" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", genres='" + genres + '\'' +
                ']';
    }
}
