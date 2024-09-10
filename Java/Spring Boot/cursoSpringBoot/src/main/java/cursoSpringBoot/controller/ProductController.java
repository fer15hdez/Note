package cursoSpringBoot.controller;

import cursoSpringBoot.domain.Product;
import cursoSpringBoot.service.ProductService;
import cursoSpringBoot.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos") // This is the prefix to all the url on this class.
public class ProductController {

    //ProductService productService = new ProductServiceImpl();
    // @Autowired // Esta anotacion es la encargada de crear la injeccion de dependencia.
    private ProductService productService;
    private ProductServiceImpl productServiceImp;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Product> products = productService.getProducts();

        return ResponseEntity.ok(products);
    }

    public String tellStoryService() {
        return productServiceImp.tellStory();
    }
}
