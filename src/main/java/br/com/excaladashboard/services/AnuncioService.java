package br.com.excaladashboard.services;

import br.com.excaladashboard.models.Anuncio;
import br.com.excaladashboard.models.Conjunto;
import br.com.excaladashboard.repositories.AnuncioRepository;
import br.com.excaladashboard.services.facebook.UtilsService;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdsInsights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private UtilsService utilsService;

    public Map<Anuncio, Ad> salvarAnuncios(Conjunto conjunto, Map<Ad, AdsInsights> anuncioMap) {
        Map<Anuncio, Ad> anuncios = new HashMap<>();

        Map<String, Anuncio> anunciosMapDeHoje = this.getAnunciosMapDeHoje(conjunto);
        for (Map.Entry<Ad, AdsInsights> entry : anuncioMap.entrySet()) {
            Anuncio anuncioDeHoje = anunciosMapDeHoje.get(entry.getKey().getId());
            if (anuncioDeHoje != null) {
                anuncios.put(this.salvarAnuncio(anuncioDeHoje, entry.getKey(), entry.getValue()), entry.getKey());
            } else {
                anuncios.put(this.salvarAnuncio(conjunto, entry.getKey(), entry.getValue()), entry.getKey());
            }
        }
        return anuncios;
    }

    public Anuncio salvarAnuncio(Conjunto conjunto, Ad ad, AdsInsights insights) {
        Anuncio anuncio = new Anuncio();
        anuncio.setConjunto(conjunto);
        anuncio.setNome(ad.getFieldName());
        anuncio.setData(new Date());
        anuncio.setIdExterno(ad.getId());

        if (insights != null) {
            anuncio.setResultados(Long.valueOf(this.utilsService.getValueFromAction(insights.getFieldActions())));
            anuncio.setCustoPorResultado(Double.valueOf(this.utilsService.getValueFromAction(insights.getFieldCostPerActionType())));
            anuncio.setValorGasto(Double.valueOf(insights.getFieldSpend()));
        }

        return this.anuncioRepository.save(anuncio);
    }

    public Anuncio salvarAnuncio(Anuncio anuncio, Ad ad, AdsInsights insights) {
        anuncio.setNome(ad.getFieldName());
        anuncio.setData(new Date());
        anuncio.setIdExterno(ad.getId());

        if (insights != null) {
            anuncio.setResultados(Long.valueOf(this.utilsService.getValueFromAction(insights.getFieldActions())));
            anuncio.setCustoPorResultado(Double.valueOf(this.utilsService.getValueFromAction(insights.getFieldCostPerActionType())));
            anuncio.setValorGasto(Double.valueOf(insights.getFieldSpend()));
        }

        return this.anuncioRepository.save(anuncio);
    }

    private Map<String, Anuncio> getAnunciosMapDeHoje(Conjunto conjunto) {
        List<Anuncio> anunciosDeHoje =
                this.anuncioRepository.buscarAnuncioPorConjuntoEData(conjunto.getIdExterno(), new Date());

        return anunciosDeHoje.stream()
                .collect(Collectors.toMap(Anuncio::getIdExterno, anuncio -> anuncio));
    }

}
