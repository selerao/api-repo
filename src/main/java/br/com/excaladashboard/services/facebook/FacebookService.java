package br.com.excaladashboard.services.facebook;

import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacebookService {

    @Autowired
    private FacebookConnection facebookConnection;

    public APINodeList<Campaign> getCampaings() {
        AdAccount adAccount = this.facebookConnection.getAdAccount();
        adAccount.getAdCreatives().requestAllFields().execute().get(0);
        try {
            return adAccount.getCampaigns().requestNameField().execute();
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }

    public APINodeList<AdsInsights> getInsights(Campaign campaign, AdsInsights.EnumDatePreset datePreset) {
        List<String> fields = new ArrayList<>();
        fields.add("clicks");
        fields.add("cpc");
        fields.add("ctr");
        fields.add("cpm");
        fields.add("frequency");
        fields.add("cost_per_action_type");
        fields.add("actions");
        fields.add("spend");

        APINodeList<AdsInsights> adsInsights;
        try {
            adsInsights = campaign.getInsights()
                    .requestFields(fields)
                    .setDatePreset(datePreset)
                    .execute();
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
        return adsInsights;
    }

}
