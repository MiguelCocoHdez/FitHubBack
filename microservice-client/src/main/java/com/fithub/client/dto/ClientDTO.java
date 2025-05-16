package com.fithub.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class ClientDTO {

	private String nombre;
	private String apellidos;
	private int tfno;
	private String bio;
	private String genero;
}
