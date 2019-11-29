package com.johanRivas.billingSystem.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.johanRivas.billingSystem.models.entity.Client;

@Repository("clientRepository")
public interface IClientDao extends JpaRepository<Client, Long> {

	@Query("select c from Client c where c.name like %?1%")
	public List<Client> findByTerm(String term);

}
