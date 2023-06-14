package br.com.excaladashboard.controllers;

import br.com.excaladashboard.models.Cargo;
import br.com.excaladashboard.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600, allowedHeaders = "*")
@RestController
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping("/cargos/{id}")
    public ResponseEntity<Cargo> buscarCargoPorId(@PathVariable Long id) {
        Optional<Cargo> cargo = this.cargoService.findCargoById(id);
        return ResponseEntity.of(cargo);
    }

    @GetMapping("/cargos")
    public List<Cargo> listarCargos() {
        return cargoService.findAllCargos();
    }

    @PostMapping("/cargos")
    public ResponseEntity<?> criarCargo(@RequestBody Cargo cargo) throws URISyntaxException {
        Cargo persistedCargo = this.cargoService.saveCargo(cargo);
        return ResponseEntity.ok(persistedCargo);
    }

    @PutMapping("/cargos/{id}")
    public ResponseEntity<?> atualizarCargo(@PathVariable Long id, @RequestBody Cargo cargoAtualizado) {
        Cargo cargo = cargoService.saveCargo(cargoAtualizado);
        if (cargo != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/cargos/{id}")
    public ResponseEntity<?> excluirCargo(@PathVariable Long id) {
        cargoService.deleteCargoById(id);

        return ResponseEntity.ok().build();

    }

}