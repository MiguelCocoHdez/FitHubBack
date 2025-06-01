package com.fithub.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fithub.notification.entity.NotificationEntity;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

	@Query(value = "SELECT * FROM notifications WHERE trainer_id = :trainerId AND estado = 'PENDIENTE'", nativeQuery = true)
	List<NotificationEntity> verNotificacionesTrainer(@Param("trainerId") Long trainerId);
}
