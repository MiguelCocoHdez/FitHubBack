package com.fithub.client.entity;

import java.time.LocalDate;

import com.fithub.client.dto.ClientDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "clientes")
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String email;
	
	@Column
	private int tfno;
	
	@Column(columnDefinition = "TEXT")
	private String bio;
	
	@Column
	private String foto;
	
	@Column
	private LocalDate fechacreacion;
	
	@Column
	private String genero;
	
	@Column
	private Long trainerid;
	
	public static ClientEntity parse(ClientDTO dto) {
		ClientEntity client = new ClientEntity();

	    client.setNombre(dto.getNombre());
	    client.setApellidos(dto.getApellidos());
	    client.setTfno(dto.getTfno());
	    client.setBio(dto.getBio());
	    client.setGenero(dto.getGenero());


	    return client;
	}
}
