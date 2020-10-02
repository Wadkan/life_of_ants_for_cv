package com.codecool.ants;

import com.codecool.ants.ants.Ant;
import com.codecool.ants.ants.Drone;
import com.codecool.ants.ants.Worker;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.ants.Queen;

import java.util.*;

public class Colony {
    int withAndHeight;
    private Queen queen;
    private List<Ant> ants = new ArrayList<>();
    Direction direction;
    private Optional[][] colonyMap;


    public Colony(int with) {
        this.withAndHeight = with;
        colonyMap = new Optional[withAndHeight][withAndHeight];

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
    }


    public void generateAnts(int dronesNum, int workersNum, int soldiersNum) {
        Ant D;
        Ant W;
        Ant S;

        while (dronesNum > 0) {
            D = new Drone();
            ants.add(D);
            dronesNum--;
        }
        while (workersNum > 0) {
            W = new Worker();
            ants.add(W);
            workersNum--;
        }
        while (soldiersNum > 0) {
            S = new Drone();
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


        for (int col = 0; col < withAndHeight; col++) {
            System.out.print(col + separator);
        }
        System.out.println();

        for (int row = 0; row < withAndHeight; row++) {
            System.out.print(row + separator);
            for (int col = 0; col < withAndHeight; col++) {
                ant = colonyMap[row][col];
                if (ant.isPresent()) {
                    print = ant.get().toString();
                } else {
                    print = " ";
                }
                System.out.print(print + separator);
            }
            System.out.println();
        }
    }

    public int getWithAndHeight() {
        return withAndHeight;
    }

    public Position getQueenPosizion() {
        return this.queen.getPosition();
    }


}
