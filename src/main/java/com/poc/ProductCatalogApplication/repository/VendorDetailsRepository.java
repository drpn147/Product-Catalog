package com.poc.ProductCatalogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.ProductCatalogApplication.model.VendorDetails;

@Repository
public interface VendorDetailsRepository extends JpaRepository<VendorDetails, Integer>,CustomVendorRepo {

}
