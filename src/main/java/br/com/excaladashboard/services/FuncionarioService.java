package br.com.excaladashboard.services;

import br.com.excaladashboard.models.Funcionario;
import br.com.excaladashboard.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> findAllFuncionario() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> findFuncionarioById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public void deleteFuncionarioById(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
