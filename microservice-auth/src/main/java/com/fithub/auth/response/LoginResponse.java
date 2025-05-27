package com.fithub.auth.response;

import com.fithub.auth.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Builder
public class LoginResponse {

	private String token;
	private Role rol;
}
