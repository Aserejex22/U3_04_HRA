package utez.edu.mx.u3_04_hra.service.cede;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_hra.model.Cede;
import utez.edu.mx.u3_04_hra.repository.CedeRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CedeServiceImpl implements ICedeService {

    @Autowired
    private CedeRepository repository;

    @Override
    public List<Cede> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Cede> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Cede save(Cede cede) {
        cede.setClave(generarClaveCede());
        return repository.save(cede);
    }

    @Override
    public Cede update(Long id, Cede cede) {
        if (!repository.existsById(id))
            return null;
        cede.setId(id);
        return repository.save(cede);
    }

    @Override
    public boolean delete(Long id) {
        if (!repository.existsById(id))
            return false;
        repository.deleteById(id);
        return true;
    }

    private String generarClaveCede() {
        String fecha = new SimpleDateFormat("ddMMyyyy").format(new Date());
        int aleatorio = new Random().nextInt(9000) + 1000; // 4 dígitos
        return "C" + System.currentTimeMillis() % 1000 + "-" + fecha + "-" + aleatorio;
    }
}
