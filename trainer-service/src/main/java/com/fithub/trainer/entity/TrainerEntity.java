package com.fithub.trainer.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.fithub.trainer.dto.TrainerDTO;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
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
@Table(name = "trainers")
public class TrainerEntity {

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
	
	@Enumerated(EnumType.STRING)
	private Plan plan;
	
	@ElementCollection
    @CollectionTable(name = "redes")
    @MapKeyColumn(name = "plataforma")
    @Column(name = "url")
    private Map<String, String> redesSociales;
	
	@ElementCollection
	@Column
	private List<Long> clientesIds;
	
	public static TrainerEntity parse(TrainerDTO t) {
		TrainerEntity trainer = new TrainerEntity();

	    trainer.setNombre(t.getNombre());
	    trainer.setApellidos(t.getApellidos());
	    trainer.setTfno(t.getTfno());
	    trainer.setBio(t.getBio());
	    trainer.setRedesSociales(t.getRedesSociales());
	    trainer.setPlan(t.getPlan());
	    
	    trainer.setClientesIds(List.of());         
	    trainer.setFoto(null);                     

	    return trainer;
	}
}
