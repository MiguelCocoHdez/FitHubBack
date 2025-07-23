package com.fithub.connection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fithub.connection.entity.MensajesEntity;

@Repository
public interface ConnectionRepository extends JpaRepository<MensajesEntity, Long> {

}
