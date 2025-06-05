package com.fithub.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fithub.notification.entity.NotificationEntity;

import jakarta.transaction.Transactional;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

	@Query(value = "SELECT * FROM notifications WHERE trainer_id = :trainerId AND estado = 'PENDIENTE'", nativeQuery = true)
	List<NotificationEntity> verNotificacionesTrainer(@Param("trainerId") Long trainerId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE notifications SET estado = 'ACEPTADA' WHERE id = :id", nativeQuery = true)
	void aceptarPeticion(@Param("id") Long id);
	
	@Query(value = "SELECT EXISTS ( SELECT 1 FROM notifications WHERE client_id = :clientId AND trainer_id = :trainerId AND estado = 'PENDIENTE')", nativeQuery = true)
	Boolean notificacionRepetida(@Param("clientId") Long clientId, @Param("trainerId") Long trainerId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE notifications SET estado = 'RECHAZADA' WHERE id = :id", nativeQuery = true)
	void rechazarPeticion(@Param("id") Long id);
}
