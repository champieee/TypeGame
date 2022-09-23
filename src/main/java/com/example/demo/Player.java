package com.example.demo;

public class Player {
    int score;

    public void setScore(int seconds) {
        score = seconds;
    }

    public int getScore() {
        return score;
    }

    public String returnWinner (int one, int two) {
        if (one < two) {
            return "Player one wins";
        } else if (two < one) {
            return "Player two wins";
        } else {
            return "Draw!";
        }
    }
}
