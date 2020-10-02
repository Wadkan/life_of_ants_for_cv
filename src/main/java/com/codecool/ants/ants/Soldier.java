package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Soldier extends Ant {
    int actualStep = 3;
    Direction direction;

    public Soldier(int withAndHeight, Position queenPosition) {
        super(withAndHeight, queenPosition);
    }

    @Override
    public void move() {
        actualStep = actualStep % (Direction.values().length);
        direction = Direction.getElementByIndex(actualStep++);
        setPosition(direction);
    }

    @Override
    public String toString() {
        return "S";
    }
}
