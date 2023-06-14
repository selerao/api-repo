package br.com.excaladashboard.services;

import br.com.excaladashboard.models.Cargo;
import br.com.excaladashboard.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public Cargo saveCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public List<Cargo> findAllCargos() {
        return cargoRepository.findAll();
    }

    public Optional<Cargo> findCargoById(Long id) {
        return cargoRepository.findById(id);
    }

    public void deleteCargoById(Long id) {
        cargoRepository.deleteById(id);
    }
}