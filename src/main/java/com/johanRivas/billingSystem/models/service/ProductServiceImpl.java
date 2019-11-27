package com.johanRivas.billingSystem.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johanRivas.billingSystem.models.dao.IProductoDao;
import com.johanRivas.billingSystem.models.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductoDao productDao;

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getProductById(long id) {
		return productDao.findById(id).orElse(null);
	}

	@Override
	public void addProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productDao.deleteById(id);
	}

}
