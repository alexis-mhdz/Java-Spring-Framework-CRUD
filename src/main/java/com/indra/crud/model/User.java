package com.indra.crud.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class User {
	@Id
	@Column(name="NOMBREUSUARIO")
	private String username;
	
	@Column(name="CLAVE")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEFONO")
	private String phone;
	
	@Column(name="ACTIVO")
	private Boolean enabled;

	@OneToOne(mappedBy="user")
	private Authority authority;
	/*
	@ManyToOne
	@JoinColumn(name="NOMBREUSUARIO", nullable = false)*/
	/*@OneToOne(mappedBy="user")
	private Authority authority;*/
	
	/*
    @OneToMany(mappedBy="user")
    private List<Authority> authorityList;
    */
	
	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Authority> authorityList;	
	*/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", enabled=" + enabled + "]";
	}
}
