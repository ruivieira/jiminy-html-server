package com.redhat.analytics.jiminy.htmlserver.model;

import java.util.List;

public class UserDAO {

    private String status;
    private List<ColumnHeader> columns;
    private List<UserDataSet> dataSet;

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

    public List<UserDataSet> getDataSet() {
        return dataSet;
    }

    public void setDataSet(List<UserDataSet> dataSet) {
        this.dataSet = dataSet;
    }

    public UserDAO(String status, List<ColumnHeader> columns, List<UserDataSet> dataSet) {
        this.status = status;
        this.columns = columns;
        this.dataSet = dataSet;
    }
}
