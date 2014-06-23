package wwirzbicki.dao;

import org.springframework.data.repository.CrudRepository;

import wwirzbicki.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
