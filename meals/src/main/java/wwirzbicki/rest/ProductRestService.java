package wwirzbicki.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wwirzbicki.dao.MealRepository;
import wwirzbicki.dao.ProductRepository;
import wwirzbicki.model.Product;

@RestController
@RequestMapping("/product")
public class ProductRestService {

	private final ProductRepository productRepository;
	private final MealRepository mealRepository;

	@Autowired
	public ProductRestService(ProductRepository productRepository, MealRepository mealRepository) {
		this.productRepository = productRepository;
		this.mealRepository = mealRepository;
	}

	@RequestMapping("/all")
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@RequestMapping("/delete/{productId}")
	public void deleteProduct(@PathVariable Long productId) {
		long mealCount = mealRepository.countByProductId(productId);
		if(mealCount > 0){
			throw new DeleteException("Nie można usunać produktu ponieważ ma przypisane posiłki.");
		}
		productRepository.delete(productId);
	}
}
