package com.main.ims.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.ims.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long>  {

}
