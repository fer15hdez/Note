package cursoSpringBoot.controller;

import cursoSpringBoot.domain.*;
import cursoSpringBoot.service.ProductMapper;
import cursoSpringBoot.service.ProductService;
import cursoSpringBoot.service.ProductServiceBoualiali;
import cursoSpringBoot.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public Product createDtoProduct(@Valid @RequestBody ProductRecordDto productRecordDto){

        return this.productServiceBoualiali.createDtoProduct(productRecordDto); // Inserta el producto en la bd.
    }

    @PostMapping("/db/dto/response")
    public ProductResponseDTO createDtoResponseProduct( // Una vez creada la entidad permite solo devolver los datos deseados.
            @RequestBody ProductRecordDto productDto
    ){
        return this.productServiceBoualiali.createResponseDtoProduct(productDto); // Inserta el producto en la bd.
    }

 /*   @GetMapping("/start/with/{name}")
    public List<Product> startNameWith(@PathVariable("name") String name){
        return this.productServiceBoualiali.findAllProductsStartWith(name);
    }*/

    @GetMapping
    // Signo ? permite devolver cualquier tipo clase.
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
        return this.productServiceBoualiali.createProduct(product); // Inserta el producto en la bd.

    }

    @GetMapping("/db/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return this.productServiceBoualiali.getProduct(id);
    }

    @GetMapping("/db")
    public List<ProductResponseDTO> findAllProducts(){
        return this.productServiceBoualiali.findAllProducts();
    }
 /*   @GetMapping("/db/search/{name}")
    public List<Product> findAllProductsByName(@PathVariable("name") String name){
        return this.productServiceBoualiali.findAllProductsByName(name);
    }*/

    @DeleteMapping("/db/del/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(
            @PathVariable("id") Integer id
    ){
        this.productServiceBoualiali.deleteProduct(id);
    }

    // Este metodo maneja las excepciones del controlador.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException (
            MethodArgumentNotValidException  exp
    ) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError)error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);

                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
