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

import com.poc.ProductCatalogApplication.model.VendorDetails;
import com.poc.ProductCatalogApplication.service.VendorDetailsService;

@RestController
@RequestMapping("/vendor")
@CrossOrigin(origins = "*")
public class VendorDetailsController {

	@Autowired
	private VendorDetailsService vendorDetailsService;

	@GetMapping("/vendors")
	ResponseEntity<List<VendorDetails>> getAllVendor() {
		return new ResponseEntity<List<VendorDetails>>(this.vendorDetailsService.getAllVendor(), HttpStatus.OK);
	}

	@PostMapping("/save")
	ResponseEntity<VendorDetails> saveVendor(@RequestBody VendorDetails vendor) {
		return new ResponseEntity<>(this.vendorDetailsService.saveVendor(vendor), HttpStatus.OK);
	}

	@GetMapping("/vendor/{vendorName}")
	ResponseEntity<VendorDetails> getVendorByName(@PathVariable(value = "vendorName") String vendorName) {
		return new ResponseEntity<>(this.vendorDetailsService.getVendorByName(vendorName), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	ResponseEntity<HttpStatus> deleteVendor(@RequestParam (name = "vendorId") int vendorId) throws Exception {
		try {
			this.vendorDetailsService.deleteVendor(vendorId);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@GetMapping("/{vendorId}")
	ResponseEntity<VendorDetails> getVendorById(@PathVariable(value = "vendorId") int vendorId) {
		return new ResponseEntity<>(this.vendorDetailsService.getVendorById(vendorId), HttpStatus.OK);
	}
}
