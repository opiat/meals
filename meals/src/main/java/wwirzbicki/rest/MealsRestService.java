package wwirzbicki.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wwirzbicki.dao.MealRepository;
import wwirzbicki.model.Meal;

@RestController
@RequestMapping("/meals")
public class MealsRestService {

	private final MealRepository mealRepository;

	@Autowired
	public MealsRestService(MealRepository mealRepository) {
		this.mealRepository = mealRepository;
	}

	@RequestMapping("/all")
	public Iterable<Meal> getAllMeals() {
		return mealRepository.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Meal meal) {
		mealRepository.save(meal);
	}

	@RequestMapping("/add/random")
	public void addRandomMeal() {
		Meal meal = new Meal();
		meal.name = "Meal: " + Math.random();
		mealRepository.save(meal);
	}
}
