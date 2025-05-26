package com.fithub.trainer.response;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.fithub.trainer.dto.ClientDTO;
import com.fithub.trainer.entity.Plan;

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
public class VerTrainerIdResponse {

	private Long id;
	private String nombre;
	private String apellidos;
	private String email;
	private int tfno;
	private String bio;
	private String foto;
	private LocalDate fechacreacion;
	private Plan plan;
	private Map<String, String> redesSociales;
	private List<ClientDTO> clientes;
}
