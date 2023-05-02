package com.pfg.soledad_aprendizaje.dto.request;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UserDTO {

	private String name;
	private List<String> roles;

}
