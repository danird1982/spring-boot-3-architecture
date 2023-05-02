package com.pfg.soledad_aprendizaje.model.security;

import java.io.Serializable;

public class RoleUserAssociationId implements Serializable {

	private static final long serialVersionUID = -426631449303803949L;

	private Long user_id;
	private Long role_id;
	
	
	public RoleUserAssociationId() {
	}

	public RoleUserAssociationId(Long user_id, Long role_id) {
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

}
