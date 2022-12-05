package br.com.excaladashboard.repositories;

import br.com.excaladashboard.models.Conjunto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConjuntoRepository extends JpaRepository<Conjunto, Long> {

    @Query(value = "SELECT c FROM Conjunto c " +
            "WHERE c.campanha.idExterno = :campanhaId AND " +
            "c.data = :data")
    List<Conjunto> buscarCampanhaPorAccountIdEData(@Param("campanhaId") String campanhaId, @Param("data") Date data);

}
