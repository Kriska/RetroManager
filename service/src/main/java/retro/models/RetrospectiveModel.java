/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retro.models;

/**
 *
 * @author C50117A
 */
public class RetrospectiveModel {
    
    private String userName;
    private String sprintWeather;
    private String didWell;
    private String wentWrong;
    private String doDifferently;
    private String outOfTeamControl;
        
    public RetrospectiveModel() {
        //No-op
    } 
    
    public String getSprintWeather() {
        return sprintWeather;
    }

    public void setSprintWeather(String sprintWeather) {
        this.sprintWeather = sprintWeather;
    }

    public String getDidWell() {
        return didWell;
    }

    public void setDidWell(String didWell) {
        this.didWell = didWell;
    }

    public String getWentWrong() {
        return wentWrong;
    }

    public void setWentWrong(String wentWrong) {
        this.wentWrong = wentWrong;
    }

    public String getDoDifferently() {
        return doDifferently;
    }

    public void setDoDifferently(String doDifferently) {
        this.doDifferently = doDifferently;
    }

    public String getOutOfTeamControl() {
        return outOfTeamControl;
    }

    public void setOutOfTeamControl(String outOfTeamControl) {
        this.outOfTeamControl = outOfTeamControl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "RetrospectiveModel{" + "userName=" + userName + ", sprintWeather=" + sprintWeather + ", didWell=" + didWell + ", wentWrong=" + wentWrong + ", doDifferently=" + doDifferently + ", outOfTeamControl=" + outOfTeamControl + '}';
    }
}
