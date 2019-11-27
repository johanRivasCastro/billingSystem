package com.johanRivas.billingSystem.models.service;

import com.johanRivas.billingSystem.models.entity.GlobalConfig;

public interface IGlobalConfigService {

	GlobalConfig properties();

	void saveConfig(GlobalConfig config);
}
