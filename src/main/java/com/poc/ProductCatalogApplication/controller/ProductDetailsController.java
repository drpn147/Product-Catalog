package com.poc.ProductCatalogApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.ProductCatalogApplication.exception.NoDataFound;
import com.poc.ProductCatalogApplication.model.ProductDetails;
import com.poc.ProductCatalogApplication.service.ProductDetailsService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductDetailsController {

	@Autowired
	private ProductDetailsService productDetailsService;

	@GetMapping("/get_products")
	ResponseEntity<List<ProductDetails>> getAllProduct() {
		return new ResponseEntity<>(this.productDetailsService.getAllProduct(), HttpStatus.OK);
	}

	@PostMapping("/save_product/{vendorId}")
	ResponseEntity<ProductDetails> saveProduct(@RequestBody ProductDetails product, @PathVariable("vendorId") int vendorId) {
		return new ResponseEntity<>(this.productDetailsService.saveProduct(product,vendorId), HttpStatus.OK);
	}

	@GetMapping("/get_product/{productName}")
	ResponseEntity<ProductDetails> getProductByName(@PathVariable(value = "productName") String productName) {
		return new ResponseEntity<>(this.productDetailsService.getProductByName(productName), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	ResponseEntity<HttpStatus> deleteProduct(@RequestParam(name = "id") int productId) {
		try {
			this.productDetailsService.deleteProduct(productId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			throw new NoDataFound("Product not found");
		}
	}

}
