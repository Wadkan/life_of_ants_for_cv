package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;

import java.util.Random;

public class Worker extends Ant {
    public Worker(){
        super();
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
