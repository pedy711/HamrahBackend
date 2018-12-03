package com.pco.hamrah.gwt;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;

public class PersonDataSource extends RestDataSource {
	private static PersonDataSource instance = null;

	public static PersonDataSource getInstance() {
		if (instance == null) {
			instance = new PersonDataSource("personDsId");
		}

		return instance;
	}

	private PersonDataSource(String id) {
		setID(id);
		setClientOnly(false);

		// set up FETCH to use GET requests
		OperationBinding fetch = new OperationBinding();
		fetch.setOperationType(DSOperationType.FETCH);
		fetch.setDataProtocol(DSProtocol.POSTMESSAGE);
	/*	fetch.setDataFormat(DSDataFormat.JSON);

		DSRequest fetchProps = new DSRequest();
		fetchProps.setHttpMethod("GET");
		fetchProps.setContentType("application/json");
		fetch.setRequestProperties(fetchProps);*/

		// set up ADD to use POST requests
		OperationBinding add = new OperationBinding();
		add.setOperationType(DSOperationType.ADD);
		add.setDataProtocol(DSProtocol.POSTMESSAGE);
		// ===========================================
	/*	DSRequest addProps = new DSRequest();
		addProps.setHttpMethod("POST");
		add.setRequestProperties(addProps);*/

		// set up UPDATE to use PUT
		OperationBinding update = new OperationBinding();
		update.setOperationType(DSOperationType.UPDATE);
		update.setDataProtocol(DSProtocol.POSTMESSAGE);
		// ===========================================
/*		DSRequest updateProps = new DSRequest();
		updateProps.setHttpMethod("PUT");
		// updateProps.setContentType("application/json");
		update.setRequestProperties(updateProps);*/

		// set up REMOVE to use DELETE
		OperationBinding remove = new OperationBinding();
		remove.setOperationType(DSOperationType.REMOVE);
        remove.setDataProtocol(DSProtocol.POSTMESSAGE);  

	/*	DSRequest removeProps = new DSRequest();
		removeProps.setHttpMethod("DELETE");
		remove.setRequestProperties(removeProps);*/

		setOperationBindings(fetch, add, update, remove);
        setDataFormat(DSDataFormat.JSON);

		init();
	}

	protected void init() {
		// setJsonRecordXPath("/");
		setDataURL(GWT.getHostPageBaseURL() + "person");
		setJsonPrefix("");
		setJsonSuffix("");
		
	    DataSourceTextField id = new DataSourceTextField("id", "Id");
        id.setPrimaryKey(true);  
        id.setCanEdit(false);  
        DataSourceTextField name = new DataSourceTextField("name", "Name");
        name.setCanEdit(false);
        
        DataSourceTextField familyName = new DataSourceTextField("familyName", "Family Name");
        name.setCanEdit(false);
        
        DataSourceTextField age = new DataSourceTextField("age", "Age");
        name.setCanEdit(false);

	/*	DataSourceField idField = new DataSourceField("id", FieldType.INTEGER, "ID");
		idField.setPrimaryKey(true);
		idField.setCanEdit(false);
		DataSourceField nameField = new DataSourceField("name", FieldType.TEXT, "Name");*/

		setFields(id, name, familyName, age);
	}
	
/*	@Override
	protected Object transformRequest(DSRequest dsRequest) {
	    JavaScriptObject jso = dsRequest.getData(); 
	    String s1 = JSON.encode(jso); 
	    return s1; 
	}*/

	@Override
	protected Object transformRequest(DSRequest dsRequest) {
		dsRequest.setTimeout(50000);
		return super.transformRequest(dsRequest);
	}

	/*protected void transformResponse(DSResponse response, DSRequest request, Object data) {
		System.out.println("InvoiceDataSource: transformResponse: START");
		JavaScriptObject jso = (JavaScriptObject) data;
		String jsoText1 = JSON.encode(jso);
		System.out.println("InvoiceDataSource: transformResponse: START: jsoText1=" + jsoText1);

		String jsoText2 = JSON.encode(jso);
		System.out.println("InvoiceDataSource: transformResponse: FINISH: jsoText2=" + jsoText2);

		super.transformResponse(response, request, data);
		System.out.println("InvoiceDataSource: transformResponse: FINISH");
	}*/

}
