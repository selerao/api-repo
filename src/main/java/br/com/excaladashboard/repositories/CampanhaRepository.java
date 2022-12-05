package br.com.excaladashboard.repositories;

import br.com.excaladashboard.models.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

    @Query(value = "SELECT c FROM Campanha c " +
            "WHERE c.idExterno = :idExterno AND " +
            "c.data = :data")
    Campanha buscarCampanhaPorAccountIdEData(@Param("idExterno") String idExterno, @Param("data") Date data);

}
