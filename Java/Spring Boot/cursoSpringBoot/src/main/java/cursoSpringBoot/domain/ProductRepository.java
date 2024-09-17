package cursoSpringBoot.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Se le pasa a JpaRepository<Name_entity, data_type_pk>
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Creando consultas

    List<Product> findAllByNameContaining(String name);
}
