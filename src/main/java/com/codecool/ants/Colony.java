package com.codecool.ants;

import com.codecool.ants.ants.*;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.*;

public class Colony {
    protected int withAndHeight;
    protected Queen queen;
    private List<Ant> ants = new ArrayList<>();
    Direction direction;
    private Optional[][] colonyMap;


    public Colony(int with) {
        colonyMap = new Optional[with][with];
        this.withAndHeight = with - 1;

        int middle = Math.round(with / 2);
        Position queenPosition = new Position(middle, middle);
        this.queen = new Queen(queenPosition);
    }


    private void clearTheColonyArray() {
        for (int row = 0; row < withAndHeight; row++) {
            for (int col = 0; col < withAndHeight; col++) {
                colonyMap[row][col] = Optional.empty();
            }
        }
        colonyMap[queen.getPosition().x][queen.getPosition().y] = Optional.of(queen);
    }


    public void generateAnts(int dronesNum, int workersNum, int soldiersNum) {
        Ant D;
        Ant W;
        Ant S;

        while (dronesNum > 0) {
            D = new Drone(getWithAndHeight(), getQueenPosition(), queen);
            ants.add(D);
            dronesNum--;
        }
        while (workersNum > 0) {
            W = new Worker(getWithAndHeight(), getQueenPosition());
            ants.add(W);
            workersNum--;
        }
        while (soldiersNum > 0) {
            S = new Soldier(getWithAndHeight(), getQueenPosition());
            ants.add(S);
            soldiersNum--;
        }
    }


    public void update() {
        clearTheColonyArray();
        for (Ant ant : ants) {
            direction = Direction.NORTH;
            ant.move();
            colonyMap[ant.getPosition().x][ant.getPosition().y] = Optional.of(ant);
        }
    }

    public void display() {
        Optional ant;
        String print;
        String separator = " ";
        String color;

        final String BLACK = "\033[0;30m";   // BLACK
        final String BLUE = "\033[0;34m";    // BLUE
        final String PURPLE = "\033[0;35m";  // PURPLE
        final String RED = "\033[0;31m";     // RED
        final String GREEN = "\033[0;32m";   // GREEN
        final String CYAN = "\033[0;36m";    // CYAN


        for (int col = 0; col < withAndHeight; col++) {
            System.out.print(BLUE + col + separator);
        }
        System.out.println(BLACK);

        for (int row = 0; row < withAndHeight; row++) {
            System.out.print(BLUE + row + separator);
            System.out.print(BLACK);
            for (int col = 0; col < withAndHeight; col++) {
                ant = colonyMap[row][col];
                if (ant.isPresent()) {
                    print = ant.get().toString();
                } else {
                    print = " ";
                }
                switch (print) {
                    case "Q":
                        color = PURPLE;
                        break;
                    case "W":
                        color = RED;
                        break;
                    case "S":
                        color = GREEN;
                        break;
                    case "":
                        color = CYAN;
                        break;
                    default:
                        color = BLACK;
                }
                System.out.print(color + print + separator + BLACK);
            }
            System.out.println();
        }
    }

    public int getWithAndHeight() {
        return withAndHeight;
    }

    public Position getQueenPosition() {
        return this.queen.getPosition();
    }


}
