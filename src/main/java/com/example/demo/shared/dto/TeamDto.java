package com.example.demo.shared.dto;


import java.io.Serializable;
import java.util.Date;

public class TeamDto implements Serializable {


    private static final long serialVersionUID = -108928020969024294L;
    private int id;
    private String teamId;
    private int nb_players;
    private String label;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getNb_players() {
        return nb_players;
    }

    public void setNb_players(int nb_players) { this.nb_players = nb_players;}

    public String getLabel() { return label;}

    public void setLabel(String label) { this.label = label;}
}
