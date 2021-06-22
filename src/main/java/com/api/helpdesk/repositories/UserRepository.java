package com.api.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.helpdesk.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
