package utez.edu.mx.u3_04_hra.service.cliente;

import utez.edu.mx.u3_04_hra.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    Cliente update(Long id, Cliente cliente);
    boolean delete(Long id);
}
