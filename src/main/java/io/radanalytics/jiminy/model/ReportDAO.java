package io.radanalytics.jiminy.model;

import java.util.List;

/**
 * ReportDAO<br>
 * 
 * Encloses the full report on what products would be recommended for a given userid.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
public class ReportDAO {

    private String status;
    private List<ColumnHeader> columns;
    private List<?> dataSet;

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

    public List<?> getDataSet() {
        return dataSet;
    }

    public void setDataSet(List<?> dataSet) {
        this.dataSet = dataSet;
    }

    public ReportDAO(String status, List<ColumnHeader> columns, List<?> dataSet) {
        this.status = status;
        this.columns = columns;
        this.dataSet = dataSet;
    }

	@Override
	public String toString() {
		return "ReportDAO [status=" + status + ", columns=" + columns + ", dataSet=" + dataSet + "]";
	}
    
}
