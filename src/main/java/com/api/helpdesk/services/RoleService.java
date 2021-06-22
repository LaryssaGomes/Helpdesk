package com.api.helpdesk.services;

import java.util.List;

import com.api.helpdesk.models.Role;

public interface RoleService {

	public List<Role> findAll();
	public Role create(Role role);
	public Boolean delete(Long id);
	
}
