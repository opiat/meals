package wwirzbicki.dao;

import org.joda.time.LocalDate;
import org.springframework.data.repository.CrudRepository;

import wwirzbicki.model.Meal;

public interface MealRepository extends CrudRepository<Meal, Long> {

	Iterable<Meal> findByDateOrderBySequenceNumberAsc(LocalDate date);

	long countByProductId(Long productId);

}
