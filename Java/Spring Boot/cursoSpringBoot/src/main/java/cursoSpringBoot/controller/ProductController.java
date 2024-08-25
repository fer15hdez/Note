package cursoSpringBoot.controller;

import cursoSpringBoot.domain.Product;
import cursoSpringBoot.service.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos") // This is the prefix to all the url on this class.
public class ProductController {

    ProductServiceImpl productService = new ProductServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Product> products = productService.getProducts();

        return ResponseEntity.ok(products);
    }
}
