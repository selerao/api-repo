package br.com.excaladashboard.services;

import br.com.excaladashboard.models.Campanha;
import br.com.excaladashboard.models.Conta;
import br.com.excaladashboard.repositories.CampanhaRepository;
import br.com.excaladashboard.services.facebook.UtilsService;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    @Autowired
    private ContaService contaService;

    @Autowired
    private UtilsService utilsService;

    public Campanha salvarCampanha(String accountId, Campaign campaign, AdsInsights insights) {
        Conta conta = this.contaService.buscarConta(accountId);
        Campanha campanha = this.getCampanhaDoDia(campaign);
        if (campanha == null) {
            campanha = new Campanha();
        }
        campanha.setConta(conta);
        campanha.setData(new Date());
        campanha.setIdExterno(campaign.getId());
        campanha.setNome(campaign.getFieldName());
        if (insights != null) {
            campanha.setClicks(Long.valueOf(insights.getFieldClicks() != null ? insights.getFieldClicks() : "0"));
            campanha.setCtr(Double.valueOf(insights.getFieldCtr() != null ? insights.getFieldCtr() : "0"));
            campanha.setCpc(Double.valueOf(insights.getFieldCpc() != null ? insights.getFieldCpc() : "0"));
            campanha.setCpm(Double.valueOf(insights.getFieldCpm() != null ? insights.getFieldCpm() : "0"));
            campanha.setFrequencia(Double.valueOf(insights.getFieldFrequency() != null ? insights.getFieldFrequency() : "0"));
            campanha.setCustoMedioLead(Double.valueOf(this.utilsService.getValueFromAction(insights.getFieldCostPerActionType())));
            campanha.setResultados(Long.valueOf(this.utilsService.getValueFromAction(insights.getFieldActions())));
        }

        conta.getCampanhas().add(campanha);

        return this.campanhaRepository.save(campanha);
    }

    public Campanha getCampanhaDoDia(Campaign campaign) {
        return this.campanhaRepository.buscarCampanhaPorAccountIdEData(campaign.getId(), new Date());
    }

}
