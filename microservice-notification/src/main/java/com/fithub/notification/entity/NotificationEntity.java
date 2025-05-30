package com.fithub.notification.entity;

import com.fithub.notification.dto.RequestConectarTrainer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "notifications")
public class NotificationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long clientId;
	
	@Column
	private Long trainerId;
	
	@Column
	private String mensaje;
	
	@Enumerated(EnumType.STRING)
	private EstadoSolicitud estado;
	
	public static NotificationEntity parse(RequestConectarTrainer r) {
		NotificationEntity n = new NotificationEntity();
		
		n.setClientId(r.getClientId());
		n.setTrainerId(r.getTrainerId());
		n.setMensaje(r.getMensaje());
		
		return n;
	}
}
