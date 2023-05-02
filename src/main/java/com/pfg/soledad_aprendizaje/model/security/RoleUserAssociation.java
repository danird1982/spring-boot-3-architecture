package com.pfg.soledad_aprendizaje.model.security;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "roleUserAssociation")
public class RoleUserAssociation implements Serializable {
	private static final long serialVersionUID = 7350135545320698807L;

	@Id
	@EmbeddedId
	private RoleUserAssociationId id;

	@ManyToOne
	@JoinColumn(name = "user_id", updatable = false, insertable = false, referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "role_id", updatable = false, insertable = false, referencedColumnName = "id")
	private Role role;

	public RoleUserAssociation() {
	}

	public RoleUserAssociation(User user, Role role) {
		this.user = user;
		this.role = role;
		id = new RoleUserAssociationId(user.getId(), role.getId());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleUserAssociationId getId() {
		return id;
	}

	public void setId(RoleUserAssociationId id) {
		this.id = id;
	}

}
