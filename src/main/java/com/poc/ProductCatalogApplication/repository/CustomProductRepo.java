package com.poc.ProductCatalogApplication.repository;

import com.poc.ProductCatalogApplication.model.ProductDetails;

public interface CustomProductRepo {

	ProductDetails searchByName(String productName);
}
