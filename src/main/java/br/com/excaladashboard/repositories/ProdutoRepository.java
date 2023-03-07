package br.com.excaladashboard.repositories;

import br.com.excaladashboard.models.Cliente;
import br.com.excaladashboard.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}