package com.pco.hamrah.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pco.hamrah.common.model.User;
import com.pco.hamrah.communication.DSRequest;
import com.pco.hamrah.communication.DSResponse;
import com.pco.hamrah.communication.DataSourceResponse;
import com.pco.hamrah.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseEntity<User> registerUser(@RequestBody String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<User> typeReference = new TypeReference<User>(){};
		User user = mapper.readValue(json, typeReference);
		
		System.out.println(user.getFirstName());
		if (user != null && !user.getEmail().isEmpty() && !userService.existsByEmail(user.getEmail())) {
			return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<User>(new User(), HttpStatus.ALREADY_REPORTED);
		}
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<String> registerUserGet() {
//		return new ResponseEntity<String>("GET: User registered successfully!", HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public @ResponseBody DataSourceResponse getUsers(@RequestBody String json) throws ServletException, IOException  {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<DSRequest> typeReference = new TypeReference<DSRequest>(){};
		DSRequest dsRequest = mapper.readValue(json, typeReference);
		
		DSResponse response = new DSResponse();

		int limitSize = dsRequest.getEndRow() - dsRequest.getStartRow();
		
		List<User> users = null;

		users = userService.findBatchAsc(dsRequest.getStartRow(), limitSize);
		
		response.setStartRow(dsRequest.getStartRow());
		response.setEndRow(dsRequest.getStartRow() + users.size());
		response.setData(users.toArray());
		response.setTotalRows((int) userService.count());
		
		if (response.getEndRow() > response.getTotalRows()) {
			response.setEndRow(response.getTotalRows());
		}
		
		DataSourceResponse dataSourceResponse = new DataSourceResponse(response);

		return dataSourceResponse;
	}

}
