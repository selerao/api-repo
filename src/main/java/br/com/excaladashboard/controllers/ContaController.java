package br.com.excaladashboard.controllers;

import br.com.excaladashboard.services.ConjuntoService;
import br.com.excaladashboard.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {

    @Autowired
    private ContaService contaService;{

    }

}
