package com.pfg.soledad_aprendizaje.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.pfg.soledad_aprendizaje.model.security.Role;
import com.pfg.soledad_aprendizaje.model.security.RoleUserAssociation;
import com.pfg.soledad_aprendizaje.model.security.User;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User user;

	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<RoleUserAssociation> lstRoleUserAssociation = user.getLstRoleUserAssociation();
		List<Role> lstRole = new ArrayList<Role>();
		for(RoleUserAssociation roleUserAssociation: lstRoleUserAssociation){
			lstRole.add(roleUserAssociation.getRole());
		}
		String roles = StringUtils.collectionToCommaDelimitedString(lstRole);
		
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

	@Override
	public String getUsername() {
		return user.getNick();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String toString() {
		return "\nclass CustomUserDetails [user=" + user + "]";
	}

}
