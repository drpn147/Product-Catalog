package com.poc.ProductCatalogApplication.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.ProductCatalogApplication.exception.NoDataFound;
import com.poc.ProductCatalogApplication.model.ProductDetails;
import com.poc.ProductCatalogApplication.model.VendorDetails;
import com.poc.ProductCatalogApplication.repository.ProductDetailsRepository;
import com.poc.ProductCatalogApplication.repository.VendorDetailsRepository;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

	@Autowired
	private ProductDetailsRepository productDetialsRepository;
	@Autowired
	private VendorDetailsRepository vendorDetailsRepository;

	@Override
	public List<ProductDetails> getAllProduct() {
		// TODO Auto-generated method stub
		List<ProductDetails> products = this.productDetialsRepository.findAll();
		if (products.size() == 0) {
			// throw exception notfound
			throw new NoDataFound("Product Not Found");
		}
		return products;
	}

	@Override
	public ProductDetails saveProduct(ProductDetails product, int vendorId) {
		// TODO Auto-generated method stub
		if (product.getProductId() != 0) {
			ProductDetails updateProduct = this.getProductByName(product.getProductName());
			updateProduct.setProductName(product.getProductName());
			updateProduct.setProductOS(product.getProductOS());
			updateProduct.setProductHDD(product.getProductHDD());
			updateProduct.setProductVendor(product.getProductVendor());
			updateProduct.setProductStock(product.getProductStock());
			return this.productDetialsRepository.save(updateProduct);
		}
		try {
			VendorDetails vendor = this.vendorDetailsRepository.findById(vendorId).get();
			product.setProductVendor(vendor);
		} catch (Exception e) {
			throw new NoDataFound("Vendor not present");
		}

		return this.productDetialsRepository.save(product);
	}

	@Override
	public ProductDetails getProductByName(String productName) {
		// TODO Auto-generated method stub
		if (productName.isEmpty()) {
			throw new NoDataFound("Please Enter valid product Name");
		}
		// return this.productDetialsRepository.findByName(productName);
		return this.productDetialsRepository.searchByName(productName);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Optional<ProductDetails> product = this.productDetialsRepository.findById(productId);
		if (product.isEmpty()) {
			throw new NoDataFound("Product not Found");
		}
		this.productDetialsRepository.deleteById(productId);
	}

}
