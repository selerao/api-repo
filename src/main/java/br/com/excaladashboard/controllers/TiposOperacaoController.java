package br.com.excaladashboard.controllers;

import br.com.excaladashboard.models.TiposOperacao;
import br.com.excaladashboard.services.ProdutoService;
import br.com.excaladashboard.services.TipoOperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TiposOperacaoController {

    @Autowired
    private TipoOperacaoService tipooperacaoService;

    @GetMapping("/tipooperacaos")
    public List<TiposOperacao> listarTiposOperacaos() {
        return tipooperacaoService.findAllTiposOperacao();
    }

    @PostMapping("/tipooperacaos")
    public ResponseEntity<?> criarTiposOperacao(@RequestBody TiposOperacao tipooperacao) {
        tipooperacaoService.saveTiposOperacao(tipooperacao);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/tipooperacaos/{id}")
    public ResponseEntity<?> atualizarTiposOperacao(@PathVariable Long id, @RequestBody TiposOperacao tipooperacaoAtualizado) {
        TiposOperacao tipooperacao = tipooperacaoService.saveTiposOperacao(tipooperacaoAtualizado);
        if (tipooperacao != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/tipooperacaos/{id}")
    public ResponseEntity<?> excluirTiposOperacao(@PathVariable Long id) {
        tipooperacaoService.deleteTiposOperacaoById(id);

        return ResponseEntity.ok().build();

    }


}
