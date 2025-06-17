package utez.edu.mx.u3_04_hra.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "cedes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clave; // Generar como C[id]-[ddMMyyyy]-[XXXX]

    private String estado;

    private String municipio;

    @OneToMany(mappedBy = "cede")
    private List<Almacen> almacenes;

    
}

