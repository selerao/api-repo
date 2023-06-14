package br.com.excaladashboard.controllers;

import br.com.excaladashboard.models.Produto;
import br.com.excaladashboard.services.ProdutoService;
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
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return produtoService.findAllProduto();
    }

    @PostMapping("/produtos")
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto) {
        produtoService.saveProduto(produto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Produto produto = produtoService.saveProduto(produtoAtualizado);
        if (produto != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id) {
        produtoService.deleteProdutoById(id);

        return ResponseEntity.ok().build();

    }




}
