package br.com.excaladashboard.services.facebook;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnection {

    private final String accessToken;

    private final Long accountId;

    private final String appSecret;

    @Autowired
    public FacebookConnection(@Value("${FB_ACCESS_TOKEN}") String accessToken,
                              @Value("${FB_ACCOUNT_ID}") Long accountId,
                              @Value("${FB_APP_SECRET}") String appSecret) {
        this.accessToken = accessToken;
        this.accountId = accountId;
        this.appSecret = appSecret;
    }

    public AdAccount getAdAccount() {
        APIContext context = new APIContext(this.accessToken, this.appSecret);
        return new AdAccount(this.accountId, context);
    }

}
