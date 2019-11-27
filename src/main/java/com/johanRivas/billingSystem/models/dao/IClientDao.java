package com.johanRivas.billingSystem.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johanRivas.billingSystem.models.entity.Client;

@Repository("clientRepository")
public interface IClientDao extends JpaRepository<Client, Long> {

}
