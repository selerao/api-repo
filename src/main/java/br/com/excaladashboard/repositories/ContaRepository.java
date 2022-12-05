package br.com.excaladashboard.repositories;

import br.com.excaladashboard.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query(value = "select c from Conta c where c.accountId = :accountId")
    Conta buscarContaPorAccountId(@Param("accountId") String accountId);
}
