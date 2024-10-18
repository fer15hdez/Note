package cursoSpringBoot.domain.Specification;

import cursoSpringBoot.domain.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    // Se puede usar con una lambda expression
    public static Specification<Product> hasStock(int stock){
        return (
                Root<Product> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (stock < 0) {
                return null;
            }
            return builder.equal(root.get("stock"), stock); // "stock" en root.get("stock") debe ser igual al campo 'stock'
                                                            // en la clase Product
        };
    }

    public static Specification<Product> nameLike(String name){
        return (
                Root<Product> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (name == null) {
                return null;
            }
            return builder.like(root.get("name"), name);
        };
    }
}
