package com.pfg.soledad_aprendizaje.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pfg.soledad_aprendizaje.constant.MessageConstant;
import com.pfg.soledad_aprendizaje.dao.RoleUserAssociationRepository;
import com.pfg.soledad_aprendizaje.dao.UserRepository;
import com.pfg.soledad_aprendizaje.dto.request.RegisterDTO;
import com.pfg.soledad_aprendizaje.model.security.Role;
import com.pfg.soledad_aprendizaje.model.security.RoleUserAssociation;
import com.pfg.soledad_aprendizaje.model.security.User;
import com.pfg.soledad_aprendizaje.service.exception.UserException;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private MessageLocalService messageLocalService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleUserAssociationRepository roleUserAssociationRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public User findByNick(String nick) throws UserException {
		User user = null;
		try {
			user = userRepository.findByNick(nick);
		} catch (Exception e) {
			throw new UserException(e);
		}

		return user;
	}

	public User findByEmail(String email) throws UserException {
		User user = null;
		try {
			user = userRepository.findByEmail(email);
		} catch (Exception e) {
			String errorMessage = messageLocalService.getMessage(MessageConstant.ERROR_FIND_USER, user.getNick());
			log.error(errorMessage);
			throw new UserException(e);
		}

		return user;
	}

	public void save(User user) throws UserException {
		try {
			userRepository.save(user);
		} catch (Exception e) {
			String errorMessage = messageLocalService.getMessage(MessageConstant.ERROR_SAVE_USER, user.getName());
			log.error(errorMessage);
			throw new UserException(e);
		}
	}

	public User create(RegisterDTO registerDTO, Role... lstRole) throws UserException {
		User user = new User(registerDTO.getEmail());
		user.setName(registerDTO.getName());
		user.setSurname(registerDTO.getSurname());
		user.setEmail(registerDTO.getEmail());
		user.setPassword(encoder.encode(registerDTO.getPassword()));
		user.setGender(registerDTO.getGender());
		user.setAge(registerDTO.getAge());
		user.setEnabled(true);

		try {
			if (registerDTO.getPhoto() != null) {
				user.setPhoto(registerDTO.getPhoto().getBytes());
			}

			userRepository.save(user);
			for (Role role : lstRole) {
				RoleUserAssociation roleUserAssociation = new RoleUserAssociation(user, role);
				roleUserAssociationRepository.save(roleUserAssociation);
			}
		} catch (Exception e) {
			String errorMessage = messageLocalService.getMessage(MessageConstant.ERROR_SAVE_USER,
					registerDTO.getName());
			log.error(errorMessage);
			throw new UserException(e);
		}

		return user;
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public void delete(User user) throws UserException {
		try {
			userRepository.delete(user);
		} catch (Exception e) {
			String errorMessage = messageLocalService.getMessage(MessageConstant.ERROR_DELETE_USER, user.getName());
			log.error(errorMessage);
			throw new UserException(e);
		}
	}

	public Optional<User> findById(long userId) {
		return userRepository.findById(userId);
	}

}
