package com.fithub.auth.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Value("${jwt.expiration}")
    private Long expiration;
	
	private SecretKey getClaveFirma() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }
	
	public String generarToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(getClaveFirma())
				.compact();		
	}
	
	
	public boolean isTokenExpirado(String token) {
        return expiracion(token).before(new Date());
    }
	
	public Date expiracion(String token) {
		return extraerClaims(token).getExpiration();
	}
	
	public Claims extraerClaims(String token) {
		SecretKey clave = getClaveFirma();
		
		return Jwts.parserBuilder().setSigningKey(clave).build().parseClaimsJws(token).getBody();
	}
	
	public String extraerEmail(String token) {
		return extraerClaims(token).getSubject();
	}
}