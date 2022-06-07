package com.main.ims.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.ims.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    public User findByfullName(String fullName);

}
