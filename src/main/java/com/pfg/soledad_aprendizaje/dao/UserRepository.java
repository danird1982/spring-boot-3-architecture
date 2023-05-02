package com.pfg.soledad_aprendizaje.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfg.soledad_aprendizaje.model.security.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public User findByNick(String nick);

	public User findByEmail(String email);

}