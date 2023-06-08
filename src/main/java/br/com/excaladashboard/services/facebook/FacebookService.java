package br.com.excaladashboard.services.facebook;

import br.com.excaladashboard.models.Anuncio;
import br.com.excaladashboard.models.Campanha;
import br.com.excaladashboard.models.Conjunto;
import br.com.excaladashboard.models.Conta;
import br.com.excaladashboard.services.AnuncioService;
import br.com.excaladashboard.services.CampanhaService;
import br.com.excaladashboard.services.ConjuntoService;
import br.com.excaladashboard.services.ContaService;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.Campaign;
import org.hibernate.graph.Graph;
import org.hibernate.graph.internal.RootGraphImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacebookService {

    private static final Logger LOG = LoggerFactory.getLogger(FacebookService.class);

    @Autowired
    private FacebookConnection facebookConnection;

    @Autowired
    private CampanhaService campanhaService;

    @Autowired
    private ConjuntoService conjuntoService;

    @Autowired
    private AnuncioService anuncioService;

    @Autowired
    private ContaService contaService;

    public APINodeList<Campaign> getCampaings() {
        AdAccount adAccount = this.getAdAccount();
        List<Campaign.EnumEffectiveStatus> statuses = new ArrayList<>();
        statuses.add(Campaign.EnumEffectiveStatus.VALUE_ACTIVE);
//        statuses.add(Campaign.EnumEffectiveStatus.VALUE_IN_PROCESS);
        try {
            return adAccount.getCampaigns().setEffectiveStatus(statuses).requestNameField().execute();
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }

    private AdAccount getAdAccount() {
        AdAccount adAccount = this.facebookConnection.getAdAccountFromConta();
        Conta conta = this.contaService.buscarConta(adAccount.getId());
        if (conta == null) {
            this.contaService.salvarContaPorAccount(adAccount);
        }
        return adAccount;
    }

    public void atualizarDados() {
        APINodeList<Campaign> campaigns = this.getCampaings();
        AdsInsights.EnumDatePreset datePreset = AdsInsights.EnumDatePreset.VALUE_MAXIMUM;

        for (Campaign campaign : campaigns) {
            this.atualizarPorCampanha(campaign, datePreset);
        }
    }

    private void atualizarPorCampanha(Campaign campaign, AdsInsights.EnumDatePreset datePreset) {
        LOG.info("Campanha: {}", campaign.getFieldName());
        APINodeList<AdsInsights> campaignInsights = this.getInsightsFromCampaign(campaign,
                datePreset);

        Campanha campanha = this.campanhaService.salvarCampanha(this.getAdAccount().getId(), campaign, campaignInsights.head());

        APINodeList<AdSet> adSets = this.getAdSets(campaign);
        Map<AdSet, AdsInsights> conjuntoMap = this.getConjuntoMap(adSets, datePreset);

        Map<Conjunto, AdSet> conjuntos = this.conjuntoService.salvarConjuntos(campanha, conjuntoMap);


        for (Map.Entry<Conjunto, AdSet> entry : conjuntos.entrySet()) {
            APINodeList<Ad> ads = this.getAds(entry.getValue());
            Map<Ad, AdsInsights> anuncioMap = this.getAnuncioMap(ads, datePreset);
            Map<Anuncio, Ad> anuncios = this.anuncioService.salvarAnuncios(entry.getKey(), anuncioMap);
        }
    }

    private Map<Ad, AdsInsights> getAnuncioMap(APINodeList<Ad> anuncios, AdsInsights.EnumDatePreset datePreset) {
        Map<Ad, AdsInsights> anuncioMap = new HashMap<>();
        List<String> fields = new ArrayList<>();
        fields.add("clicks");
        fields.add("cpc");
        fields.add("ctr");
        fields.add("cpm");
        fields.add("frequency");
        fields.add("cost_per_action_type");
        fields.add("actions");
        fields.add("spend");

        try {
            for (Ad anuncio : anuncios) {
                anuncioMap.put(anuncio, anuncio.getInsights()
                        .requestFields(fields)
                        .setDatePreset(datePreset)
                        .execute()
                        .head());
            }
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
        return anuncioMap;
    }

    private Map<AdSet, AdsInsights> getConjuntoMap(APINodeList<AdSet> conjuntos,
                                                   AdsInsights.EnumDatePreset datePreset) {
        Map<AdSet, AdsInsights> conjuntoMap = new HashMap<>();
        List<String> fields = new ArrayList<>();
        fields.add("clicks");
        fields.add("cpc");
        fields.add("ctr");
        fields.add("cpm");
        fields.add("frequency");
        fields.add("cost_per_action_type");
        fields.add("actions");
        fields.add("spend");

        try {
            for (AdSet conjunto : conjuntos) {
                conjuntoMap.put(conjunto, conjunto.getInsights()
                        .requestFields(fields)
                        .setDatePreset(datePreset)
                        .execute()
                        .head());
            }
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
        return conjuntoMap;
    }

    private APINodeList<AdSet> getAdSets(Campaign campaign) {
        try {
            return campaign.getAdSets().requestNameField().execute();
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }

    private APINodeList<Ad> getAds(AdSet adSet) {
        try {
            return adSet.getAds().requestNameField().execute();
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }

    private APINodeList<AdsInsights> getInsightsFromCampaign(Campaign campaign, AdsInsights.EnumDatePreset datePreset) {
        List<String> fields = new ArrayList<>();
        fields.add("clicks");
        fields.add("cpc");
        fields.add("ctr");
        fields.add("cpm");
        fields.add("frequency");
        fields.add("cost_per_action_type");
        fields.add("actions");
        fields.add("spend");

        try {
            return campaign.getInsights()
                    .requestFields(fields)
                    .setDatePreset(datePreset)
                    .execute();
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }

}
