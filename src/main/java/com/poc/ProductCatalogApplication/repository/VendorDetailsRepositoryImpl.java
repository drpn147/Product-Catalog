package com.poc.ProductCatalogApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.poc.ProductCatalogApplication.model.VendorDetails;

public class VendorDetailsRepositoryImpl implements CustomVendorRepo {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public VendorDetails searchByName(String vendorName) {
		// TODO Auto-generated method stub
		String JPQL="FROM VendorDetails WHERE vendorName=:vendor_name";
		TypedQuery<VendorDetails>query=entityManager.createQuery(JPQL,VendorDetails.class);
		query.setParameter("vendor_name", vendorName);
		return query.getSingleResult();
	}

}
