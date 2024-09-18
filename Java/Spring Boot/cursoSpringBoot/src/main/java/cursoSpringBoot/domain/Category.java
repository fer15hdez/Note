package cursoSpringBoot.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String description;
    @OneToMany(
            mappedBy = "category"
    )
    @JsonManagedReference // Evita que se cree un loop entre la entidad padre-hijo (Category-Product).
    // Se debe poner la anotacion @JsonBackReference en el campo (category) de Product que crea el link.
    private List<Product> products;

    public Category(String nombre, String description, List<Product> products) {
        this.nombre = nombre;
        this.description = description;
        this.products = products;
    }

    public Category(String nombre, String description) {
        this.nombre = nombre;
        this.description = description;
    }

    public Category() {
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}