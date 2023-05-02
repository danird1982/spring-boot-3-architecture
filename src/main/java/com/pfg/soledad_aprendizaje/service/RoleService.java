package com.pfg.soledad_aprendizaje.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfg.soledad_aprendizaje.constant.MessageConstant;
import com.pfg.soledad_aprendizaje.dao.RoleRepository;
import com.pfg.soledad_aprendizaje.model.security.Role;
import com.pfg.soledad_aprendizaje.service.exception.RoleException;

@Service
public class RoleService  {

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

	@Autowired
	private MessageLocalService messageLocalService;

	@Autowired
	private RoleRepository roleRepository;

	public Role findByName(String name) throws RoleException {
		Role role = null;
		try {
			role = roleRepository.findByRoleName(name);
		} catch (Exception e) {
			log.error(messageLocalService.getMessage(MessageConstant.ERROR_FIND_ROLE, name));
			throw new RoleException(e);
		}

		return role;
	}

	public Role create(String name) throws RoleException {
		Role role = new Role(name);
		try {
			roleRepository.save(role);
		} catch (Exception e) {
			log.error(messageLocalService.getMessage(MessageConstant.ERROR_SAVE_ROLE));
			throw new RoleException(e);
		}

		return role;
	}

}
