package com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.rest.config.ResponseDTO;
import com.example.rest.service.ProductService;
import com.example.rest.model.Product;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	ProductService productService;

	  @GetMapping
	  public ResponseEntity<ResponseDTO> findAll() {
		  ResponseDTO responseDTO = ResponseDTO.builder()
		            .status(HttpStatus.OK.toString())
		            .body(productService.getAll()).build();

		 return ResponseEntity.ok(responseDTO);
	  }
	  
	  @GetMapping("/{id}")
	  public ResponseEntity<ResponseDTO> findById(@PathVariable Long id) {
		  ResponseDTO responseDTO = ResponseDTO.builder()
				  .status(HttpStatus.OK.toString())
				  .body(productService.getById(id)).build();
		  return ResponseEntity.ok(responseDTO);
	  }

	@PostMapping
	public ResponseEntity<ResponseDTO> create(Product product) {
	  	try {
			Product newProduct = productService.save(product);
			ResponseDTO responseDTO = ResponseDTO.builder()
					.status(HttpStatus.CREATED.toString())
					.body(newProduct).build();
			return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTO.builder()
					.status(HttpStatus.BAD_GATEWAY.toString())
					.message("terjadi kesalahan").build();
			return ResponseEntity.badRequest().body(responseDTO);
		}


	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO> update(@PathVariable Long id, Product product) {
		try {
			Product newProduct = productService.save(product);
			ResponseDTO responseDTO = ResponseDTO.builder()
					.status(HttpStatus.ACCEPTED.toString())
					.body(newProduct).build();
			return ResponseEntity.accepted().body(responseDTO);

		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTO.builder()
					.status(HttpStatus.BAD_GATEWAY.toString())
					.message("terjadi kesalahan").build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
		productService.deleteById(id);

		ResponseDTO responseDTO = ResponseDTO.builder()
				.status(HttpStatus.ACCEPTED.toString()).build();

		return ResponseEntity.accepted().body(responseDTO);
	}
}
