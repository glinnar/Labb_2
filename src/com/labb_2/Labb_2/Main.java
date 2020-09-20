package com.labb_2.Labb_2;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean listON = false;
        int coice;
        while (!listON){
            System.out.println("Hej vänligen skriv in ett val:");
            coice = scanner.nextInt();
            switch (coice){
                case 1:

                    System.out.println("TJenna");
                    break;

                case 2:

                    System.out.println("Hallå");
                    break;

                case 3:

                    System.out.println("Läget?");
                    break;

                case 4:

                    System.out.println("Hur gött då?");
                    break;

                case 5:

                    System.out.println("Alltid lika gött");
                    break;

                case 6:

                    System.out.println("Sweet");
                    listON = true;
                    break;


                default:
                    System.out.println("Inget val gjort");
                    break;
            }

        }
        
    }
}
