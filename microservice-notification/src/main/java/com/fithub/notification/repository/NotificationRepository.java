package com.fithub.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fithub.notification.entity.NotificationEntity;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

}
