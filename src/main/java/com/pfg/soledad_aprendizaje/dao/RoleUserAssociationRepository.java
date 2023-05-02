package com.pfg.soledad_aprendizaje.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfg.soledad_aprendizaje.model.security.RoleUserAssociation;

@Repository
public interface RoleUserAssociationRepository extends CrudRepository<RoleUserAssociation, Long> {

}