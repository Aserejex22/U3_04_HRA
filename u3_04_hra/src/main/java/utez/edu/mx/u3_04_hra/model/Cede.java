package utez.edu.mx.u3_04_hra.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private List<Almacen> almacenes;

    
}

