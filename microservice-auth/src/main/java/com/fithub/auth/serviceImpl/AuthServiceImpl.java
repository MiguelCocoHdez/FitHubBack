package com.fithub.auth.serviceImpl;


import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fithub.auth.dto.AuthDTO;
import com.fithub.auth.dto.LoginDTO;
import com.fithub.auth.dto.RegistroDTO;
import com.fithub.auth.entity.AuthEntity;
import com.fithub.auth.jwt.JwtUtil;
import com.fithub.auth.repository.AuthRepository;
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
			throw new RuntimeException("El email ya está en uso.");
		}

		if (ar.existsByNombreusuario(reg.getNombreusuario())) {
			throw new RuntimeException("El nombre de usuario ya está en uso.");
		}

		AuthEntity nuevoUsuario = AuthEntity.parse(reg, pe.encode(reg.getContraseña()));

		ar.save(nuevoUsuario);

		return ju.generarToken(nuevoUsuario.getEmail());
	}

	@Override
	public String login(LoginDTO log) {
		AuthEntity usuario = ar.findByEmail(log.getEmail());

		if (usuario == null || !pe.matches(log.getContraseña(), usuario.getContraseña())) {
			throw new BadCredentialsException("Credenciales inválidas.");
		}

		return ju.generarToken(log.getEmail());
	}

	@Override
	public AuthDTO findByEmail(String email) {
		return AuthDTO.parse(ar.findByEmail(email));
	}

	

}
