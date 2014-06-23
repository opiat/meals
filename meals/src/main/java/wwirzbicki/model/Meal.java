package wwirzbicki.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

	private int weight;

	@JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	@JsonDeserialize(using = LocalDateTimeJsonDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@ManyToOne(cascade={CascadeType.MERGE})
	private Product product;

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
		return weight / 100.0 * product.getKcalPer100g();
	}

	public long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
