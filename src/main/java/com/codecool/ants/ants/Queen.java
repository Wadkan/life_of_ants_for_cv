package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Queen extends Ant {
    int moodCounter = 1;

    public Queen(Position position) {
        super(position);
    }

    @Override
    public void move() {
        if (moodCounter == 0) {
            moodCounter = r.nextInt(100) + 50;
        } else {
            moodCounter--;
        }
    }

    @Override
    public String toString() {
        return "Q";
    }

    public boolean ifMoodForMating() {
        return moodCounter == 0 ? true : false;
    }
}
