package br.com.excaladashboard.services.jobs;

import br.com.excaladashboard.services.facebook.FacebookService;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdsActionStats;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.Campaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@EnableScheduling
public class FacebookScheduleJob {

    private static final String CRON = "0 * * * * *";

    private static final Logger LOG = LoggerFactory.getLogger(FacebookScheduleJob.class);

    @Autowired
    private FacebookService facebookService;

    @Scheduled(cron = CRON)
    public void executeJob() {
        // aqui deve ficar o serviço que popula os dados da API do facebook
        APINodeList<Campaign> campaigns = this.facebookService.getCampaings();
        for (Campaign campaign : campaigns) {
            LOG.info("Campanha: {}", campaign.getFieldName());
            APINodeList<AdsInsights> insights =
                    this.facebookService.getInsights(campaign, AdsInsights.EnumDatePreset.VALUE_MAXIMUM);
            if (insights.size() == 1) {
                AdsInsights insight = insights.get(0);
                LOG.info("clicks: {}", insight.getFieldClicks());
                LOG.info("cpc: {}", insight.getFieldCpc());
                LOG.info("cpm: {}", insight.getFieldCpm());
                LOG.info("frequency: {}", insight.getFieldFrequency());
                LOG.info("spend: {}", insight.getFieldSpend());

                String costPerAction = this.getValueFromAction(insight.getFieldCostPerActionType());
                LOG.info("cost_per_action_type: {}", costPerAction);

                String resultados = this.getValueFromAction(insight.getFieldActions());
                LOG.info("resultados: {}", resultados);
                LOG.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            }
        }

    }

    private String getValueFromAction(List<AdsActionStats> actions) {
        String actionValue = "";
        for (AdsActionStats action : actions) {
            if (Objects.equals(action.getFieldActionType(), "lead")) {
                actionValue = action.getFieldValue();
                break;
            } else if (Objects.equals(action.getFieldActionType(), "link_click")) {
                actionValue = action.getFieldValue();
            }
        }
        return actionValue;
    }

}
