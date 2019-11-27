package com.johanRivas.billingSystem.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johanRivas.billingSystem.models.dao.IGlobalConfigDao;
import com.johanRivas.billingSystem.models.entity.GlobalConfig;

@Service
public class GlobalConfigServiceImpl implements IGlobalConfigService {

	@Autowired
	private IGlobalConfigDao globalConfigDao;

	@Override
	public GlobalConfig properties() {
		return globalConfigDao.findAll().get(0);
	}

	@Override
	public void saveConfig(GlobalConfig config) {
		globalConfigDao.save(config);
	}

}
