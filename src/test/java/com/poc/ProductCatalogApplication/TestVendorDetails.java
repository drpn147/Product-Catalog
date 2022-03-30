package com.poc.ProductCatalogApplication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.ProductCatalogApplication.model.ProductDetails;
import com.poc.ProductCatalogApplication.model.VendorDetails;
import com.poc.ProductCatalogApplication.service.VendorDetailsService;

@SpringBootTest
class TestVendorDetails {
	
	@Mock
	private VendorDetailsService vendorDetialsService;
	
	@Test
	void testGetAllVendor() {
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
		
		List<VendorDetails> vendorList=new ArrayList<VendorDetails>();
		vendorList.add(vendor);
		when(this.vendorDetialsService.getAllVendor()).thenReturn(vendorList);
		assertEquals(1,this.vendorDetialsService.getAllVendor().size());
		verify(this.vendorDetialsService).getAllVendor();
	}
	
	@Test
	void testSaveVendor() {
		VendorDetails vendor=new VendorDetails();
		vendor.setVendorId(1);
		vendor.setVendorName("ABCD");
		vendor.setVendorContactNo(1234567890);
		vendor.setVendorAddress("PQRS");
		vendor.setVendorRating((float) 4.4);
		
		when(this.vendorDetialsService.saveVendor(vendor)).thenReturn(vendor);
		assertEquals(vendor,this.vendorDetialsService.saveVendor(vendor));
		verify(this.vendorDetialsService).saveVendor(vendor);
	}
	
	@Test
	void testGetVendorByName() {
		VendorDetails vendor=new VendorDetails();
		vendor.setVendorId(1);
		vendor.setVendorName("ABCD");
		vendor.setVendorContactNo(1234567890);
		vendor.setVendorAddress("PQRS");
		vendor.setVendorRating((float) 4.4);
		
		when(this.vendorDetialsService.getVendorByName("ABCD")).thenReturn(vendor);
		assertEquals(vendor,this.vendorDetialsService.getVendorByName("ABCD"));
		verify(this.vendorDetialsService).getVendorByName("ABCD");
	}
	
	@Test
	void testDeleteVendor() {
		VendorDetails vendor=new VendorDetails();
		vendor.setVendorId(1);
		vendor.setVendorName("ABCD");
		vendor.setVendorContactNo(1234567890);
		vendor.setVendorAddress("PQRS");
		vendor.setVendorRating((float) 4.4);
		
		this.vendorDetialsService.deleteVendor(1);
		
		verify(this.vendorDetialsService).deleteVendor(1);
	}

}
