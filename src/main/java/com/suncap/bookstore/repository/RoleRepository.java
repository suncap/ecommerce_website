package com.suncap.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.suncap.bookstore.security.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

}
