package com.fithub.rutinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fithub.rutinas.entity.RutinaEntity;

import jakarta.transaction.Transactional;

@Repository
public interface RutinaRepository extends JpaRepository<RutinaEntity, Long> {

	@Query(value = "SELECT * FROM rutinas WHERE trainer_id = :trainerId", nativeQuery = true)
	List<RutinaEntity> rutinasTrainer(@Param("trainerId") Long trainerId);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO rutina_entity_client_id (rutina_entity_id, client_id) VALUES (:id, :clientId)", nativeQuery = true)
	void asignarRutina(@Param("clientId") Long clientId, @Param("id") Long id);
}
