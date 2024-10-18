package cursoSpringBoot.service;

import cursoSpringBoot.domain.*;
import cursoSpringBoot.domain.Specification.ProductSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceBoualiali {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceBoualiali(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    /*public void createRandomProducts(){
        Faker faker = new Faker();
    }*/

    public ProductResponseDTO createResponseDtoProduct( ProductRecordDto productDto ) {
        var product = productMapper.toProduct(productDto);
        var saveProduct = productRepository.save(product); // Inserta el producto en la bd.

        return productMapper.toProductResponseDTO(saveProduct); // Convierte el Product guardado en el ProductResponseDTO.
    }

    // Crea el Product usando el patron DTO.
    public Product createDtoProduct(ProductRecordDto productRecordDto) {
        var product = this.productMapper.toProduct(productRecordDto);

        return this.productRepository.save(product);

    }

    // Crea el Product. Aqui no se hace uso del patron DTO.
    // Solo para ver su funcinamiento
    public Product createProduct( Product product ){
        return this.productRepository.save(product); // Inserta el producto en la bd.

    }

    public Product getProduct( Integer id) {
        return this.productRepository.findById(id)
                .orElse(null);
    }

    public List<ProductResponseDTO> findAllProducts() {
        return this.productRepository.
                findAll()
                .stream() // Aplica a cada elemento de la lista que devuelve
                .map(productMapper::toProductResponseDTO) // Convierte cada elemento a ProductResponseDTO
                .collect(Collectors.toList());

    }

/*    public List<Product> findAllProductsByName( String name){
        return this.productRepository.findAllByNameContaining(name);
    }
*/
    public List<Product> findAllProductsStartWith(String name){
        return this.productRepository.findAllByNameStartingWithIgnoreCase(name);
    }

    public void deleteProduct( Integer id ){
        this.productRepository.deleteById(id);
    }

    // Para hacer consultas complejas
    // Usando Specification tool
    public List<Product> findAllProductByNameAndStock(String name, Integer stock){
        Specification<Product> specification = Specification
                .where(ProductSpecification.hasStock(stock)) // Se llama a la clase ProductSpecification para usar las
                                                             // las consultas precredas.
                .or(ProductSpecification.nameLike(name)) // Se pueden usar varias consultas
                ;

        return productRepository.findAll(specification); // Recibe como parametro un Specification type o null
    }
}
