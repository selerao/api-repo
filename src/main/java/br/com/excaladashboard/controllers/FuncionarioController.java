package br.com.excaladashboard.controllers;

import br.com.excaladashboard.models.Funcionario;
import br.com.excaladashboard.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.findAllFuncionario();
    }

    @PostMapping("/funcionarios")
    public ResponseEntity<?> criarFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioService.saveFuncionario(funcionario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<?> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioAtualizado) {
        Funcionario funcionario = funcionarioService.saveFuncionario(funcionarioAtualizado);
        if (funcionario != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<?> excluirFuncionario(@PathVariable Long id) {
        funcionarioService.deleteFuncionarioById(id);

        return ResponseEntity.ok().build();

    }


}
