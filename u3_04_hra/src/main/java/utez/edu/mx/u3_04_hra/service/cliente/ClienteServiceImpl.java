package utez.edu.mx.u3_04_hra.service.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_hra.model.Cliente;
import utez.edu.mx.u3_04_hra.repository.ClienteRepository;

import utez.edu.mx.u3_04_hra.security.CryptoUtil;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

@Override
public Cliente save(Cliente cliente) {
    // Encriptar teléfono y correo antes de guardar
    cliente.setTelefono(CryptoUtil.encrypt(cliente.getTelefono()));
    cliente.setCorreo(CryptoUtil.encrypt(cliente.getCorreo()));
    return repository.save(cliente);
}

    @Override
public Cliente update(Long id, Cliente cliente) {
    if (!repository.existsById(id))
        return null;
    cliente.setId(id);
    // Encriptar antes de guardar
    cliente.setTelefono(CryptoUtil.encrypt(cliente.getTelefono()));
    cliente.setCorreo(CryptoUtil.encrypt(cliente.getCorreo()));
    return repository.save(cliente);
}

    @Override
    public boolean delete(Long id) {
        if (!repository.existsById(id))
            return false;
        repository.deleteById(id);
        return true;
    }
}
