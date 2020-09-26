package com.eval.coronakit.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CkException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMasterRepository repository;

	@PostConstruct
	public void init() throws Exception {
		ProductMaster productMaster = new ProductMaster();
		productMaster.setCost(100);
		productMaster.setId(1);
		productMaster.setProductDescription("face mask");
		productMaster.setProductName("mask");
		this.save(productMaster);
	}

	@Override
	@Transactional
	public ProductMaster addNewProduct(ProductMaster product) throws CkException {
		if (product != null) {
			if (repository.existsById(product.getId())) {
				throw new CkException("Item code already used");
			}
			repository.save(product);
		}

		return product;
	}

	@Transactional
	public ProductMaster save(ProductMaster product) throws CkException {
		if (product != null) {
			if (repository.existsById(product.getId())) {
				throw new CkException("product already exists");
			}
			repository.save(product);
		}
		return product;
	}

	@Override
	public boolean deleteProduct(int productId) throws CkException {
		if (!repository.existsById(productId)) {
			throw new CkException("Item Not Found");
		}
		repository.deleteById(productId);
		return true;
	}

	@Override
	public List<ProductMaster> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public ProductMaster getProductById(int productId) {
		return repository.findById(productId).orElse(null);

	}

}
