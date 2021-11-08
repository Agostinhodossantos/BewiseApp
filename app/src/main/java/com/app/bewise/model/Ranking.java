package com.app.bewise.model;

public class Ranking {
    private int score, position;
    private String name;


    public Ranking(int score, int position, String name) {
        this.score = score;
        this.position = position;
        this.name = name;
    }

    public Ranking() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
