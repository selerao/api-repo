package br.com.excaladashboard;

import br.com.excaladashboard.models.Campanha;
import br.com.excaladashboard.services.facebook.FacebookService;
import com.facebook.ads.sdk.AdsInsights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private FacebookService facebookService;

    @PersistenceContext
    private EntityManager em;

    @Override
   public void run(String... args) throws Exception {
//      //  AdAccount adAccount = this.facebookService.getAdAccount();
//        Conta conta = new Conta();
//        conta.setEmail("selerao@email.com");
//        this.em.persist(conta);
//        try {
//            APINodeList<Campaign> campaigns = adAccount.getCampaigns()
//                    .requestNameField()
//                    .execute();
//
//            List<String> insightsFieldsName = new ArrayList<>();
//            insightsFieldsName.add("impressions");
//            insightsFieldsName.add("clicks");
//            insightsFieldsName.add("cpc");
//            insightsFieldsName.add("ctr");
//            insightsFieldsName.add("cpm");
//            insightsFieldsName.add("frequency");
//            insightsFieldsName.add("account_name");
//            insightsFieldsName.add("cost_per_action_type");
//            insightsFieldsName.add("dda_results");
//            insightsFieldsName.add("spend");
//
//            for (Campaign campaign : campaigns) {
//                Campanha campanha = new Campanha();
//                campanha.setConta(conta);
//                APINodeList<AdsInsights> adsInsights = campaign.getInsights()
//                        .requestFields(insightsFieldsName)
//                        .execute();
//                System.out.println("Campanha: " + campaign.getFieldName());
//                for (AdsInsights adsInsight : adsInsights) {
//                    System.out.println("impressions: " + adsInsight.getFieldImpressions());
//                    System.out.println("clicks: " + adsInsight.getFieldClicks());
//                    System.out.println("cpc: " + adsInsight.getFieldCpc());
//                    System.out.println("cpm: " + adsInsight.getFieldCpm());
//                    System.out.println("frequency: " + adsInsight.getFieldFrequency());
//                    System.out.println("cost_per_action_type: " + adsInsight.getFieldCostPerActionType());
//                    System.out.println("ctr: " + adsInsight.getFieldCtr());
//                    System.out.println("dda_results: " + adsInsight.getFieldCostPerDdaCountbyConvs());
//                    System.out.println("spend: " + adsInsight.getFieldSpend());
//                    campanha.setCpc(Double.valueOf(adsInsight.getField()));
//                }
//                System.out.println("========================================");
//                campanha.setNome(campaign.getFieldName());
//                this.em.persist(campanha);
//            }
//        } catch (APIException e) {
//            throw new RuntimeException(e);
//        }
    }
}
