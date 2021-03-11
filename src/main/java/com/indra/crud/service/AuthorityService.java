package com.indra.crud.service;

import com.indra.crud.model.Authority;

public interface AuthorityService {
	String insertAuthority(Authority authority);
	Authority searchAuthority(Authority authority);
	Boolean updateAuthority(Authority authority);
}
