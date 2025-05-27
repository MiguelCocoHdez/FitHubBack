package com.fithub.auth.service;

import com.fithub.auth.dto.AuthDTO;
import com.fithub.auth.dto.LoginDTO;
import com.fithub.auth.dto.RegistroDTO;
import com.fithub.auth.response.LoginResponse;

public interface AuthService {

	String registro(RegistroDTO reg);
	
	LoginResponse login(LoginDTO log);
	
	AuthDTO findByEmail(String email);
}
