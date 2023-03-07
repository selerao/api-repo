package br.com.excaladashboard.services;

import br.com.excaladashboard.models.Cargo;
import br.com.excaladashboard.models.Categoria;
import br.com.excaladashboard.repositories.CategoriaRepository;
import br.com.excaladashboard.services.facebook.UtilsService;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdsInsights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAllCategoria() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    public void deleteCategoriaById(Long id) {
        categoriaRepository.deleteById(id);
    }
}



