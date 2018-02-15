package br.com.acn.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.acn.model.Product;
import br.com.acn.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	

	// End points
	@RequestMapping(method = RequestMethod.POST, value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> registerPoduct(@RequestBody Product product) {

		Product savedProduct = productService.register(product);

		System.out.println(savedProduct.toString());

		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Product>> searchAllPoducts() {

		Collection<Product> products = productService.searchAll();

		System.out.println(products.toString());

		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
	public ResponseEntity<Product> deletePoduct(@PathVariable Integer id) {

		Product productFound = productService.searchById(id);

		if (productFound == null) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		System.out.println(productFound);

		productService.delete(productFound);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> alterPoduct(@RequestBody Product product) {

		Product alteredProduct = productService.alter(product);

		System.out.println(alteredProduct.toString());

		return new ResponseEntity<>(alteredProduct, HttpStatus.OK);
	}

	// @RequestMapping(method = RequestMethod.GET, value = "/products")
	// public void search() {
	// System.out.println("Chamou!");
	// }

}
