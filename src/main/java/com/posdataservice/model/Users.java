package com.posdataservice.model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.AllArgsConstructor;


@Document(collection = "users")
@AllArgsConstructor
public class Users implements UserDetails{
	
	@Id
	private String id;

	private String username;

	private String email;

	private String password;

	private Set<Role> roles = new HashSet<>();

	private Collection<? extends GrantedAuthority> authorities;

	@PersistenceCreator
	public Users(String id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Users(String id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public Users(String username2, String password2, Set<GrantedAuthority> grantedAuthorities) {
		this.username = username2;
		this.password = password2;
		this.authorities = grantedAuthorities;
	}

	public Users(String username2, String email2, String encode) {
		// TODO Auto-generated constructor stub
		this.username = username2;
		this.email = email2;
		this.password = encode;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Users user = (Users) o;
		return Objects.equals(id, user.id);
	}

	public void setRoles(Set<Role> roles2) {
		// TODO Auto-generated method stub
		this.roles = roles2;

	}

	public Set<Role> getRole() {
		return this.roles;
	}
 
}