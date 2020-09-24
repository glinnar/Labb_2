package com.labb_2.Labb_2;

public class Striker extends Player {
    private int rating;
    private String bestFoot;


    public Striker(String name, String country, String teamName, String position, int rating, String bestFoot) {
        super(name, country, teamName, position);
        this.rating = rating;
        this.bestFoot = bestFoot;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBestFoot() {
        return bestFoot;
    }

    public void setBestFoot(String bestFoot) {
        this.bestFoot = bestFoot;
    }

    public static Striker createStriker(String name, String country, String teamName, String position, int rating, String bestFoot) {
        return new Striker(name, country, teamName, position, rating, bestFoot);
    }



}
