package com.fithub.notification.dto;

import com.fithub.notification.entity.EstadoSolicitud;
import com.fithub.notification.entity.NotificationEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class NotificationDTO {

	private Long id;
	private Long clientId;
	private Long trainerId;
	private String mensaje;
	private EstadoSolicitud estado;
	
	public static NotificationDTO parse(NotificationEntity n) {
		NotificationDTO nD = new NotificationDTO();
		
		nD.setId(n.getId());
		nD.setClientId(n.getClientId());
		nD.setTrainerId(n.getTrainerId());
		nD.setMensaje(n.getMensaje());
		nD.setEstado(n.getEstado());
		
		return nD;
	}
}
