package com.main.ims.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.ims.entity.User;
import com.main.ims.entity.UserRole;
import com.main.ims.helper.UserFoundException;
import com.main.ims.repo.RoleRepository;
import com.main.ims.repo.UserRepository;
import com.main.ims.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByfullName(user.getFullName());
		if (local != null) {
			System.out.println("User is already there !!");
			throw new UserFoundException();
		} else {
			// user create
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);

		}

		return local;
	}

	// getting user by fullName
	@Override
	public User getUser(String fullName) {
		return this.userRepository.findByfullName(fullName);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}

	@Override
	public User updateUser(User us) {
		User usr=userRepository.findById(us.getId()).orElse(null);
		usr.setFullName(us.getFullName());
		return this.userRepository.save(usr);
	}

}


