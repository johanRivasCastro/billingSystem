package com.johanRivas.billingSystem.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johanRivas.billingSystem.models.entity.Product;

@Repository("productRepository")
public interface IProductoDao extends JpaRepository<Product, Long> {

}
