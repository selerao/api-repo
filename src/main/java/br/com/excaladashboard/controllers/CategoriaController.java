package br.com.excaladashboard.controllers;

import br.com.excaladashboard.models.Categoria;
import br.com.excaladashboard.services.CategoriaService;
import br.com.excaladashboard.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<Categoria> listarCategorias() {
        return categoriaService.findAllCategoria();
    }

    @PostMapping("/categorias")
    public ResponseEntity<?> criarCategoria(@RequestBody Categoria categoria) {
        categoriaService.saveCategoria(categoria);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<?> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaAtualizado) {
        Categoria categoria = categoriaService.saveCategoria(categoriaAtualizado);
        if (categoria != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> excluirCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoriaById(id);

        return ResponseEntity.ok().build(); 
    }


}


