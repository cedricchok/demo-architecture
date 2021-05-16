package com.example.demo.models.response;

import java.util.Calendar;


public class TrainingRest {

    private String trainingId;
    private Calendar tr_date;
    private String team_name;
    private String title;

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public Calendar getTr_date() {
        return tr_date;
    }

    public void setTr_date(Calendar tr_date) {
        this.tr_date = tr_date;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
