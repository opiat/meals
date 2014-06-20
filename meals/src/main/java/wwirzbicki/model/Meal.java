package wwirzbicki.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import wwirzbicki.util.LocalDateTimeJsonDeserializer;
import wwirzbicki.util.LocalDateTimeJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private int weight;
	private int kcalPer100g;
	private int proteins;
	private int fats;
	private int carbohydrates;

	@JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	@JsonDeserialize(using = LocalDateTimeJsonDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcalPer100g() {
		return kcalPer100g;
	}

	public void setKcalPer100g(int kcalPer100g) {
		this.kcalPer100g = kcalPer100g;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean hasNoDate() {
		return date == null;
	}

	public void setDateToNow() {
		date = LocalDate.now();
	}

	public double getKcal() {
		return weight / 100.0 * kcalPer100g;
	}

	public int getProteins() {
		return proteins;
	}

	public void setProteins(int proteins) {
		this.proteins = proteins;
	}

	public int getFats() {
		return fats;
	}

	public void setFats(int fats) {
		this.fats = fats;
	}

	public int getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(int carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public long getId() {
		return id;
	}

	
}
