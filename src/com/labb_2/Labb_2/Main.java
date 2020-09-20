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
            System.out.println("Hej vänligen skriv in ett val:");
            coice = scanner.nextInt();
            scanner.nextLine();
            switch (coice) {
                case 1:

                    strikerList.listStriker();
                    break;

                case 2:

                    addNewStriker();
                    break;

                case 3:

                    System.out.println("Uppdatera kontakts");
                    updateStriker();
                    break;

                case 4:

                    System.out.println("Hur gött då?");
                    break;

                case 5:

                    System.out.println("Alltid lika gött");
                    break;

                case 6:

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
        System.out.print("Skriv in vilket land anfallaren komemr ifrån: ");
        String countryName = scanner.nextLine();
        System.out.print("Skriv in vilket klubb som spelaren tillhör: ");
        String teamName = scanner.nextLine();
        System.out.print("Skriv in vilken position spelare har: ");
        String position = scanner.nextLine();
        int rating = (int) (Math.random() * 100);
        if (rating == 0) {
            rating = 1;
        }
        System.out.print("Vilken fot är spelarens bästa?: ");
        String bestFoot = scanner.nextLine();

        Striker newStriker = new Striker(strikerName, countryName, teamName, position, rating, bestFoot);
         /*Striker newStriker = new Striker(
                 "Gurra","Sverige","Chelsa","Höger Forward"
                 ,rating,"Vänster");

                 */
        if (strikerList.addStriker(newStriker)) {
            System.out.println("Ny anfallare tillagd: Namn: " + strikerName + "| " +
                    "land: " + countryName + "| " + "Klubb: " + teamName +
                    " |" + " Position:" + position + ", Rating: " + rating +
                    "| " + " bästa fot: " + bestFoot
            );
        }

    }

    private static void updateStriker(){

        System.out.println("Skriv in vilken anfallare som skall uppdateras: ");
        String strikerName = scanner.nextLine();
        Striker listStriker = strikerList.searchStriker(strikerName);
        if(listStriker == null){
            System.out.println("Anfallaren finns inte.");
            return;
        }
        System.out.println("Välj vad som skall uppdateras");
        System.out.println("1. Updatera Klubb");
        System.out.println("2. Uppdatera Rating");
        System.out.println("3. Uppdatera Land");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();

        switch (updateChoice){
            case 1:
                System.out.println("Skriv in ny klubb för Anfallaren");
                String newTeamName = scanner.nextLine();
                Striker updatedStriker = Striker.createStriker();
                if(strikerList.updateStriker(listStriker,updatedStriker)){
                    System.out.println("Informationen är uppdaterad");
                }else {
                    System.out.println("Gick inte att uppdatera");
                }

                // testa att göra likadant på de andra två alternativen
                // Hur kan vi uppdatera enskilda element i listan?

                // lägg till sök och remove metoder i main imorgon.
                break;

            case 2:
                System.out.println("Tjenna");
                break;

            case 3:
                System.out.println("Yooo");
                break;

        }

    }




}
