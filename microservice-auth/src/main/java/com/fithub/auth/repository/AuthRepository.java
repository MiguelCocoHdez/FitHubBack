package com.fithub.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fithub.auth.entity.AuthEntity;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

	AuthEntity findByEmail(String email);
	
	AuthEntity findByNombreusuario(String nombreusuario);
	
	boolean existsByEmail(String email);
	
	boolean existsByNombreusuario(String nombreusuario);
}
