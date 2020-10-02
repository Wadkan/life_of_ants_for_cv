package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;

public class Soldier extends Ant {
    int lastStep = 3;
    int actualStep;

    public Soldier(){
        super();
    }

    @Override
    public void move() {
        actualStep = lastStep + 1 % Direction.values().length;
        Direction.getElementByIndex(actualStep);
    }

    @Override
    public String toString() {
        return "S";
    }
}
