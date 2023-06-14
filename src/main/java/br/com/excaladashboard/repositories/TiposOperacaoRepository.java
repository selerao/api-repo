package br.com.excaladashboard.repositories;

import br.com.excaladashboard.models.TiposOperacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposOperacaoRepository extends JpaRepository<TiposOperacao, Long> {

}
