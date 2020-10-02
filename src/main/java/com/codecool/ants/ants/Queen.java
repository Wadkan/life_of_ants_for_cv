package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Queen extends Ant {
    public Queen(Position position) {
        this.position = position;
    }

    @Override
    public void move() {
    }

    @Override
    public String toString() {
        return "Q";
    }

    public boolean ifMoodForMating() {
        return this.r.nextBoolean();
    }
}
