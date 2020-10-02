package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Worker extends Ant {
    public Worker(int withAndHeight, Position queenPosition){
        super(withAndHeight, queenPosition);
    }

    @Override
    public void move() {
        setPosition(getRandomDirection());
    }

    @Override
    public String toString() {
        return "W";
    }

    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
}
