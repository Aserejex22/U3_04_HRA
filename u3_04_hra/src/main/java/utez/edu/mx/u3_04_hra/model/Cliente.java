package utez.edu.mx.u3_04_hra.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;

    private String telefono;

    private String correo;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Almacen> almacenes;

}
