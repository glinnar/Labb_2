package com.labb_2.Labb_2;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Playerlist strikerList = new Playerlist();
    private static Playerlist myFavStrikerList = new Playerlist();

    public static void main(String[] args) {


        boolean listON = false;
        int coice;
        while (!listON) {
            showMenu();
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
                    break;

                case 3:

                    System.out.println("Uppdatera Spelare");
                    updateStriker();
                    break;

                case 4:

                    System.out.println("Tar bort Spelare.");
                    removeStriker();
                    break;

                case 5:
                    System.out.println("Söker efter spelare");
                    searchStriker();


                    break;

                case 6:
                    addNewFavouriteStriker();

                    break;

                case 7:
                    myFavStrikerList.sortFavourite();

                    break;

                case 8:
                    System.out.println("Tar bort spelare ur favoritlistan.");
                    removieFavourite();
                    break;

                case 9:
                    System.out.println("Stänger lista.");
                    listON = true;

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


        if (strikerList.addStriker(newStriker)) {
            System.out.println("Ny anfallare tillagd: Namn: " + strikerName + "| " +
                    "land: " + countryName + "| " + "Klubb: " + teamName +
                    " |" + " Position:" + position + ", Rating: " + rating +
                    "| " + " bästa fot: " + bestFoot
            );

        }

    }

    private static void addNewFavouriteStriker() {
        System.out.println("Lägger till i FavoritListan");
        String strikerName = scanner.nextLine();
        Striker listFavStriker = strikerList.searchStriker(strikerName);
        Striker newFavStriker = Striker.createStriker(listFavStriker.getName(), listFavStriker.getCountry(), listFavStriker.getTeamName(),
                listFavStriker.getPosition(), listFavStriker.getRating(), listFavStriker.getBestFoot());

        if (myFavStrikerList.addFavouriteStriker(newFavStriker)) {
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

                if (listfavStriker != null) {
                    Striker updatedFavStrikerTeam = Striker.createStriker(listfavStriker.getName(), listfavStriker.getCountry(), newTeamName,
                            listfavStriker.getPosition(), listfavStriker.getRating(), listfavStriker.getBestFoot());
                    myFavStrikerList.updateFavStriker(listfavStriker, updatedFavStrikerTeam);
                }

                if ((strikerList.updateStriker(listStriker, updatedStrikerTeam))) {
                    System.out.println("Spelarens klubb är uppdaterad");

                } else {
                    System.out.println("Gick inte att uppdatera");
                }

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
                    System.out.println("Spelarens rating är uppdaterad");
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
                    System.out.println("Spelarens land är uppdaterad");
                } else {
                    System.out.println("Gick inte att uppdatera");
                    break;

                }

        }


    }

    private static void removeStriker() {
        System.out.println("Skriv vilken spelare som du vill ta bort.");
        String strikerName = scanner.nextLine();
        Striker strikerInList = strikerList.searchStriker(strikerName);
        Striker favStrikerInList = myFavStrikerList.searchFavStriker(strikerName);
        if (strikerInList == null) {
            System.out.println("Spelaren finns inte.");
            return;
        }
        if (favStrikerInList != null) {
            myFavStrikerList.removeFavStriker(favStrikerInList);
        }

        if (strikerList.removeStriker(strikerInList)) {
            System.out.println("Spelaren har tagits bort.");
        } else {
            System.out.println("Kan inte ta bort spelaren.");
        }

    }

    private static void removieFavourite(){
        System.out.println("Skriv vilken spelare som du vill ta bort.");
        String strikerName = scanner.nextLine();
        Striker favStrikerInList = myFavStrikerList.searchFavStriker(strikerName);
        if (favStrikerInList == null) {
            System.out.println("Spelaren finns inte.");
            return;
        }

        if (myFavStrikerList.removeFavStriker(favStrikerInList)) {
            System.out.println("Spelaren har tagits bort.");
        } else {
            System.out.println("Kan inte ta bort spelaren.");
        }

    }

    private static void searchStriker() {
        System.out.println("Vilken spelare letar du efter?");
        String strikerName = scanner.nextLine();
        Striker strikerInList = strikerList.searchStriker(strikerName);
        if (strikerInList == null) {
            System.out.println("Spelaren finns inte.");
        } else {
            System.out.println("Name: " + strikerInList.getName() + " Land: " +
                    strikerInList.getCountry() + " Klubb: " + strikerInList.getTeamName() +
                    " Postition: " + strikerInList.getPosition() + " Rating: " + strikerInList.getRating() +
                    " Bästa fot: " + strikerInList.getBestFoot()
            );
        }


    }

    private static void showMenu() {
        System.out.println("Gör ett val:");
        System.out.println("1.Visa spelarlista." +
                " \n2.Lägg till ny spelare. " +
                "\n3.Uppdatera spelare." +
                "\n4.Tar bort spelare. " +
                "\n5.Sök efter spelare." +
                "\n6.Spara spelare i favoriter." +
                "\n7.Visa favoriter." +
                "\n8.Tar bort spelare ur favoriter." +
                "\n9.Stänger ner listan.");
    }


}
