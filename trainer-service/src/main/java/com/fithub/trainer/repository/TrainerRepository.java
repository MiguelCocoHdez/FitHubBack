package com.fithub.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fithub.trainer.entity.TrainerEntity;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {

	@Query(value = "SELECT * FROM trainers WHERE id = :id", nativeQuery = true)
	TrainerEntity verTrainerId(@Param("id") Long id);
}
