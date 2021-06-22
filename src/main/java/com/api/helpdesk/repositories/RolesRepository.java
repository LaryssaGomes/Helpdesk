package com.api.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.helpdesk.models.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long>{

	Role findByName(String name);
}
