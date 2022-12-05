package br.com.excaladashboard.repositories;

import br.com.excaladashboard.models.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    @Query(value = "SELECT c FROM Anuncio c " +
            "WHERE c.conjunto.idExterno = :conjuntoId AND " +
            "c.data = :data")
    List<Anuncio> buscarAnuncioPorConjuntoEData(@Param("conjuntoId") String conjuntoId, @Param("data") Date data);
}
