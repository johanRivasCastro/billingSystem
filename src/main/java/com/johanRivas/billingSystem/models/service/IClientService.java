package com.johanRivas.billingSystem.models.service;

import java.util.List;

import com.johanRivas.billingSystem.models.entity.Client;

public interface IClientService {

	public List<Client> getAllClients();

	public Client getClientById(long id);

	public void addClient(Client client);

	public void deleteClient(Long id);

	public List<Client> findByTerm(String term);
}
