package com.pfg.soledad_aprendizaje.model.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 198355926937292762L;

	public static final String ADMIN_ROLE = "ADMIN";
	public static final String ROLE1 = "ROLE1";


	public static final String LST_USER = "lstUser";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Nombre del rol
	 */
	private String roleName;

	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<RoleUserAssociation> lstRoleUserAssociation;

	public Role() {
		roleName = "";
		lstRoleUserAssociation = new ArrayList<RoleUserAssociation>();
	}

	public Role(String roleName) {
		if (roleName == null) {
			throw new IllegalArgumentException("El nombre del rol no puede ser nulo");
		}

		this.roleName = roleName;
		lstRoleUserAssociation = new ArrayList<RoleUserAssociation>();
	}

	public List<RoleUserAssociation> getLstRoleUserAssociation() {
		return lstRoleUserAssociation;
	}

	public void setLstRoleUserAssociation(List<RoleUserAssociation> lstRoleUserAssociation) {
		this.lstRoleUserAssociation = lstRoleUserAssociation;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		boolean equal = false;

		if (obj instanceof Role) {
			Role role = (Role) obj;

			if (role.roleName.equals(roleName)) {
				equal = true;
			}
		}

		return equal;
	}

	@Override
	public String toString() {
		return roleName;
	}

}
