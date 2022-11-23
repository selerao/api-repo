package br.com.excaladashboard.services.facebook;

import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacebookService {

    @Autowired
    private FacebookConnection facebookConnection;

    public APINodeList<Campaign> getCampaings() {
        AdAccount adAccount = this.facebookConnection.getAdAccount();
        try {
            return adAccount.getCampaigns().requestNameField().execute();
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }

}
