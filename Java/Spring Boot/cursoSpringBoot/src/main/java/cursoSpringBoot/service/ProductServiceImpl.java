package cursoSpringBoot.service;

import cursoSpringBoot.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 799.9, 10),
            new Product(2, "smatphone", 399.3, 10),
            new Product(3, "tablet", 100.6,10),
            new Product(3, "watch", 100.6,10)
    ));

    public List<Product> getProducts(){
        return products;
    }
}
