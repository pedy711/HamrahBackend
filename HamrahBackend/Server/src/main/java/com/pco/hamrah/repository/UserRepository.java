package com.pco.hamrah.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pco.hamrah.common.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);
    
    boolean existsByEmail(String email);
    
	@Query(value = "SELECT * FROM user_account ORDER BY id ASC limit (:limitSize) offset (:startRow) ",
			nativeQuery = true)
	public ArrayList<User> findBatchAsc(@Param("startRow") Integer startRow, @Param("limitSize") Integer limitSize);
}