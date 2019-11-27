package com.johanRivas.billingSystem.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johanRivas.billingSystem.models.entity.GlobalConfig;

public interface IGlobalConfigDao extends JpaRepository<GlobalConfig, Long> {

}
