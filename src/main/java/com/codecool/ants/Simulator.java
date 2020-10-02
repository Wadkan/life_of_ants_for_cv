package com.codecool.ants;

import java.util.Scanner;

public class Simulator {
    static Colony colony;

    public static void main(String[] args) {
        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");

        colony = new Colony(30);
        colony.generateAnts(1, 2, 3);
        colony.update();
        colony.display();

        listener();
    }


    public static void listener() {
        Scanner keyListener = new Scanner(System.in);
        String key = "";

        while (!(key == "q" || key == "Q")) {
            System.out.println("Hit R or Q: ");
            key = keyListener.nextLine();
            System.out.println(key);
            if (key.equals("r") || key.equals("R")) {
                colony.display();
                colony.update();
            }
        }
        System.out.println("THANKS FOR CHECKING THE ANTS!");
    }
}
