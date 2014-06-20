package wwirzbicki.model;

import java.util.List;

import org.joda.time.LocalDate;

public class MealDay {

	private Iterable<Meal> meals;
	private LocalDate date;
	
	public MealDay(Iterable<Meal> iterable, LocalDate date) {
		this.meals = iterable;
		this.date = date;
	}

	public Iterable<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
