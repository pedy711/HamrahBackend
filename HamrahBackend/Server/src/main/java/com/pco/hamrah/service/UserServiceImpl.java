package com.pco.hamrah.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pco.hamrah.common.model.User;
import com.pco.hamrah.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository repo;
	
	@Autowired
	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public ArrayList<User> findAllUsers() {
		return (ArrayList<User>) repo.findAll();
	}

	@Override
	public User saveUser(User user) {
		return repo.save(user);
	}

	@Override
	public boolean existsByEmail(String email) {
		return repo.existsByEmail(email);
	}
	
	@Override
	public long count() {
		return repo.count();
	}
	
	@Override
	public void saveAll(ArrayList<User> users) {
		repo.saveAll(users);
	}

	@Override
	public void flush() {
		repo.flush();
	}
	
	@Override
	public ArrayList<User> findBatchAsc(Integer startRow, Integer limitSize) {
		return repo.findBatchAsc(startRow, limitSize);
	}

}
