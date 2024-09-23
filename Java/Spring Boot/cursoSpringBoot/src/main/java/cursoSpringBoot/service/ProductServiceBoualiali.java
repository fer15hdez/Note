package cursoSpringBoot.service;

import cursoSpringBoot.domain.Product;
import cursoSpringBoot.domain.ProductRecordDto;
import cursoSpringBoot.domain.ProductRepository;
import cursoSpringBoot.domain.ProductResponseDTO;
import org.springframework.stereotype.Service;

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

    public ProductRecordDto createDtoProduct(Product productRecordDto) {
        
    }
}
