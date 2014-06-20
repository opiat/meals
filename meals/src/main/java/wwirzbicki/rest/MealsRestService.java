package wwirzbicki.rest;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wwirzbicki.dao.MealRepository;
import wwirzbicki.model.Meal;
import wwirzbicki.util.LocalDateTimeJsonSerializer;

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

	@RequestMapping("/list/byDate/{date}")
	public Iterable<Meal> getMealsByDate(@PathVariable("date") String dateStr) {
		LocalDate date = LocalDateTimeJsonSerializer.FORMATTER
				.parseLocalDate(dateStr);
		return mealRepository.findByDate(date);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Meal meal) {
		if (meal.hasNoDate()) {
			meal.setDateToNow();
		}
		mealRepository.save(meal);
	}

}
