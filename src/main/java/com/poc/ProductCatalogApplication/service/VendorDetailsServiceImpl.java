package com.poc.ProductCatalogApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.ProductCatalogApplication.exception.NoDataFound;
import com.poc.ProductCatalogApplication.model.VendorDetails;
import com.poc.ProductCatalogApplication.repository.VendorDetailsRepository;

@Service
public class VendorDetailsServiceImpl implements VendorDetailsService {

	@Autowired
	private VendorDetailsRepository vendorDetailsRepository;

	@Override
	public List<VendorDetails> getAllVendor() {
		// TODO Auto-generated method stub
		List<VendorDetails> vendors = this.vendorDetailsRepository.findAll();
		if (vendors.size() == 0) {
			throw new NoDataFound("No Vendor details Present");
		}
		return this.vendorDetailsRepository.findAll();
	}

	@Override
	public VendorDetails saveVendor(VendorDetails vendor) {
		// TODO Auto-generated method stub
		if (vendor.getVendorId() != 0) {
			VendorDetails v = this.vendorDetailsRepository.findById(vendor.getVendorId()).get();
			if (v == null) {
				throw new NoDataFound("Vendor details not present");
			}
			v.setVendorName(vendor.getVendorName());
			v.setVendorRating(vendor.getVendorRating());
			v.setVendorAddress(vendor.getVendorAddress());
			v.setVendorContactNo(vendor.getVendorContactNo());
			v.setProduct(vendor.getProduct());
			return this.vendorDetailsRepository.save(v);

		}
		return this.vendorDetailsRepository.save(vendor);
	}

	@Override
	public VendorDetails getVendorByName(String vendorName) {
		// TODO Auto-generated method stub
		// return this.vendorDetailsRepository.findVendorByName(vendorName);
		if (vendorName == null) {
			throw new NoDataFound("No Vendor Present");
		}

		return this.vendorDetailsRepository.searchByName(vendorName);
	}

	@Override
	public void deleteVendor(int vendorId) {
		// TODO Auto-generated method stub
		VendorDetails vendor = this.vendorDetailsRepository.findById(vendorId).get();
		if (vendor == null) {
			throw new NoDataFound("No Vendor Present");
		}
		this.vendorDetailsRepository.deleteById(vendorId);

	}

	@Override
	public VendorDetails getVendorById(int vendorId) {
		if(vendorId==0) {
			throw new NoDataFound("No Vendor Present");
		}
		return this.vendorDetailsRepository.findById(vendorId).get();
	}

}
