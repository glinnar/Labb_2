package com.labb_2.Labb_2;

import java.util.ArrayList;
import java.util.Comparator;

public class Playerlist {
    private ArrayList<Striker> strikers;
    private ArrayList<Striker> favStrikers;

    public Playerlist() {
        this.strikers = new ArrayList<>();
        this.favStrikers = new ArrayList<>();
    }

    public void listStriker() {
        System.out.println("ANFALLARE ______");
        System.out.println(" Namn " + " | " + " Land" + " | " + " KLubb " + " | "
                + " Position " + " | " + " Rating " + " | " + " Bästa fot ");

        System.out.println("___________________________________________" +
                "___________________");
        for (int i = 0; i < this.strikers.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.strikers.get(i).getName() + " | " +
                    this.strikers.get(i).getCountry() + " | " +
                    this.strikers.get(i).getTeamName() + " | " +
                    this.strikers.get(i).getPosition() + " | " +
                    this.strikers.get(i).getRating() + " | " +
                    this.strikers.get(i).getBestFoot()
            );

            System.out.println("___________________________________________" +
                    "___________________");

        }


    }

    public boolean addStriker(Striker striker) {
        if (getStriker(striker.getName()) >= 0) {
            System.out.println("Spelaren finns redan i listan");
            return false;
        }
        strikers.add(striker);
        return true;


    }
    // Hämta existenande element i första listan och lägga till i nya listan.

    private int getStriker(String strikerName) {
        for (int i = 0; i < this.strikers.size(); i++) {
            Striker striker = this.strikers.get(i);
            if (striker.getName().equals(strikerName)) {
                return i;
            }
        }
        return -1;
    }

    private int getFAvStriker(Striker favstriker) {
        return this.favStrikers.indexOf(favstriker);
    }

    private int getFavStriker(String strikerName) {
        for (int i = 0; i < this.favStrikers.size(); i++) {
            Striker favStriker = this.favStrikers.get(i);
            if (favStriker.getName().equals(strikerName)) {
                return i;
            }
        }
        return -1;
    }

    private int getStriker(Striker striker) {
        return this.strikers.indexOf(striker);
    }

    public boolean updateStriker(Striker striker, Striker upDatedStriker) {
        int listPosition = getStriker(striker);
        if (listPosition < 0) {
            System.out.println(striker.getName() + ",finns inte i listan");
            return false;
        }
        this.strikers.set(listPosition, upDatedStriker);

        System.out.println(striker.getName() + ", har uppdaterats");
        return true;

    }
    public boolean updateFavStriker(Striker striker, Striker upDatedStriker) {

        int favlistPosition = getFAvStriker(striker);
        if (favlistPosition < 0) {
            System.out.println(striker.getName() + ",finns inte i listan");
            return false;
        }
        this.favStrikers.set(favlistPosition,upDatedStriker);
        return true;

    }


    public boolean removeStriker(Striker striker) {
        int listPosition = getStriker(striker);
        if (listPosition < 0) {
            System.out.println(striker.getName() + " finns inte i listan");
            return false;
        }
        this.strikers.remove(listPosition);
        System.out.println(striker.getName() + " har tagits bort");
        return true;
    }


    public String searchStriker(Striker striker) {
        if (getStriker(striker) >= 0) {
            return striker.getName();
        }
        return null;
    }

    public Striker searchStriker(String strikerName) {
        int listPosition = getStriker(strikerName);
        if (listPosition >= 0) {
            return this.strikers.get(listPosition);
        }
        return null;
    }

    public String searchFavStriker(Striker striker) {
        if (getStriker(striker) >= 0) {
            return striker.getName();
        }
        return null;
    }

    public Striker searchFavStriker(String strikerName) {
        int listPosition = getFavStriker(strikerName);
        if (listPosition >= 0) {
            return this.favStrikers.get(listPosition);
        }
        return null;
    }
    static final Comparator<Striker> RATING_ORDER = new Comparator<Striker>() {
        @Override
        public int compare(Striker o1, Striker o2) {
            return o1.getRating() - o2.getRating();
        }
    };




    public void printFavourite() {


        System.out.println("FAVORITSPELARE ______");
        System.out.println(" Namn " + " | " + " Land" + " | " + " KLubb " + " | "
                + " Position " + " | " + " Rating " + " | " + " Bästa fot ");

        System.out.println("___________________________________________" +
                "___________________");
        for (int i = 0; i < this.favStrikers.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.favStrikers.get(i).getName() + " | " +
                    this.favStrikers.get(i).getCountry() + " | " +
                    this.favStrikers.get(i).getTeamName() + " | " +
                    this.favStrikers.get(i).getPosition() + " | " +
                    this.favStrikers.get(i).getRating() + " | " +
                    this.favStrikers.get(i).getBestFoot()
            );

            System.out.println("___________________________________________" +
                    "___________________");
        }


    }

    public boolean addFavouiteStriker(Striker striker){
        if (getStriker(striker.getName()) >= 0) {
            System.out.println("Spelaren finns redan i listan");
            return false;
        }
        favStrikers.add(striker);
        return true;


    }




    @Override
    public String toString() {
        return String.valueOf(favStrikers);
    }

}




