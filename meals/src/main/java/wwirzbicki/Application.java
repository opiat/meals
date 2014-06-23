package wwirzbicki;
import java.util.Locale;

import org.joda.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import wwirzbicki.dao.MealRepository;
import wwirzbicki.dao.ProductRepository;
import wwirzbicki.model.Meal;
import wwirzbicki.model.Product;

@EnableAutoConfiguration
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		MealRepository mealRepository = ctx.getBean(MealRepository.class);
		ProductRepository productRepository = ctx.getBean(ProductRepository.class);
		
		LocalDate today = LocalDate.now();
		
		Product p1 = createProduct("serek wiejski");
		productRepository.save(p1);
		
		mealRepository.save(buildMeal(p1, today));
		mealRepository.save(buildMeal(p1, today));
		mealRepository.save(buildMeal(p1, today));
		
		mealRepository.save(buildMeal(p1, today.minusDays(1)));
		mealRepository.save(buildMeal(p1, today.minusDays(1)));
		mealRepository.save(buildMeal(p1, today.minusDays(1)));
		
	}
	
	public static Product createProduct(String name){
		Product product = new Product();
		product.setName(name);
		product.setProteins(10);
		product.setCarbohydrates(20);
		product.setFats(30);
		product.setKcalPer100g(200);
		return product;
	}
	
	private static Meal buildMeal(Product product, LocalDate date) {
		Meal meal = new Meal();
		meal.setProduct(product);
		meal.setDate(date);
		meal.setWeight(150);
		return meal;
	}

	@Bean
	public LocaleResolver localeResolver(){
		return new FixedLocaleResolver(new Locale("pl"));
	}
}
