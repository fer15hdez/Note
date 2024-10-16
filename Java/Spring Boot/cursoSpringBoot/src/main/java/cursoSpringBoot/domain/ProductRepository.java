package cursoSpringBoot.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Se le pasa a JpaRepository<Name_entity, data_type_pk>
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Creando consultas

    Product findByName(String name);
    List<Product> findAllByName(String name);
    List<Product> findAllByNameIgnoreCase(String name);

    List<Product> findAllByNameContaining(String name);

    // select * from Product where name like '%param%'
    // IgnoreCase: Indica que no tiene en cuenta las mayusculas y minusculas
    List<Product> findAllByNameContainingIgnoreCase(String name);

    // Select * from Product where name like 'start%'
    List<Product> findAllByNameStartingWithIgnoreCase(String name);

    // Select * from Product where name like '%end'
//    List<Product> findAllByNameEndWithIgnoreCase(String name);

    // Select * from Product where name in ('ali', 'buu', 'more')
//    List<Product> findAllByNameInIgnoreCase(List<String> names);
}
