package com.fithub.auth.serviceImpl;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fithub.auth.dto.AuthDTO;
import com.fithub.auth.dto.LoginDTO;
import com.fithub.auth.dto.RegistroDTO;
import com.fithub.auth.entity.AuthEntity;
import com.fithub.auth.entity.Role;
import com.fithub.auth.exception.AuthException;
import com.fithub.auth.jwt.JwtUtil;
import com.fithub.auth.repository.AuthRepository;
import com.fithub.auth.response.LoginResponse;
import com.fithub.auth.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	private AuthRepository ar;
    private JwtUtil ju;
    private PasswordEncoder pe;

    public AuthServiceImpl(AuthRepository ar, JwtUtil ju, PasswordEncoder pe) {
        this.ar = ar;
        this.ju = ju;
        this.pe = pe;
    }

	@Override
	public String registro(RegistroDTO reg) {
		if (ar.existsByEmail(reg.getEmail())) {
			throw new AuthException("El email ya está en uso.", 422);
		}

		if (ar.existsByNombreusuario(reg.getNombreusuario())) {
			throw new AuthException("El nombre de usuario ya está en uso.", 423);
		}

		AuthEntity nuevoUsuario = AuthEntity.parse(reg, pe.encode(reg.getContraseña()));

		ar.save(nuevoUsuario);

		return ju.generarToken(nuevoUsuario.getEmail());
	}

	@Override
	public LoginResponse login(LoginDTO log) {
		AuthEntity usuario = ar.findByEmail(log.getEmail());
		
		if(usuario == null) {
			throw new AuthException("El email proporcionado no existe", 420);
		}

		if(!pe.matches(log.getContraseña(), usuario.getContraseña())) {
			throw new AuthException("Contraseña incorrecta", 421);
		}
		
		String token = ju.generarToken(log.getEmail());
		Role rol = usuario.getRol();

		return LoginResponse.builder()
				.token(token)
				.rol(rol)
				.build();
	}

	@Override
	public AuthDTO findByEmail(String email) {
		return AuthDTO.parse(ar.findByEmail(email));
	}

	

}
