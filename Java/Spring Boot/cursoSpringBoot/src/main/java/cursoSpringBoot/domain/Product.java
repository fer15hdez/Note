package cursoSpringBoot.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "T_PRODUCT") // Permite definir un nombre para la tabla. Sino se define la anotacion el nombre que adopta
// es el nombre de la clase (ej. Product). El valor de la propiedad "ddl-auto: update" esta en la configuracion del proyecto
// creara una nueva tabla, si es create solo se sobre escribe.
public class Product {

    @JsonProperty("id")
    @Id
    @GeneratedValue // Solo se debe usar en Primary Key. Genera el valor incremental.
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
    @Column(updatable = false)
    private String some_colum;

    //Relacion uno a uno
    @OneToOne(mappedBy = "product" // Este valor debe ser igual al campo de la entidad de la relacion.
            //cascade = CascadeType.ALL
    )
    private Images images;

    @ManyToOne
    // En esta relacion siempre debe estar la notacion @JoinColumn para definir el campo
    // que identifica la relacion.
    @JoinColumn(name = "category_id") // Esta es la columna que se crea en la tabla
    // para hacer refencia al campo "category".
    @JsonBackReference // Evita que se cree un loop entre la entidad padre-hijo (Category-Product).
    // Se debe poner la anotacion @JsonManagedReference en el campo (category) de Product que crea el link.
    private Category category;



    public Product() {
    }

    public Product(Integer id, String name, Double price, Integer stock, String some_colum) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.some_colum = some_colum;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getSome_colum() {
        return some_colum;
    }

    public void setSome_colum(String some_colum) {
        this.some_colum = some_colum;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
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
