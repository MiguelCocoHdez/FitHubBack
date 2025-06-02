package com.fithub.trainer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fithub.trainer.entity.TrainerEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {

	@Query(value = "SELECT * FROM trainers WHERE id = :id", nativeQuery = true)
	TrainerEntity verTrainerId(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM trainers WHERE email = :email", nativeQuery = true)
	TrainerEntity verTrainerEmail(@Param("email") String email);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE trainers SET plan = 'PREMIUM' WHERE email = :email", nativeQuery = true)
	void cambiarAPremiumTrainer(@Param("email") String email);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO trainer_entity_clientes_ids (trainer_entity_id, clientes_ids) VALUES (:trainerId, :clientId)", nativeQuery = true)
	void agregarClient(@Param("trainerId") Long trainerId, @Param("clientId") Long clientId);
	
	@Query(value = "SELECT * FROM trainers", nativeQuery = true)
	List<TrainerEntity> verTodosTrainers();
}
