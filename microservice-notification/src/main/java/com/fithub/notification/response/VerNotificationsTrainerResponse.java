package com.fithub.notification.response;

import com.fithub.notification.dto.ClienteCompletoDTO;

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
public class VerNotificationsTrainerResponse {

	private Long id;
	private String mensaje;
	private ClienteCompletoDTO cliente;
}
