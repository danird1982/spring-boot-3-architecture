package com.pfg.soledad_aprendizaje.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfg.soledad_aprendizaje.dto.request.UserDTO;

@RestController
public class BasicAuthController {

	@GetMapping(path = "/login")
	public UserDTO basicauth(Principal principal) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) auth.getAuthorities();
		List<String> lstRoles = new ArrayList<String>();
		for (SimpleGrantedAuthority simpleGrantedAuthority : authorities) {

			String role = simpleGrantedAuthority.getAuthority();
			lstRoles.add(role);
		}
		UserDTO user = null;
		if (principal != null) {
			user = UserDTO.builder().name(principal.getName()).roles(lstRoles).build();
		}

		return user;
	}
}