package br.com.excaladashboard.services.facebook;

import com.facebook.ads.sdk.AdsActionStats;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UtilsService {

    public String getValueFromAction(List<AdsActionStats> actions) {
        if (actions == null) {
            return "0";
        }
        String actionValue = null;
        String nonActionValue = "0";
        for (AdsActionStats action : actions) {
            if (Objects.equals(action.getFieldActionType(), "lead")) {
                actionValue = action.getFieldValue();
                break;
            } else if (Objects.equals(action.getFieldActionType(), "link_click")) {
                actionValue = action.getFieldValue();
            } else if (Objects.equals(action.getFieldActionType(), "video_view")) {
                nonActionValue = action.getFieldValue();
            }
        }
        return actionValue != null ? actionValue : nonActionValue;
    }
}
