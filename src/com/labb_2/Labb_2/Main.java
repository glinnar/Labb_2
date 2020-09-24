package com.labb_2.Labb_2;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Playerlist strikerList = new Playerlist();
    private static Playerlist myFavStrikerList = new Playerlist();

    public static void main(String[] args) {


        boolean listON = false;
        int coice;
        int val;
        while (!listON) {
            System.out.println("Hej vänligen skriv in ett val:");
            coice = scanner.nextInt();
            scanner.nextLine();
            switch (coice) {
                case 1:

                    strikerList.listStriker();
                    break;

                case 2:
                     System.out.println("Vänligen skriv in uppgifterna");
                    addNewStriker();
                    strikerList.listStriker();
                    System.out.println("Vill du även spara spelaren i din favoritlista?");
                    System.out.println("1. Ja");
                    System.out.println("2. Nej");

                    val = scanner.nextInt();
                    if(val == 1){
                        addNewFavouriteStriker();
                    } else if(val == 2){
                        System.out.println("Spelaren sparas inte i favoritlistan");
                    }
                    break;

                case 3:

                    System.out.println("Uppdatera Spelare");
                    updateStriker();
                    break;

                case 4:

                    System.out.println("Hur gött då?");
                    myFavStrikerList.printFavourite();
                    break;

                case 5:
                    addNewFavouriteStriker();
                    System.out.println("Alltid lika gött");


                    break;

                case 6:

                    System.out.println("Stänger lista.");
                    listON = true;
                    break;

                case 7:

                    /*
                    Collections.sort(myFavStrikerList,Playerlist.RATING_ORDER);
                    printList(myFavStrikerList);
                    
                     */

                    break;


                default:
                    System.out.println("Inget val gjort");
                    break;
            }

        }


    }

    private static void addNewStriker() {
        System.out.print("Skriv in namnet på anfallaren: ");
        String strikerName = scanner.nextLine();
        System.out.print("Skriv in vilket land spelaren kommer ifrån: ");
        String countryName = scanner.nextLine();
        System.out.print("Skriv in vilket klubb som spelaren tillhör: ");
        String teamName = scanner.nextLine();
        System.out.print("Skriv in vilken position spelare har: ");
        String position = scanner.nextLine();
        int rating = (int) (Math.random() * 100);
        if (rating == 0) {
            rating = 1;
        }

        System.out.print("Skriv in vilken fot som är spelarens bästa: ");
        String bestFoot = scanner.nextLine();

        Striker newStriker = new Striker(strikerName, countryName, teamName, position, rating, bestFoot);
         /*Striker newStriker = new Striker(
                 "Gurra","Sverige","Chelsa","Höger Forward"
                 ,rating,"Vänster"); */


        if (strikerList.addStriker(newStriker)) {
            System.out.println("Ny anfallare tillagd: Namn: " + strikerName + "| " +
                    "land: " + countryName + "| " + "Klubb: " + teamName +
                    " |" + " Position:" + position + ", Rating: " + rating +
                    "| " + " bästa fot: " + bestFoot
            );
            //System.out.println("Nu Striker tillagd");
        }

    }

    // Undersök fall det går att hämta uppdateringen från update metoden.
    // Eller lägga den i samma uppdateringsmetod så att den uppdateras samtidigt.
    private static void addNewFavouriteStriker() {
        System.out.println("Lägger till i FavoritListan");
        String strikerName = scanner.nextLine();
        Striker listFavStriker = strikerList.searchStriker(strikerName);
        Striker newFavStriker = Striker.createStriker(listFavStriker.getName(), listFavStriker.getCountry(), listFavStriker.getTeamName(),
                listFavStriker.getPosition(), listFavStriker.getRating(), listFavStriker.getBestFoot());

        if (myFavStrikerList.addFavouiteStriker(newFavStriker)) {
            System.out.println("Ny anfallare tillagd: Namn: " + strikerName + "| " +
                    "land: " + listFavStriker.getCountry() + "| " + "Klubb: " + listFavStriker.getTeamName() +
                    " |" + " Position:" + listFavStriker.getPosition() + ", Rating: " + listFavStriker.getRating() +
                    "| " + " bästa fot: " + listFavStriker.getBestFoot()
            );


        }
    }

    private static void updateStriker() {

        System.out.println("Skriv in vilken anfallare som skall uppdateras: ");
        String strikerName = scanner.nextLine();
        Striker listStriker = strikerList.searchStriker(strikerName);
        Striker listfavStriker = myFavStrikerList.searchFavStriker(strikerName);
        // Fixa uppdatering på favstriker.
        if (listStriker == null) {
            System.out.println("Anfallaren finns inte.");
            return;
        }


        System.out.println("Välj vad som skall uppdateras");
        System.out.println("1. Uppdatera Klubb");
        System.out.println("2. Uppdatera Rating");
        System.out.println("3. Uppdatera Land");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();

        switch (updateChoice) {
            case 1:

                System.out.println("Skriv in ny klubb för spelaren");
                String newTeamName = scanner.nextLine();
                Striker updatedStrikerTeam = Striker.createStriker(listStriker.getName(), listStriker.getCountry(), newTeamName,
                        listStriker.getPosition(), listStriker.getRating(), listStriker.getBestFoot());
                // Fixa resterande 2 metoderna som man skall uppdatera
                if (listfavStriker != null) {
                    Striker updatedFavStrikerTeam = Striker.createStriker(listfavStriker.getName(), listfavStriker.getCountry(), newTeamName,
                            listfavStriker.getPosition(), listfavStriker.getRating(), listfavStriker.getBestFoot());
                    myFavStrikerList.updateFavStriker(listfavStriker, updatedFavStrikerTeam);
                }

                if ((strikerList.updateStriker(listStriker, updatedStrikerTeam))) {
                    System.out.println("Informationen är uppdaterad");

                } else {
                    System.out.println("Gick inte att uppdatera");
                }


                // lägg till sök och remove metoder i main imorgon.
                break;

            case 2:
                System.out.println("Uppdatera spelarens Rating");
                int newRating = (int) (Math.random() * 100);
                Striker updatedStrikerRating = Striker.createStriker(listStriker.getName(), listStriker.getCountry(), listStriker.getTeamName(),
                        listStriker.getPosition(), newRating, listStriker.getBestFoot());

                if (listfavStriker != null) {
                    Striker updatedFavStrikerRating = Striker.createStriker(listfavStriker.getName(), listfavStriker.getCountry(), listfavStriker.getTeamName(),
                            listfavStriker.getPosition(), newRating, listfavStriker.getBestFoot());
                    myFavStrikerList.updateFavStriker(listfavStriker, updatedFavStrikerRating);
                }

                if (strikerList.updateStriker(listStriker, updatedStrikerRating)) {
                    System.out.println("Spelarens rating  är uppdaterad");
                } else {
                    System.out.println("Gick inte att uppdatera");
                }
                break;

            case 3:
                System.out.println("Skriv in nytt land för spelaren");
                String newCountry = scanner.nextLine();
                Striker updatedStrikerCountry = Striker.createStriker(listStriker.getName(), newCountry, listStriker.getTeamName(),
                        listStriker.getPosition(), listStriker.getRating(), listStriker.getBestFoot());

                if (listfavStriker != null) {
                    Striker updatedFavStrikerCountry = Striker.createStriker(listfavStriker.getName(), newCountry, listfavStriker.getTeamName(),
                            listfavStriker.getPosition(), listfavStriker.getRating(), listfavStriker.getBestFoot());
                    myFavStrikerList.updateFavStriker(listfavStriker, updatedFavStrikerCountry);
                }
                if (strikerList.updateStriker(listStriker, updatedStrikerCountry)) {
                    System.out.println("Spelarens rating  är uppdaterad");
                } else {
                    System.out.println("Gick inte att uppdatera");
                    break;

                }

        }


    }



}
