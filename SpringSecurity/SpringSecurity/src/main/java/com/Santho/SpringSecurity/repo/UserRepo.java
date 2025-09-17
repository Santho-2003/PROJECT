package com.Santho.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Santho.SpringSecurity.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer>
{
	Users findByUsername(String username);  
}


