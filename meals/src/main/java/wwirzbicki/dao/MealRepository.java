package wwirzbicki.dao;

import org.springframework.data.repository.CrudRepository;

import wwirzbicki.model.Meal;

public interface MealRepository extends CrudRepository<Meal, Long> {

}
