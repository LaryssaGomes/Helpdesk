package com.api.helpdesk.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.helpdesk.models.Role;
import com.api.helpdesk.models.User;
import com.api.helpdesk.repositories.RolesRepository;
import com.api.helpdesk.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RolesRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder, RolesRepository roleRepository) {
		this.repository = repository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public List<User> findAll() {
		return this.repository.findAll();
	}

	@Override
	public User create(User user) {
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));// Criptografia de senha
		Role userRole = this.roleRepository.findByName("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return this.repository.save(user);
	}

	@Override
	public Boolean delete(Long id) {
		User user = findById(id);
		if (user != null) {
			this.repository.delete(user);
			return true;
		}
		return false;
	}
	
	private User findById(Long id) {
		return this.repository.getById(id);
	}

	@Override
	public Boolean update(Long id, User user) {
		User userExists = findById(id);
		if (userExists != null) {
			userExists.setId(user.getId());
			userExists.setName(user.getName());
			userExists.setLastName(user.getLastName());
			userExists.setEmail(user.getEmail());
			userExists.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
			userExists.setActive(user.getActive());
			
			this.repository.save(userExists);
			return true;
		}
		return false;
	}

	@Override
	public User show(Long id) {
		return this.repository.getById(id);
	}

}
