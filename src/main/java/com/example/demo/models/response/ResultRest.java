package com.example.demo.models.response;

public class ResultRest {
    private String resultId;
    private int score_t1;
    private int score_t2;

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public int getScore_t1() {
        return score_t1;
    }

    public void setScore_t1(int score_t1) {
        this.score_t1 = score_t1;
    }

    public int getScore_t2() {
        return score_t2;
    }

    public void setScore_t2(int score_t2) {
        this.score_t2 = score_t2;
    }
}
