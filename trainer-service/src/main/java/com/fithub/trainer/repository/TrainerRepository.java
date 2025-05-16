package com.fithub.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fithub.trainer.entity.TrainerEntity;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {

}
