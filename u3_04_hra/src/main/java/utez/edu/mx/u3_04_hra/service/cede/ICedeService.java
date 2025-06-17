package utez.edu.mx.u3_04_hra.service.cede;

import utez.edu.mx.u3_04_hra.model.Cede;

import java.util.List;
import java.util.Optional;

public interface ICedeService {
    List<Cede> findAll();
    Optional<Cede> findById(Long id);
    Cede save(Cede cede);
    Cede update(Long id, Cede cede);
    boolean delete(Long id);
}
