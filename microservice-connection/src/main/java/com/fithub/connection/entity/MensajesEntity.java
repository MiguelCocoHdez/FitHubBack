package com.fithub.connection.entity;

import java.time.LocalDateTime;

import com.fithub.connection.dto.MensajeDTO;

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

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "mensajes")
public class MensajesEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
	private Long trainerId;
	
	@Column
	private Long clientId;
	
	@Column
	private String contenido;
	
	@Column
	private Long senderId;
	
	@Column
	private LocalDateTime horaEnviada;
	
	public static MensajesEntity parse(MensajeDTO m) {
		MensajesEntity mN = new MensajesEntity();
		
		mN.setTrainerId(m.getTrainerId());
		mN.setClientId(m.getClientId());
		mN.setContenido(m.getContenido());
		mN.setSenderId(m.getSenderId());
		
		return mN;
	}
}
