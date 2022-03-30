package com.poc.ProductCatalogApplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	int productId;

	@Column(name = "product_name")
	String productName;

	@Column(name = "product_os")
	String productOS;

	@Column(name = "product_hdd")
	String productHDD;

	@Column(name = "product_stock")
	int productStock;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_id")
	VendorDetails productVendor;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductOS() {
		return productOS;
	}

	public void setProductOS(String productOS) {
		this.productOS = productOS;
	}

	public String getProductHDD() {
		return productHDD;
	}

	public void setProductHDD(String productHDD) {
		this.productHDD = productHDD;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public VendorDetails getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(VendorDetails productVendor) {
		this.productVendor = productVendor;
	}

	public ProductDetails(int productId, String productName, String productOS, String productHDD, int productStock,
			VendorDetails productVendor) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productOS = productOS;
		this.productHDD = productHDD;
		this.productStock = productStock;
		this.productVendor = productVendor;
	}

	public ProductDetails() {
		super();
	}
	
	

}
