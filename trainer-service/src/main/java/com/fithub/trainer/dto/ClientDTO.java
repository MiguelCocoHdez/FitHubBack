package com.fithub.trainer.dto;

import java.time.LocalDate;

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
public class ClientDTO {

	private Long id;
	private String nombre;
	private String apellidos;
	private String email;
	private int tfno;
	private String bio;
	private String foto;
	private LocalDate fechacreacion;
	private String genero;
}
