package com.fithub.trainer.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.fithub.trainer.entity.TrainerEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class TrainerCompletoDTO {

	private Long id;
	private String nombre;
	private String apellidos;
	private String email;
	private int tfno;
	private String bio;
	private String foto;
	private LocalDate fechacreacion;
	private Map<String, String> redesSociales;
	private List<Long> clientesIds;
	
	public static TrainerCompletoDTO parse(TrainerEntity t) {
		TrainerCompletoDTO tN = new TrainerCompletoDTO();
		
		tN.setId(t.getId());
		tN.setNombre(t.getNombre());
		tN.setApellidos(t.getApellidos());
		tN.setEmail(t.getEmail());
		tN.setTfno(t.getTfno());
		tN.setBio(t.getBio());
		tN.setFoto(t.getFoto());
		tN.setFechacreacion(t.getFechacreacion());
		tN.setRedesSociales(t.getRedesSociales());
		tN.setClientesIds(t.getClientesIds());
		
		return tN;
	}
}
