package com.poc.ProductCatalogApplication.service;

import java.util.List;

import com.poc.ProductCatalogApplication.model.VendorDetails;

public interface VendorDetailsService {

	List<VendorDetails> getAllVendor();

	VendorDetails saveVendor(VendorDetails vendor);

	VendorDetails getVendorByName(String vendorName);

	void deleteVendor(int vendorId);

	VendorDetails getVendorById(int vendorId);

}
