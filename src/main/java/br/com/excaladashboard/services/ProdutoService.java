package br.com.excaladashboard.services;

import br.com.excaladashboard.models.Produto;
import br.com.excaladashboard.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAllProduto() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public void deleteProdutoById(Long id) {
        produtoRepository.deleteById(id);
    }

}
