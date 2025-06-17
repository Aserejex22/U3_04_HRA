package utez.edu.mx.u3_04_hra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.mx.u3_04_hra.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
