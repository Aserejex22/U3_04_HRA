package utez.edu.mx.u3_04_hra.service.almacen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_hra.model.Almacen;
import utez.edu.mx.u3_04_hra.repository.AlmacenRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlmacenServiceImpl implements IAlmacenService {

    @Autowired
    private AlmacenRepository repository;

    @Override
    public List<Almacen> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Almacen> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Almacen save(Almacen almacen) {
        if (almacen.getCede() != null && almacen.getCede().getClave() != null) {
            String clave = almacen.getCede().getClave() + "-A" + System.currentTimeMillis() % 10000;
            almacen.setClave(clave);
        }
        almacen.setFechaRegistro(LocalDate.now());
        return repository.save(almacen);
    }

    @Override
    public Almacen update(Long id, Almacen almacen) {
        if (!repository.existsById(id))
            return null;
        almacen.setId(id);
        return repository.save(almacen);
    }

    @Override
    public boolean delete(Long id) {
        if (!repository.existsById(id))
            return false;
        repository.deleteById(id);
        return true;
    }
}
