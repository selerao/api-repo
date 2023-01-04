package br.com.excaladashboard.controllers;

import br.com.excaladashboard.controllers.dto.CampanhaResponseJson;
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
    public ResponseEntity<String> buscarTodasCampanhas(@RequestParam("accountId") String accountId) {
        return ResponseEntity.ok("oi eu sou o gocu");
    }
}
