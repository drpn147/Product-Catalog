package com.poc.ProductCatalogApplication.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VendorDetails {

	public VendorDetails() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_id")
	int vendorId;

	@Column(name = "vendor_name")
	String vendorName;

	@Column(name = "vendor_rating")
	float vendorRating;

	@Column(name = "vendor_address")
	String vendorAddress;

	@Column(name = "vendor_contact_no")
	long vendorContactNo;

	@JsonIgnore
	@OneToMany(mappedBy="productVendor")
	List<ProductDetails> product;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public float getVendorRating() {
		return vendorRating;
	}

	public void setVendorRating(float vendorRating) {
		this.vendorRating = vendorRating;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public long getVendorContactNo() {
		return vendorContactNo;
	}

	public void setVendorContactNo(long vendorContactNo) {
		this.vendorContactNo = vendorContactNo;
	}

	public List<ProductDetails> getProduct() {
		return product;
	}

	public void setProduct(List<ProductDetails> product) {
		this.product = product;
	}

	public VendorDetails(int vendorId, String vendorName, float vendorRating, String vendorAddress,
			long vendorContactNo) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorRating = vendorRating;
		this.vendorAddress = vendorAddress;
		this.vendorContactNo = vendorContactNo;
	}

}
