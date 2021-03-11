package com.indra.crud.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.crud.model.User;

public interface UserRepository extends CrudRepository<User, String> {

	/*
	@Query(value="UPDATE USUARIOS SET ACTIVO = ?1 WHERE NOMBREUSUARIO = ?2", nativeQuery = true)
	boolean setUserEnabled(Boolean enabled, String username);
	*/

}