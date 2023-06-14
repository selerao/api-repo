package br.com.excaladashboard.controllers;

import br.com.excaladashboard.models.Campanha;
import br.com.excaladashboard.services.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/campanhas")
public class CampanhaController {

    @Autowired
    private CampanhaService campanhaService;

    @GetMapping
    public ResponseEntity<List<Campanha>> buscarTodasCampanhas(@RequestParam("accountId") String accountId) {
        List<Campanha> campanhas = this.campanhaService.findCampanhaPorConta(accountId);
        if (campanhas == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(campanhas);
    }
}
