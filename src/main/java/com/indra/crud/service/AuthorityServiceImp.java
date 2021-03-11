package com.indra.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.crud.model.Authority;
import com.indra.crud.repository.AuthorityRepository;

@Service
public class AuthorityServiceImp implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public String insertAuthority(Authority authority) {
		try {
			authorityRepository.save(authority);
			return "Rol agregado correctamente";
		} catch (Exception ex) {
			return "Error al agregar el Rol";
		}
	}

	@Override
	public Authority searchAuthority(Authority authority) {
		Optional<Authority> objetoRegreso = authorityRepository.findById(authority.getAuthority()); 
		
		if(objetoRegreso.isPresent()) {
			authority = objetoRegreso.get();
		}
		
		return authority;
	}

	@Override
	public Boolean updateAuthority(Authority authority) {
		try {
			authorityRepository.save(authority);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
