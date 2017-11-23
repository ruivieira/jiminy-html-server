package com.redhat.analytics.jiminy.htmlserver.model;

import java.util.List;

public class ReportDAO {

    private String status;
    private List<ColumnHeader> columns;
    private List<MovieDataSet> dataSet;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ColumnHeader> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnHeader> columns) {
        this.columns = columns;
    }

    public List<MovieDataSet> getDataSet() {
        return dataSet;
    }

    public void setDataSet(List<MovieDataSet> dataSet) {
        this.dataSet = dataSet;
    }

    public ReportDAO(String status, List<ColumnHeader> columns, List<MovieDataSet> dataSet) {
        this.status = status;
        this.columns = columns;
        this.dataSet = dataSet;
    }
}
