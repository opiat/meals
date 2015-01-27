package wwirzbicki.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String producerName;
	private double kcalPer100g;
	private double proteins;
	private double fats;
	private double carbohydrates;
	private double defaultWeight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getKcalPer100g() {
		return kcalPer100g;
	}

	public void setKcalPer100g(double kcalPer100g) {
		this.kcalPer100g = kcalPer100g;
	}

	public double getProteins() {
		return proteins;
	}

	public void setProteins(double proteins) {
		this.proteins = proteins;
	}

	public double getFats() {
		return fats;
	}

	public void setFats(double fats) {
		this.fats = fats;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public long getId() {
		return id;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public double getWeight() {
		return defaultWeight;
	}

	public void setWeight(double weight) {
		this.defaultWeight = weight;
	}

}
