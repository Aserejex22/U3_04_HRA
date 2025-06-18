package utez.edu.mx.u3_04_hra.service.almacen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_hra.model.Almacen;
import utez.edu.mx.u3_04_hra.model.Cede;
import utez.edu.mx.u3_04_hra.model.Cliente;
import utez.edu.mx.u3_04_hra.repository.AlmacenRepository;
import utez.edu.mx.u3_04_hra.repository.CedeRepository;
import utez.edu.mx.u3_04_hra.repository.ClienteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlmacenServiceImpl implements IAlmacenService {

    @Autowired
    private AlmacenRepository almacenRepository;

    @Autowired
    private CedeRepository cedeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Almacen> findAll() {
        return almacenRepository.findAll();
    }

    @Override
    public Optional<Almacen> findById(Long id) {
        return almacenRepository.findById(id);
    }

    // ...existing code...
    @Override
    public Almacen save(Almacen almacen) {
        Cede cede = cedeRepository.findById(almacen.getCede().getId())
                .orElseThrow(() -> new RuntimeException("Cede no encontrada"));

        Cliente cliente = null;
        if (almacen.getCliente() != null && almacen.getCliente().getId() != null) {
            cliente = clienteRepository.findById(almacen.getCliente().getId())
                    .orElse(null);
        }

        almacen.setCede(cede);
        almacen.setCliente(cliente); // <-- Aquí se asigna el cliente recuperado
        almacen.setFechaRegistro(LocalDate.now());
        Almacen almacenGuardado = almacenRepository.save(almacen);
        String clave = cede.getClave() + "-A" + almacenGuardado.getId();
        almacenGuardado.setClave(clave);
        return almacenRepository.save(almacenGuardado);
    }
    // ...existing code...

    @Override
    public Almacen update(Long id, Almacen almacen) {
        if (!almacenRepository.existsById(id))
            return null;

        almacen.setId(id);
        return almacenRepository.save(almacen);
    }

    @Override
    public boolean delete(Long id) {
        if (!almacenRepository.existsById(id))
            return false;
        almacenRepository.deleteById(id);
        return true;
    }
}
