package net.codejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.codejava.DAO.UserRepository;
import net.codejava.model.User;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	
	public List<User> listAll() {
		return repo.findAll();
	}
	

	
	
	

		
	
	
}