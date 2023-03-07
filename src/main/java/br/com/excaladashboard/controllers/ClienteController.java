package br.com.excaladashboard.controllers;

import br.com.excaladashboard.models.Cliente;
import br.com.excaladashboard.services.CategoriaService;
import br.com.excaladashboard.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return clienteService.findAllCliente();
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> criarCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = clienteService.saveCliente(clienteAtualizado);
        if (cliente != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> excluirCliente(@PathVariable Long id) {
        clienteService.deleteClienteById(id);

        return ResponseEntity.ok().build();

    }




}
