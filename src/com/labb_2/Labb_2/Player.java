package com.labb_2.Labb_2;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String country;
    private String teamName;
    private String position;

    public Player(){

    }


    public Player(String name, String country, String teamName, String position) {
        this.name = name;
        this.country = country;
        this.teamName = teamName;
        this.position = position;
    }

    public Player(String teamName) {
        this.teamName = teamName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
