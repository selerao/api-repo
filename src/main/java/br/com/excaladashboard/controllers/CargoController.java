package br.com.excaladashboard.controllers;

import br.com.excaladashboard.models.Cargo;
import br.com.excaladashboard.services.AnuncioService;
import br.com.excaladashboard.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping("/cargos")
    public List<Cargo> listarCargos() {
        return cargoService.findAllCargos();
    }

    @PostMapping("/cargos")
    public ResponseEntity<?> criarCargo(@RequestBody Cargo cargo) {
        cargoService.saveCargo(cargo);
        return ResponseEntity.ok().build();
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