package cursoSpringBoot;


import cursoSpringBoot.domain.Product;
import cursoSpringBoot.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class ApplicationConfig {

    @Bean
    @Primary
    @Profile("dev")
    public ProductServiceImpl MyFirstBean(){
        return new ProductServiceImpl(Arrays.asList(
            new Product(1, "Laptop", 799.9, 10, "some colum"),
            new Product(2, "smatphone", 399.3, 10, "some colum"),
            new Product(3, "tablet", 100.6,10, "some colum"),
            new Product(3, "watch", 100.6,10, "some colum")
    ));}
}
