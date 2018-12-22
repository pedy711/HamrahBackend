package com.pco.hamrah.communication;

import java.io.Serializable;

public class DataSourceResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3681439302906979714L;
	private DSResponse response;

	public DataSourceResponse(DSResponse response) {
		this.response = response;
	}

	public DSResponse getResponse() {
		return response;
	}

	public void setResponse(DSResponse response) {
		this.response = response;
	}
}