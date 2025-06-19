package utez.edu.mx.u3_04_hra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.u3_04_hra.model.Almacen;
import utez.edu.mx.u3_04_hra.model.Cliente;
import utez.edu.mx.u3_04_hra.service.almacen.IAlmacenService;
import utez.edu.mx.u3_04_hra.service.cliente.IClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/almacenes")
@CrossOrigin(origins = "*")
public class AlmacenController {

    @Autowired
    private IAlmacenService service;

    @Autowired
    private IClienteService clienteService; // Asegúrate de tener este servicio

    @PutMapping("/{id}/asignar-cliente/{clienteId}")
    public ResponseEntity<Almacen> asignarCliente(
            @PathVariable Long id,
            @PathVariable Long clienteId) {
        Almacen almacen = service.findById(id).orElse(null);
        if (almacen == null)
            return ResponseEntity.notFound().build();
        Cliente cliente = clienteService.findById(clienteId).orElse(null);
        if (cliente == null)
            return ResponseEntity.badRequest().build();
        almacen.setCliente(cliente);
        return ResponseEntity.ok(service.save(almacen));
    }

    @GetMapping("/")

    public ResponseEntity<List<Almacen>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Almacen> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Almacen> create(@RequestBody Almacen almacen) {
        return ResponseEntity.ok(service.save(almacen));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Almacen> update(@PathVariable Long id, @RequestBody Almacen almacen) {
        Almacen updated = service.update(id, almacen);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
