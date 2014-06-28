package wwirzbicki.model;

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
	private Long id;

	private double weight;

	@JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	@JsonDeserialize(using = LocalDateTimeJsonDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@ManyToOne(optional = false)
	private Product product;

	private Long sequenceNumber;

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
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

	public double getProteins() {
		return weightModifier() * product.getProteins();
	}

	public double getCarbohydrates() {
		return weightModifier() * product.getCarbohydrates();
	}

	public double getFats() {
		return weightModifier() * product.getFats();
	}

	public double getKcal() {
		return weightModifier() * product.getKcalPer100g();
	}

	private double weightModifier() {
		return weight / 100;
	}

	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean hasNoSequenceNumber() {
		return sequenceNumber == null;
	}

	public void setSequenceNumber(Long sn) {
		this.sequenceNumber = sn;
	}

	public Long getSequenceNumber() {
		return sequenceNumber;
	}

}
