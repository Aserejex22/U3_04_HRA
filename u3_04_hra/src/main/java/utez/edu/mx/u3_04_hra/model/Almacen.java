package utez.edu.mx.u3_04_hra.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "almacenes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clave; // Se genera con base en la clave de la cede

    private LocalDate fechaRegistro;

    private double precioVenta;
    private double precioRenta;

    private String tamaño; // G, M o P

    @ManyToOne
    @JoinColumn(name = "cede_id")
    private Cede cede;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;  // null si el almacén no está rentado o comprado

}
