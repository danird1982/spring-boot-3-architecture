package com.pfg.soledad_aprendizaje.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.pfg.soledad_aprendizaje.dto.request.RegisterDTO;
import com.pfg.soledad_aprendizaje.model.security.Role;
import com.pfg.soledad_aprendizaje.model.security.User;
import com.pfg.soledad_aprendizaje.service.RoleService;
import com.pfg.soledad_aprendizaje.service.UserService;
import com.pfg.soledad_aprendizaje.service.exception.RoleException;
import com.pfg.soledad_aprendizaje.service.exception.UserException;

import jakarta.annotation.PostConstruct;

@Configuration
public class CreateUserAndRoles {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	public CreateUserAndRoles() {
	}

	@PostConstruct
	public void createRolesAndUser() throws UserException, RoleException {

		// Creamos los roles
		Role adminRole = roleService.findByName(Role.ADMIN_ROLE);
		if (adminRole == null) {
			adminRole = roleService.create(Role.ADMIN_ROLE);
		}

		Role oldRole = roleService.findByName(Role.ROLE1);
		if (oldRole == null) {
			oldRole = roleService.create(Role.ROLE1);
		}

		// Creamos los usuarios
		RegisterDTO registerDTO = new RegisterDTO();
		User user = userService.findByNick(User.ADMIN_USER);
		if (user == null) {
			registerDTO.setEmail(User.ADMIN_USER);
			registerDTO.setName(User.ADMIN_NAME);
			registerDTO.setSurname(User.ADMIN_SURNAME);
			registerDTO.setPassword(User.ADMIN_PASSWORD);
			registerDTO.setConfirmPassword(User.ADMIN_PASSWORD);
			registerDTO.setGender(User.ADMIN_GENDER);
			registerDTO.setAge(User.ADMIN_AGE);			
			
			// Creamos el usuario Administrador
			userService.create(registerDTO, adminRole);
		}

		user = userService.findByNick(User.USER1USER);
		if (user == null) {
			registerDTO.setEmail(User.USER1USER);
			registerDTO.setName(User.USER1NAME);
			registerDTO.setSurname(User.USER1SURNAME);
			registerDTO.setPassword(User.USER1PASSWORD);
			registerDTO.setConfirmPassword(User.USER1PASSWORD);
			registerDTO.setGender(User.USER1GENDER);
			registerDTO.setAge(User.USER1AGE);		
			
			// Creamos el usuario Anciano
			userService.create(registerDTO, oldRole);
		}

	}

}
