package com.johanRivas.billingSystem.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.johanRivas.billingSystem.models.entity.Product;

@Repository("productRepository")
public interface IProductoDao extends JpaRepository<Product, Long> {

	@Query("select p from Product p where p.name like %?1%")
	public List<Product> findByName(String term);

	public List<Product> findByNameLikeIgnoreCase(String term);

}
