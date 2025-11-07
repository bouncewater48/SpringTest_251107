package com.bounce.springtest.lifecycle.test;

public class ScoreController {

    String subject;
    int score;

    public ScoreController(String subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    @Override
    public String toString() {
        return subject + ": " + score;
    }

    public String getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }

}
