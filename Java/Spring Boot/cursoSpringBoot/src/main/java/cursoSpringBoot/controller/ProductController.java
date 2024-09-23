package cursoSpringBoot.controller;

import cursoSpringBoot.domain.*;
import cursoSpringBoot.service.ProductMapper;
import cursoSpringBoot.service.ProductService;
import cursoSpringBoot.service.ProductServiceBoualiali;
import cursoSpringBoot.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos") // This is the prefix to all the url on this class.
public class ProductController {

    private final ProductServiceBoualiali productServiceBoualiali;


    //ProductService productService = new ProductServiceImpl();
    // @Autowired // Esta anotacion es la encargada de crear la injeccion de dependencia.
    private ProductService  productService;
    private ProductServiceImpl productServiceImp;

    public ProductController(ProductServiceBoualiali productServiceBoualiali) {
        this.productServiceBoualiali = productServiceBoualiali;
    }


    @PostMapping("/db/dto")
    public Product createDtoProduct(@RequestBody ProductRecordDto productDto){

        return this.productServiceBoualiali.createDtoProduct(productDto); // Inserta el producto en la bd.
    }

    @PostMapping("/db/dto/response")
    public ProductResponseDTO createDtoResponseProduct( // Una vez creada la entidad permite solo devolver los datos deseados.
            @RequestBody ProductRecordDto productDto
    ){
        return this.productServiceBoualiali.createResponseDtoProduct(productDto); // Inserta el producto en la bd.
    }

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Product> products = productServiceImp.getProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{tell-story}")
    public String tellStoryService(@PathVariable("tell-story") String tellStory) {
        return "My tell story value: "  + tellStory;
    }

    @PostMapping("/db")
    public Product createProduct(
            @RequestBody Product product
    ){
        return productRepository.save(product); // Inserta el producto en la bd.

    }

    @GetMapping("/db/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return productRepository.findById(id)
                .orElse(null);
    }

    @GetMapping("/db")
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/db/search/{name}")
    public List<Product> findAllProductsByName(@PathVariable("name") String name){
        return productRepository.findAllByNameContaining(name);
    }

    @DeleteMapping("/db/del/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(
            @PathVariable("id") Integer id
    ){
        productRepository.deleteById(id);
    }


}
