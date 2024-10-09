package cursoSpringBoot.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private Long orderNumber;
    private LocalDateTime orderDate;
    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = { @JoinColumn(name = "order_id")},/* Define la columna dentro de la tabla de union de la
                                                                tabla duenna */
            inverseJoinColumns = { @JoinColumn(name = "product_id")} /* Define la columna de la otra tabla en la relacion
                                                                        en la tabla de union.*/
    )
    private List<Product> products;
}
