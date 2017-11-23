package com.redhat.analytics.jiminy.htmlserver.model;

public class MovieDataSet {

    private String id;
    private String movie;
    private String year;

    public MovieDataSet(String id, String movie, String year) {
        this.id = id;
        this.movie = movie;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MovieDataSet{" +
                "id='" + id + '\'' +
                ", movie='" + movie + '\'' +
                ", year='" + year + '\'' +
                '}';
    }


}
