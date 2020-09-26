package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CkException;

public interface ProductService {

	public ProductMaster addNewProduct(ProductMaster product) throws CkException;
	public List<ProductMaster> getAllProducts();
	public boolean deleteProduct(int productId) throws CkException;
	public ProductMaster getProductById(int productId);
	public ProductMaster save(ProductMaster product) throws CkException;
}
