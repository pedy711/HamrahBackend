package com.pco.hamrah.service;

import java.util.ArrayList;

import com.pco.hamrah.common.model.User;

public interface UserService {
	public ArrayList<User> findAllUsers();
	
	public User saveUser(User user);
	
	public boolean existsByEmail(String email);
	
	long count();
	
	public void saveAll(ArrayList<User> users);
	
	public void flush();
	
	public ArrayList<User> findBatchAsc(Integer startRow, Integer limitSize); 

}
