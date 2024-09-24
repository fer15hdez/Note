package cursoSpringBoot.service;

import cursoSpringBoot.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public ProductResponseDTO createResponseDtoProduct( ProductRecordDto productDto ) {
        var product = productMapper.toProduct(productDto);
        var saveProduct = productRepository.save(product); // Inserta el producto en la bd.

        return productMapper.toProductResponseDTO(saveProduct);
    }

    public Product createDtoProduct(ProductRecordDto productRecordDto) {
        var product = this.productMapper.toProduct(productRecordDto);

        return this.productRepository.save(product);

    }

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

    public List<Product> findAllProductsByName( String name){
        return this.productRepository.findAllByNameContaining(name);
    }

    public void deleteProduct( Integer id ){
        this.productRepository.deleteById(id);
    }
}
