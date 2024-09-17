package cursoSpringBoot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "T_PRODUCT") // Permite definir un nombre para la tabla. Sino se define la anotacion el nombre que adopta
// es el nombre de la clase (ej. Product). El valor de la propiedad "ddl-auto: update" esta en la configuracion del proyecto
// creara una nueva tabla, si es create solo se sobre escribe.
public class Product {

    @JsonProperty("id")
    @Id
    @GeneratedValue // Solo se debe usar en Primary Key.
    private Integer id;

    @Column(unique = true) // Configura el campo como un valor unico dentro de la BD.
    private Integer serial;
    @JsonProperty("c-name") //Permite crear un valor personalizado para la deserialization. Este valor
    //es el que se debe enviar desde el cliente. Is case sensitive
    @Column(
            name = "c_name", // Define el nombre del campo en la DB. Sino se define se toma como valor el  nombre del campo.
            length = 20 // define el numero de caracteres que va a tener el campo
    )
    private String name;
    @JsonProperty("c-price")
    private Double price;
    @JsonProperty("c-stock")
    private Integer stock;
    @Column(
            updatable = false
    )
    private String some_colum;

    public Product() {
    }

    public Product(Integer id, String name, Double price, Integer stock, String some_colum) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.some_colum = some_colum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
