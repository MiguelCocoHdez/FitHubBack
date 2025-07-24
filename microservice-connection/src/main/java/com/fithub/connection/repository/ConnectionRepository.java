package com.fithub.connection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fithub.connection.entity.MensajesEntity;

@Repository
public interface ConnectionRepository extends JpaRepository<MensajesEntity, Long> {

	@Query(value = "SELECT * FROM mensajes WHERE trainer_id = :trainerId AND client_id = :clientId ORDER BY hora_enviada ASC", nativeQuery = true)
	List<MensajesEntity> verConversacion(@Param("trainerId") Long trainerId, @Param("clientId") Long clientId);
}
