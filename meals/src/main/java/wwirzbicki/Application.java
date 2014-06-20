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
import wwirzbicki.model.Meal;

@EnableAutoConfiguration
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		MealRepository repository = ctx.getBean(MealRepository.class);
		
		LocalDate today = LocalDate.now();
		
		repository.save(buildMeal("sniadanie", today));
		repository.save(buildMeal("obiad", today));
		repository.save(buildMeal("kolacja", today));
		
		repository.save(buildMeal("sniadanie", today.minusDays(1)));
		repository.save(buildMeal("obiad", today.minusDays(1)));
		repository.save(buildMeal("kolacja", today.minusDays(1)));
		
	}
	
	private static Meal buildMeal(String name, LocalDate date) {
		Meal meal = new Meal();
		meal.setName(name);
		meal.setDate(date);
		return meal;
	}

	@Bean
	public LocaleResolver localeResolver(){
		return new FixedLocaleResolver(new Locale("pl"));
	}
}
