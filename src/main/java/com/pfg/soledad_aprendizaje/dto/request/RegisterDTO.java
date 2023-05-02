package com.pfg.soledad_aprendizaje.dto.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
	private String name;
	private String surname;
	private String email;
	private int age;
	private String password;
	private String confirmPassword;
	private String gender;
	private List<Long> lstHobbieId;
	private List<Long> lstTimeRangeId;
	private MultipartFile photo;

}
