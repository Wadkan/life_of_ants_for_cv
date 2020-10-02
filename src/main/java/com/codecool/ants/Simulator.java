package com.codecool.ants;

import com.codecool.ants.geometry.Position;

import java.util.Scanner;


public class Simulator {
    static public Colony colony;
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLACK = "\033[0;30m";   // BLACK

    public static void main(String[] args) {


        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");

        colony = new Colony(30);

        // TODO ???
        Position queenPosition = colony.getQueenPosition();
        int withAndHeight = colony.getWithAndHeight();

        colony.generateAnts(5, 10, 6);
        colony.update();
        colony.display();

        listener();
    }


    public static void listener() {
        Scanner keyListener = new Scanner(System.in);
        String key = "";

        while (!(key.equals("q") || key.equals("Q"))) {
            System.out.println(YELLOW + "Hit R or Q: " + BLACK);
            key = keyListener.nextLine();
            System.out.println(key);
            if (key.equals("r") || key.equals("R")) {
                colony.display();
                colony.update();
            }
        }
        System.out.println(YELLOW + "THANKS FOR CHECKING THE ANTS!" + BLACK);
    }
}
