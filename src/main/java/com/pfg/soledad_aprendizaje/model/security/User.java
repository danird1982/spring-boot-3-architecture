package com.pfg.soledad_aprendizaje.model.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ID = "id";
	public static final String AGE = "age";
	public static final String NAME = "name";
	public static final String NICK = "nick";
	public static final String ENABLED ="enabled";
	public static final String LST_USER_HOBBIE_ASSOCIATION = "lstUserHobbieAssociation";
	public static final String LST_USER_TIMERANGE_ASSOCIATION = "lstUserTimeRangeAssociation";

	public static final String ADMIN_USER = "admin@gmail.com";
	public static final String ADMIN_NAME = "Admin";
	public static final String ADMIN_SURNAME = "Adminsurname";
	public static final String AMDIN_EMAIL = "admin@gmail.com";
	public static final String ADMIN_PASSWORD = "admin";
	public static final String ADMIN_GENDER = "M";
	public static final int ADMIN_AGE = 45;

	public static final String USER1USER = "user1@gmail.com";
	public static final String USER1NAME = "User1";
	public static final String USER1SURNAME = "User1surname";
	public static final String USER1EMAIL = "user1@gmail.com";
	public static final String USER1PASSWORD = "user1";
	public static final String USER1GENDER = "H";
	public static final int USER1AGE = 68;


	public static final String LST_ROLES = "lstRoles";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "bigint unsigned")
	private Long id;

	private String name;

	private String password;

	private String surname;

	private String email;

	@Column(nullable = false, unique = true)
	private String nick;

	private int age;

	private String gender;
	
	@Column(columnDefinition="bit(1) default 1")
	private boolean enabled;
	
	@Lob 
	@Basic(fetch = FetchType.LAZY)
	@Column(length=100000)
	private byte[] photo;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<RoleUserAssociation> lstRoleUserAssociation;

	public User() {
		lstRoleUserAssociation = new ArrayList<>();
	}

	public User(String nick) {
		this();
		this.nick = nick;
	}

	@Override
	public boolean equals(Object obj) {
		boolean eq = false;
		if (obj instanceof User) {
			User user = (User) obj;
			if (user.nick.equals(nick)) {
				eq = true;
			}
		}

		return eq;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nick=" + nick + "]";
	}

}