package br.com.excaladashboard;

import br.com.excaladashboard.services.facebook.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private FacebookService facebookService;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void run(String... args) throws Exception {

    }
}
