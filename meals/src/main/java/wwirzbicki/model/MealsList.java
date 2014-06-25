package wwirzbicki.model;

import java.util.List;

public class MealsList {

	private Iterable<Meal> meals;
	
	public MealsList(Iterable<Meal> iterable) {
		this.meals = iterable;
	}

	public Iterable<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}


	public double getKcalTotal(){
		double sum = 0;
		for(Meal meal : meals){
			sum += meal.getKcal();
		}
		return sum;
	}
	
	public double getWeightTotal(){
		double sum = 0;
		for(Meal meal : meals){
			sum += meal.getWeight();
		}
		return sum;
	}
	
	public double getProteinsTotal(){
		double sum = 0;
		for(Meal meal : meals){
			sum += meal.getProteins();
		}
		return sum;
	}
	
	public double getFatsTotal(){
		double sum = 0;
		for(Meal meal : meals){
			sum += meal.getFats();
		}
		return sum;
	}
	
	public double getCarbohydratesTotal(){
		double sum = 0;
		for(Meal meal : meals){
			sum += meal.getCarbohydrates();
		}
		return sum;
	}
}
