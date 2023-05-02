package com.pfg.soledad_aprendizaje.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfg.soledad_aprendizaje.dto.request.UserDTO;
import com.pfg.soledad_aprendizaje.model.security.RoleUserAssociation;
import com.pfg.soledad_aprendizaje.model.security.User;
import com.pfg.soledad_aprendizaje.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "findall")
	public ResponseEntity<List<UserDTO>> findAll() {

		List<UserDTO> lstUserDTO = new ArrayList<>();

		List<User> lstUser = userService.findAll();
		for (User user : lstUser) {
			List<RoleUserAssociation> lstRoleUserAssociation = user.getLstRoleUserAssociation();
			List<String> lstRoles = new ArrayList<>();
			for (RoleUserAssociation roleUserAssociation : lstRoleUserAssociation) {
				lstRoles.add(roleUserAssociation.getRole().getRoleName());
			}

			UserDTO userDTO = UserDTO.builder().name(user.getNick()).roles(lstRoles).build();

			lstUserDTO.add(userDTO);
		}
		return new ResponseEntity<List<UserDTO>>(lstUserDTO, HttpStatus.OK);
	}
}
