package com.poc.ProductCatalogApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.poc.ProductCatalogApplication.model.ProductDetails;

public class ProductDetailsRepositoryImpl implements CustomProductRepo {

	@Autowired
	private EntityManager entityManager;

	@Override
	public ProductDetails searchByName(String productName) {
		// TODO Auto-generated method stub
		String JPQL="FROM ProductDetails WHERE productName=:product_name";
		TypedQuery<ProductDetails> query=entityManager.createQuery(JPQL,ProductDetails.class);
		query.setParameter("product_name", productName);
		
		return query.getSingleResult();
	}

}
