package com.pco.hamrah.communication;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DSResponse implements Serializable {

	private static final long serialVersionUID = -4937262101507779477L;

	public static int STATUS_FAILURE = -1;
	public static int STATUS_LOGIN_INCORRECT = -5;
	public static int STATUS_LOGIN_REQUIRED = -7;
	public static int STATUS_LOGIN_SUCCESS = -8;
	public static int STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED = -6;
	public static int STATUS_SERVER_TIMEOUT = -100;
	public static int STATUS_SUCCESS = 0;
	public static int STATUS_TRANSPORT_ERROR = -90;
	public static int STATUS_VALIDATION_ERROR = -4;

	private int status;
	private Integer startRow;
	private Integer endRow;
	private Integer totalRows;
	private Object[] data;
	@SuppressWarnings("rawtypes")
	private Map errors;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Object[] getData() {
		return data;
	}

	public void setData(Object[] data) {
		this.data = data;
	}

	@SuppressWarnings("rawtypes")
	public Map getErrors() {
		return errors;
	}

	@SuppressWarnings("rawtypes")
	public void setErrors(Map errors) {
		this.errors = errors;
	}

	@SuppressWarnings("rawtypes")
	public DSResponse() {
		status = STATUS_SUCCESS;

		errors = new HashMap();
		startRow = 0;
		endRow = 0;
		totalRows = -2;
	}

	@SuppressWarnings("rawtypes")
	public DSResponse(int status) {
		this.status = status;

		errors = new HashMap();
		startRow = 0;
		endRow = 0;
		totalRows = -1;
	}

}