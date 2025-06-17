package utez.edu.mx.u3_04_hra.service.almacen;

import utez.edu.mx.u3_04_hra.model.Almacen;

import java.util.List;
import java.util.Optional;

public interface IAlmacenService {
    List<Almacen> findAll();
    Optional<Almacen> findById(Long id);
    Almacen save(Almacen almacen);
    Almacen update(Long id, Almacen almacen);
    boolean delete(Long id);
}
