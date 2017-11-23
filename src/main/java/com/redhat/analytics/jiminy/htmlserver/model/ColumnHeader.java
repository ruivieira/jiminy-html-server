package com.redhat.analytics.jiminy.htmlserver.model;

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

