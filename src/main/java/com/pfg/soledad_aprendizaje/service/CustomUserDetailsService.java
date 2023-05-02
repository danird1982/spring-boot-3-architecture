package com.pfg.soledad_aprendizaje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pfg.soledad_aprendizaje.dao.UserRepository;
import com.pfg.soledad_aprendizaje.model.security.User;
import com.pfg.soledad_aprendizaje.security.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageLocalService messageLocalService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByNick(username);
		if (null == user) {
			throw new UsernameNotFoundException(messageLocalService.getMessage("unregistered.user", username));
		} 
		
		UserDetails userDetails =  new CustomUserDetails(user);
		
		return userDetails;
	}

}
