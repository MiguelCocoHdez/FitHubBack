package com.fithub.auth.service;

import com.fithub.auth.dto.AuthDTO;
import com.fithub.auth.dto.LoginDTO;
import com.fithub.auth.dto.RegistroDTO;

public interface AuthService {

	String registro(RegistroDTO reg);
	
	String login(LoginDTO log);
	
	AuthDTO findByEmail(String email);
}
