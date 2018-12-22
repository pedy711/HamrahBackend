package com.pco.hamrah.communication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class DSRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7549342325277890072L;
	private String dataSource;
	private String operationType;
	private Integer startRow;
	private Integer endRow;
	private String textMatchStyle;
	private String componentId;
	private Map<Object, Object> data;
	private String oldValues;
	private ArrayList < Object > sortBy = new ArrayList < Object > ();

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	public String getTextMatchStyle() {
		return textMatchStyle;
	}

	public void setTextMatchStyle(String textMatchStyle) {
		this.textMatchStyle = textMatchStyle;
	}

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public Map<Object, Object> getData() {
		return data;
	}

	public void setData(Map<Object, Object> data) {
		this.data = data;
	}

	public String getOldValues() {
		return oldValues;
	}

	public void setOldValues(String oldValues) {
		this.oldValues = oldValues;
	}

	public ArrayList < Object > getSortBy() {
		return sortBy;
	}

	public void setSortBy(ArrayList < Object > sortBy) {
		this.sortBy = sortBy;
	}

	/*
	 * "dataSource":"personDsId", "operationType":"fetch", "startRow":0,
	 * "endRow":75, "textMatchStyle":"substring", "componentId":"isc_ListGrid_0",
	 * "data":{ }, "oldValues":null
	 */

}
