package com.poc.ProductCatalogApplication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import com.poc.ProductCatalogApplication.model.ProductDetails;
import com.poc.ProductCatalogApplication.model.VendorDetails;
import com.poc.ProductCatalogApplication.service.ProductDetailsService;

@SpringBootTest
class TestProductDetails {

	@Test
	void testGetAllProduct() {
		ProductDetailsService productDetailsService=mock(ProductDetailsService.class);
		VendorDetails vendor=new VendorDetails();
		vendor.setVendorId(1);
		vendor.setVendorName("ABCD");
		vendor.setVendorContactNo(1234567890);
		vendor.setVendorAddress("PQRS");
		vendor.setVendorRating((float) 4.4);
		
		ProductDetails product=new ProductDetails();
		product.setProductId(2);
		product.setProductName("USUS");
		product.setProductOS("Win");
		product.setProductHDD("3TB");
		product.setProductStock(49);
		product.setProductVendor(vendor);
		
		List<ProductDetails> productList=new ArrayList<ProductDetails>();
		productList.add(product);
		
		when(productDetailsService.getAllProduct()).thenReturn(productList);
		assertEquals(1, productDetailsService.getAllProduct().size());
		verify(productDetailsService).getAllProduct();
	}
	
	@Test
	void testSaveProduct() {
		ProductDetailsService productDetailsService=mock(ProductDetailsService.class);
		VendorDetails vendor=new VendorDetails();
		vendor.setVendorId(1);
		vendor.setVendorName("ABCD");
		vendor.setVendorContactNo(1234567890);
		vendor.setVendorAddress("PQRS");
		vendor.setVendorRating((float) 4.4);
		
		ProductDetails product=new ProductDetails();
		product.setProductId(2);
		product.setProductName("USUS");
		product.setProductOS("Win");
		product.setProductHDD("3TB");
		product.setProductStock(49);
		
		when(productDetailsService.saveProduct(product, 1)).thenReturn(product);
		assertEquals(product,productDetailsService.saveProduct(product, 1));
		verify(productDetailsService).saveProduct(product, 1);
	}
	
	@Test
	void testGetProductByName() {
		ProductDetailsService productDetailsService=mock(ProductDetailsService.class);
		VendorDetails vendor=new VendorDetails();
		vendor.setVendorId(1);
		vendor.setVendorName("ABCD");
		vendor.setVendorContactNo(1234567890);
		vendor.setVendorAddress("PQRS");
		vendor.setVendorRating((float) 4.4);
		
		ProductDetails product=new ProductDetails();
		product.setProductId(2);
		product.setProductName("USUS");
		product.setProductOS("Win");
		product.setProductHDD("3TB");
		product.setProductStock(49);
		
		when(productDetailsService.getProductByName("USUS")).thenReturn(product);
		assertEquals(product,productDetailsService.getProductByName("USUS"));
		verify(productDetailsService).getProductByName("USUS");
	}
	
	@Test
	void testDeleteProduct() {
		ProductDetailsService productDetailsService=mock(ProductDetailsService.class);
		VendorDetails vendor=new VendorDetails();
		vendor.setVendorId(1);
		vendor.setVendorName("ABCD");
		vendor.setVendorContactNo(1234567890);
		vendor.setVendorAddress("PQRS");
		vendor.setVendorRating((float) 4.4);
		
		ProductDetails product=new ProductDetails();
		product.setProductId(2);
		product.setProductName("USUS");
		product.setProductOS("Win");
		product.setProductHDD("3TB");
		product.setProductStock(49);
		productDetailsService.deleteProduct(2);
		verify(productDetailsService).deleteProduct(2);
	}

}
