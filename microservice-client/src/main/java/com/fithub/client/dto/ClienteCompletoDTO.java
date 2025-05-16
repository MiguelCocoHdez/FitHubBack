package com.fithub.client.dto;

import java.time.LocalDate;

import com.fithub.client.entity.ClientEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class ClienteCompletoDTO {

	private Long id;
	private String nombre;
	private String apellidos;
	private String email;
	private int tfno;
	private String bio;
	private String foto;
	private LocalDate fechacreacion;
	private String genero;
	
	public static ClienteCompletoDTO parse(ClientEntity c) {
		ClienteCompletoDTO dto = new ClienteCompletoDTO();
		
		dto.setId(c.getId());
		dto.setNombre(c.getNombre());
	    dto.setApellidos(c.getApellidos());
	    dto.setEmail(c.getEmail());
	    dto.setTfno(c.getTfno());
	    dto.setBio(c.getBio());
	    dto.setFoto(c.getFoto());
	    dto.setFechacreacion(c.getFechacreacion());
	    dto.setGenero(c.getGenero());
	    
	    return dto;
	}
}
