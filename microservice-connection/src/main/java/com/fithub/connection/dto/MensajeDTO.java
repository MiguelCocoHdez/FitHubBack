package com.fithub.connection.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class MensajeDTO {

	private Long trainerId;
	private Long clientId;
	private String contenido;
	private Long senderId;
}
