package cursoSpringBoot;

import ch.qos.logback.core.testUtil.StringListAppender;
import cursoSpringBoot.service.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class CursoSpringBootApplication {

	public static void main(String[] args) {

		var app = new SpringApplication(CursoSpringBootApplication.class);
		//var app = SpringApplication.run(CursoSpringBootApplication.class, args);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "prod"));
		var ctx = app.run(args);

		ProductServiceImpl productService = ctx.getBean(ProductServiceImpl.class);

		System.out.println(productService.tellStory());
		System.out.println("Value of properties in file configuration: " + productService.getValueProperties());
		System.out.println("Assign a value to a field in class: " + productService.getStringValueProperties());
	}

}
