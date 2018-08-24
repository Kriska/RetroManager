
package retro.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author C50117A
 */
public class RetrospectiveSummaryModel {

    private Map<String, Integer> sprintWeatherSummary;
    private List<String> didWellSummary;
    private List<String> wentWrongSummary;
    private List<String> doDifferentlySummary;
    private List<String> outOfTeamControlSummary;
    
    public RetrospectiveSummaryModel() {
        //No-op
    }

    public Map<String, Integer> getSprintWeatherSummary() {
        return sprintWeatherSummary;
    }

    public void setSprintWeatherSummary(Map<String, Integer> sprintWeatherList) {
        this.sprintWeatherSummary = sprintWeatherList;
    }

    public List<String> getDidWellSummary() {
        return didWellSummary;
    }

    public void setDidWellSummary(List<String> didWellList) {
        this.didWellSummary = didWellList;
    }

    public List<String> getWentWrongSummary() {
        return wentWrongSummary;
    }

    public void setWentWrongSummary(List<String> wentWrongList) {
        this.wentWrongSummary = wentWrongList;
    }

    public List<String> getDoDifferentlySummary() {
        return doDifferentlySummary;
    }

    public void setDoDifferentlySummary(List<String> doDifferentlyList) {
        this.doDifferentlySummary = doDifferentlyList;
    }

    public List<String> getOutOfTeamControlSummary() {
        return outOfTeamControlSummary;
    }

    public void setOutOfTeamControlSummary(List<String> outOfTeamControlList) {
        this.outOfTeamControlSummary = outOfTeamControlList;
    }
    
    public void addToSprintWeather(String sprintWeather) {
        if (sprintWeatherSummary == null) {
            sprintWeatherSummary = new HashMap<>();
        }
        
        Integer value = sprintWeatherSummary.get(sprintWeather);
        if (value != null) {
            value += 1;
        } else {
            value = 1;
        }
        this.sprintWeatherSummary.put(sprintWeather, value);
    }
    
    public void addToDidWell(String didWell) {
        if (didWellSummary == null) {
            didWellSummary = new ArrayList<>();
        }
        this.didWellSummary.add(didWell);
    }
    
    public void addToWentWrong(String wentWrong) {
        if (wentWrongSummary == null) {
            wentWrongSummary = new ArrayList<>();
        }
        this.wentWrongSummary.add(wentWrong);
    }
    
    public void addToDoDifferently(String doDifferently) {
        if (doDifferentlySummary == null) {
            doDifferentlySummary = new ArrayList<>();
        }
        this.doDifferentlySummary.add(doDifferently);
    }
    
    public void addToOutOfTeamControl(String outOfTeamControl) {
        if (outOfTeamControlSummary == null) {
            outOfTeamControlSummary = new ArrayList<>();
        }
        this.outOfTeamControlSummary.add(outOfTeamControl);
    }
}
