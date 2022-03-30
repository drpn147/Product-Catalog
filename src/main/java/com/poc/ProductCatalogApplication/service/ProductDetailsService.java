package com.poc.ProductCatalogApplication.service;

import java.util.List;

import com.poc.ProductCatalogApplication.model.ProductDetails;

public interface ProductDetailsService {

	List<ProductDetails> getAllProduct();

	ProductDetails saveProduct(ProductDetails product, int vendorId);

	ProductDetails getProductByName(String productName);

	void deleteProduct(int productId);

}
