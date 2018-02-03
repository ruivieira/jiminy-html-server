package io.radanalytics.jiminy.model;

/**
 * 
 * ColumnHeader<br>
 * Datatable requires 2 fields columns and dataSet to exist in order to render the datatable.
 * You can create multiple instances of this class in a list and push to the UI.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 *
 */
public class ColumnHeader {

    private String data;
    private String title;

    public ColumnHeader(String data, String title) {
        this.data = data;
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ColumnHeader{" +
                "data='" + data + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

