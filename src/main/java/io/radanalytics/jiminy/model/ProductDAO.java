package io.radanalytics.jiminy.model;

/**
 * ProductDAO<br>
 *
 * This is a DAO object that is used between the controller and the repository for data storage.
 * @author Rui Vieira <rcardoso@redhat.com>
 */
public class ProductDAO {

    private long id;
    private String descriptions;
    private String genres;

    public ProductDAO() {

    }

    public ProductDAO(Product p){
        id=p.getId();
        descriptions = p.getDescription();
        genres=p.getGenres();
    }

    public ProductDAO(long id, String descriptions, String genres) {
        this.id = id;
        this.descriptions = descriptions;
        this.genres = genres;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "ProductDAO{" +
                "id=" + id +
                ", descriptions='" + descriptions + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}
