package br.com.excaladashboard;

import br.com.excaladashboard.models.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


@Service
@SpringBootApplication
public class ExcaladashboardApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExcaladashboardApplication.class, args);
        System.out.println("Heelloou");
        Cliente cliente = new Cliente();
        cliente.setEmpresa("Excala");

        System.out.println("nome da empresa: " + cliente.getEmpresa());
    }

}
