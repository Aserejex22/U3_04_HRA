package utez.edu.mx.u3_04_hra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.u3_04_hra.model.Cede;
import utez.edu.mx.u3_04_hra.service.cede.ICedeService;

import java.util.List;

@RestController
@RequestMapping("/api/cedes")
@CrossOrigin(origins = "*")
public class CedeController {

    @Autowired
    private ICedeService service;

    @GetMapping("/")
    public ResponseEntity<List<Cede>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cede> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Cede> create(@RequestBody Cede cede) {
        return ResponseEntity.ok(service.save(cede));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cede> update(@PathVariable Long id, @RequestBody Cede cede) {
        Cede updated = service.update(id, cede);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
