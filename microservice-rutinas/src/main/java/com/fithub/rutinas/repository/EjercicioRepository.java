package com.fithub.rutinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fithub.rutinas.entity.EjercicioEntity;

@Repository
public interface EjercicioRepository extends JpaRepository<EjercicioEntity, Long> {

}
