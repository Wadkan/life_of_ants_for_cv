package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Drone extends Ant {
    final String BLACK = "\033[0;30m";   // BLACK
    final String RED = "\033[0;31m";     // RED

    boolean whatPositionToChanged = true;
    int timeStepsLeft;

    // TODO queen.ifMoodForMating();
    Queen queen;

    public Drone(int withAndHeight, Position queenPosition, Queen queen) {
        super(withAndHeight, queenPosition);
        this.queen = queen;
    }

    @Override
    public void move() {
        if (timeStepsLeft > 1) {
            // waiting after mating
            timeStepsLeft--;
        } else if (timeStepsLeft == 1) {
            // after 10 timestep: kicked off to a random position at the edge of the colony
            timeStepsLeft--;
            kickOffToTheEdge();
        } else {
            // if next to the queen, try to mating
            if (ifNextToTheQueen()) {
                mating();
            }
            // step towards the queen

            // DECIDE TO CHANGE X OR Y POSITION
            if (whatPositionToChanged) {
                whatPositionToChanged = false;

                // CHANGE X POSITION TOWARDS THE QUEEN
                if (this.position.x < queenPosition.x) {
                    setPosition(Direction.EAST);
                } else {
                    setPosition(Direction.WEST);
                }
            } else {
                whatPositionToChanged = true;

                // CHANGE Y POSITION TOWARDS THE QUEEN
                if (this.position.y < queenPosition.y) {
                    setPosition(Direction.SOUTH);
                } else {
                    setPosition(Direction.NORTH);
                }
            }
        }
    }

    private boolean ifNextToTheQueen() {
        return (position.x == queenPosition.x + 1 || position.x == queenPosition.x - 1) &&
                (position.y == queenPosition.y + 1 || position.y == queenPosition.y - 1);
    }

    private void mating() {
        if (queen.ifMoodForMating()) {
            System.out.println(RED + "HALLELUJAH" + BLACK);
            //  stay there for 10 timesteps
            timeStepsLeft = 11;
        } else {
            System.out.println(RED + ":(" + BLACK);
            kickOffToTheEdge();
        }
    }

    private void kickOffToTheEdge() {
        int fullRandom = r.nextInt(withAndHeight);
        int randomFirstOrLast = r.nextBoolean() ? 0 : withAndHeight;

        if (r.nextBoolean()) {
            // x random, y first / last
            position = new Position(fullRandom, randomFirstOrLast);
        } else {
            // x first / last, y random
            position = new Position(randomFirstOrLast, fullRandom);
        }
    }


    @Override
    public String toString() {
        if (this.timeStepsLeft > 0) {
            return Integer.toString(timeStepsLeft - 2);
        } else {
            return "D";
        }
    }

}
