package com.johanRivas.billingSystem.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johanRivas.billingSystem.models.dao.IClientDao;
import com.johanRivas.billingSystem.models.entity.Client;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientDao;

	@Override
	@Transactional(readOnly = true)
	public List<Client> getAllClients() {
		return clientDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Client getClientById(long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	public void addClient(Client client) {
		clientDao.save(client);
	}

	@Override
	public void deleteClient(Long id) {
		clientDao.deleteById(id);
	}

}
