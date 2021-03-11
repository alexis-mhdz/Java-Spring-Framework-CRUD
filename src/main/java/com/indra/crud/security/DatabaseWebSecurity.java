package com.indra.crud.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	//String query="SELECT USERNAME,PASSWORD, ENABLED FROM USERS WHERE USERNAME=?";
	String query = "SELECT NOMBREUSUARIO, CLAVE, ACTIVO FROM USUARIOS WHERE NOMBREUSUARIO=?";
	String queryAyth = "SELECT NOMBREUSUARIO, ROL FROM ROLES WHERE NOMBREUSUARIO=?";
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query).authoritiesByUsernameQuery(queryAyth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login-error")
			.and()
				.logout()
				.logoutSuccessUrl("/")
			.and()
				.authorizeRequests()
					// Recursos estaticos, sin autorización
					.antMatchers("static/**", "images/**").permitAll()
					// Vistas publicas, sin autorización
					.antMatchers("/login").permitAll()
					.antMatchers("/register").permitAll()
					.antMatchers("/register/save").permitAll()
					.antMatchers("/api/trabajos/",
							"/api/trabajos/**", 
							"/api/trabajos/guardar").permitAll()
					// Que requieran autorización
					// Permisos de las vistas empleados.
					.antMatchers("/empleados/crear",
							"/empleados/store",
							"/empleados/editar/**",
							"/empleados/update",
							"/empleados/delete").hasAnyAuthority("admin")
					.antMatchers("/empleados/",
							"/empleados/**").hasAnyAuthority("admin","user")
					.antMatchers("/usuarios/editar/**",
							"/usuarios/update").hasAnyAuthority("admin")
					.antMatchers("/usuarios/", 
							"usarios/**").hasAnyAuthority("admin", "user")
					.anyRequest().authenticated()
			// Login sin autorización
			.and()
				.formLogin().permitAll();
	}
}