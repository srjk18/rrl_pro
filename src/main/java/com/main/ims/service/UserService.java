package com.main.ims.service;

import java.util.Set;

import com.main.ims.entity.User;
import com.main.ims.entity.UserRole;

public interface UserService {
	
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String fullName);

    //delete user by id
    public void deleteUser(Long userId);
    
    public User updateUser(User us);
    
    // update by user id    
//    public User update(Long userId);

    

}
