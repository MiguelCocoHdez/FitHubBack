package com.fithub.connection.dto;

import java.time.LocalDateTime;

import com.fithub.connection.entity.MensajesEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class MensajeRecibidoDTO {

	private Long trainerId;
	private Long clientId;
	private String contenido;
	private Long senderId;
	private LocalDateTime horaEnviada;
	
	public static MensajeRecibidoDTO parse(MensajesEntity m) {
		MensajeRecibidoDTO mN = new MensajeRecibidoDTO();
		
		mN.setTrainerId(m.getTrainerId());
		mN.setClientId(m.getClientId());
		mN.setContenido(m.getContenido());
		mN.setSenderId(m.getSenderId());
		mN.setHoraEnviada(m.getHoraEnviada());
		
		return mN;
	}
}
