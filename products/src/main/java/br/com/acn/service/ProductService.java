package br.com.acn.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acn.model.Product;
import br.com.acn.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository prodRep;
	
		// Business
	public Product register(Product product) {

		return prodRep.save(product);
	}

	public Collection<Product> searchAll() {

		return prodRep.findAll();
	}

	public Product searchById(Integer id) {

		return prodRep.findOne(id);
	}

	public void delete(Product product) {
		prodRep.delete(product);
	}
	
	public Product alter(Product product) {
		return prodRep.save(product);
	}

}
