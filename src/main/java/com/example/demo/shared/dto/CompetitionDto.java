package com.example.demo.shared.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
@Data
public class CompetitionDto implements Serializable{

    private static final long serialVersionUID = -4504495612230190370L; // why !
    private int id;
    private String competitionId;
    private Calendar cp_date;
    private String title;
}
