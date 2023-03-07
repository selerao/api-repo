package br.com.excaladashboard.services;

import br.com.excaladashboard.models.TiposOperacao;
import br.com.excaladashboard.repositories.TiposOperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoOperacaoService {

    @Autowired
    private TiposOperacaoRepository tipooperacaoRepository;


    public TiposOperacao saveTiposOperacao(TiposOperacao tipooperacao) {
        return tipooperacaoRepository.save(tipooperacao);
    }

    public List<TiposOperacao> findAllTiposOperacao() {
        return tipooperacaoRepository.findAll();
    }

    public Optional<TiposOperacao> findTiposOperacaoById(Long id) {
        return tipooperacaoRepository.findById(id);
    }

    public void deleteTiposOperacaoById(Long id) {
        tipooperacaoRepository.deleteById(id);
    }

}
