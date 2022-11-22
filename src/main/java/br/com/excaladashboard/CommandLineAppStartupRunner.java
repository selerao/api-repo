package br.com.excaladashboard;

import br.com.excaladashboard.models.Conta;
import br.com.excaladashboard.models.FacebookData;
import br.com.excaladashboard.services.facebook.FacebookConnection;
import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private FacebookConnection facebookConnection;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void run(String... args) throws Exception {
        APIContext context = facebookConnection.criaContextoAPI();
        AdAccount adAccount = new AdAccount(facebookConnection.ACCOUNT_ID, context);
        Conta conta = new Conta();
        conta.setEmail("selerao@email.com");
        this.em.persist(conta);
        try {
            APINodeList<Campaign> campaigns = adAccount.getCampaigns()
                    .requestNameField()
                    .execute();

            List<String> insightsFieldsName = new ArrayList<>();
            insightsFieldsName.add("impressions");
            insightsFieldsName.add("clicks");
            insightsFieldsName.add("cpc");

            for (Campaign campaign : campaigns) {
                FacebookData facebookData = new FacebookData();
                facebookData.setConta(conta);
                APINodeList<AdsInsights> adsInsights = campaign.getInsights()
                        .requestFields(insightsFieldsName)
                        .execute();
                System.out.println("Campanha: " + campaign.getFieldName());
                for (AdsInsights adsInsight : adsInsights) {
                    System.out.println("impressions: " + adsInsight.getFieldImpressions());
                    System.out.println("clicks: " + adsInsight.getFieldClicks());
                    System.out.println("cpc: " + adsInsight.getFieldCpc());
                    facebookData.setCpc(Double.valueOf(adsInsight.getFieldCpc()));
                }
                System.out.println("========================================");
                facebookData.setCampanha(campaign.getFieldName());
                this.em.persist(facebookData);
            }
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }
}
