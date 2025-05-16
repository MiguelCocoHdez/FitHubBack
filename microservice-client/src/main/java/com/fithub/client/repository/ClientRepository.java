package com.fithub.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fithub.client.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

	@Query(value = "SELECT * FROM clientes WHERE id IN (:ids)", nativeQuery = true)
	List<ClientEntity> verClientesTrainer(@Param("ids") List<Long> ids);
}
