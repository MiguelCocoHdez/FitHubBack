package com.fithub.trainer.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

public class TrainerDTO {

	private String nombre;
	private String apellidos;
	private int tfno;
	private String bio;
	private Map<String, String> redesSociales;
}
