package br.com.excaladashboard.services;

import br.com.excaladashboard.models.Campanha;
import br.com.excaladashboard.models.Conjunto;
import br.com.excaladashboard.repositories.ConjuntoRepository;
import br.com.excaladashboard.services.facebook.UtilsService;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.AdsInsights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConjuntoService {

    @Autowired
    private ConjuntoRepository conjuntoRepository;

    @Autowired
    private UtilsService utilsService;

    public Map<Conjunto, AdSet> salvarConjuntos(Campanha campanha, Map<AdSet, AdsInsights> conjuntoMap) {
        Map<Conjunto, AdSet> conjuntos = new HashMap<>();

        Map<String, Conjunto> conjuntosMapDeHoje = this.getConjuntosMapDeHoje(campanha);
        for (Map.Entry<AdSet, AdsInsights> entry : conjuntoMap.entrySet()) {
            Conjunto conjuntoDeHoje = conjuntosMapDeHoje.get(entry.getKey().getId());
            if (conjuntoDeHoje != null) {
                conjuntos.put(this.salvarConjunto(conjuntoDeHoje, entry.getKey(), entry.getValue()), entry.getKey());
            } else {
                conjuntos.put(this.salvarConjunto(campanha, entry.getKey(), entry.getValue()), entry.getKey());
            }
        }
        return conjuntos;
    }

    public Conjunto salvarConjunto(Conjunto conjunto, AdSet adSet, AdsInsights insights) {
        conjunto.setNome(adSet.getFieldName());
        conjunto.setData(new Date());
        conjunto.setIdExterno(adSet.getId());
        if (insights != null) {
            conjunto.setResultados(Long.valueOf(this.utilsService.getValueFromAction(insights.getFieldActions())));
            conjunto.setCustoPorResultado(Double.valueOf(this.utilsService.getValueFromAction(insights.getFieldCostPerActionType())));
            conjunto.setValorGasto(Double.valueOf(insights.getFieldSpend()));
        }
        return this.conjuntoRepository.save(conjunto);
    }

    public Conjunto salvarConjunto(Campanha campanha, AdSet adSet, AdsInsights insights) {
        Conjunto conjunto = new Conjunto();
        conjunto.setCampanha(campanha);
        conjunto.setNome(adSet.getFieldName());
        conjunto.setData(new Date());
        conjunto.setIdExterno(adSet.getId());
        if (insights != null) {
            conjunto.setResultados(Long.valueOf(this.utilsService.getValueFromAction(insights.getFieldActions())));
            conjunto.setCustoPorResultado(Double.valueOf(this.utilsService.getValueFromAction(insights.getFieldCostPerActionType())));
            conjunto.setValorGasto(Double.valueOf(insights.getFieldSpend()));
        }

        return this.conjuntoRepository.save(conjunto);
    }

    private Map<String, Conjunto> getConjuntosMapDeHoje(Campanha campanha) {
        List<Conjunto> conjuntosDeHoje =
                this.conjuntoRepository.buscarCampanhaPorAccountIdEData(campanha.getIdExterno(), new Date());

        return conjuntosDeHoje.stream()
                .collect(Collectors.toMap(Conjunto::getIdExterno, conjunto -> conjunto));
    }
}
