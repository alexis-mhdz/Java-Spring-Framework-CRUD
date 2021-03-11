package com.indra.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class Authority {
	@Id
	@Column(name="NOMBREUSUARIO")
	private String username;
	@Column(name="ROL")
	private String authority;
	
	@OneToOne
	@JoinColumn(name="NOMBREUSUARIO")
	private User user;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "Authority [username=" + username + ", authority=" + authority + "]";
	}
}
