package cursoSpringBoot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Truck extends Vehicle{

    private int capacityLoad; // capacidadCarga
    private int quantityAxes; //  cantidadEjes

}
