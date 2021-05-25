package com.example.demo.shared.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class TrainingDto implements Serializable {

    private static final long serialVersionUID = 4786565683488085501L;

    private int id;
    private String title;
    private String trainingId;
    private Calendar tr_date;
    private String team_name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Calendar getTr_date() {
        return tr_date;
    }

    public void setTr_date(Calendar tr_date) {
        this.tr_date = tr_date;
    }

}
