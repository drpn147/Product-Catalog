package com.poc.ProductCatalogApplication.repository;

import com.poc.ProductCatalogApplication.model.VendorDetails;

public interface CustomVendorRepo {

	VendorDetails searchByName(String vendorName);
}
