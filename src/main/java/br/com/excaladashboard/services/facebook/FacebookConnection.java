package br.com.excaladashboard.services.facebook;

import com.facebook.ads.sdk.APIContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnection {

    @Value("${FB_ACCESS_TOKEN}")
    public String ACCESS_TOKEN;
    @Value("${FB_ACCOUNT_ID}")
    public Long ACCOUNT_ID;
    @Value("${FB_APP_SECRET}")
    public String APP_SECRET;

    public APIContext criaContextoAPI() {
        System.out.println(ACCOUNT_ID);
        System.out.println(APP_SECRET);
        return new APIContext(ACCESS_TOKEN, APP_SECRET);
    }

}
