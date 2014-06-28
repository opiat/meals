package wwirzbicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wwirzbicki.dao.MealRepository;
import wwirzbicki.model.Meal;

@Service
public class MealService {

	private final SequenceService sequenceService;

	private final MealRepository mealRepository;

	@Autowired
	public MealService(SequenceService sequenceService,
			MealRepository mealRepository) {
		this.sequenceService = sequenceService;
		this.mealRepository = mealRepository;
	}

	public void save(Meal meal) {
		if(meal.hasNoSequenceNumber()){
			meal.setSequenceNumber(sequenceService.nextValue("mealSequence"));
		}
		if (meal.hasNoDate()) {
			meal.setDateToNow();
		}
		mealRepository.save(meal);
	}
}
