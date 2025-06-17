package utez.edu.mx.u3_04_hra.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlmacenDto {
    private Long id;
    private String clave;
    private LocalDate fechaRegistro;
    private double precioVenta;
    private double precioRenta;
    private String tamaño;
    private String claveCede;
    private String nombreCliente;
}
