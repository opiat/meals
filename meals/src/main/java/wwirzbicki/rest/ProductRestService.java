package wwirzbicki.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wwirzbicki.dao.ProductRepository;
import wwirzbicki.model.Product;

@RestController
@RequestMapping("/product")
public class ProductRestService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductRestService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@RequestMapping("/all")
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
