package com.fithub.notification.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class RequestConectarTrainer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long clientId;
	private Long trainerId;
	private String mensaje;
}