package com.pfg.soledad_aprendizaje.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfg.soledad_aprendizaje.model.security.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	public List<Role> findAll(Specification<Role> specification);
	
	public Role findByRoleName(String roleName);

}