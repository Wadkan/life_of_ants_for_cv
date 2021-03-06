package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public abstract class Ant {
    protected Position position;
    Random r = new Random();

    // TODO get from Colony object
    protected int withAndHeight;
    protected Position queenPosition;

    public Ant(Position position) {
        this.position = position;
    }

    public Ant(int withAndHeight, Position queenPosition) {
        // TODO how to get them colony?
        this.withAndHeight = withAndHeight;
        this.queenPosition = queenPosition;

        int x = r.nextInt(withAndHeight);
        int y = r.nextInt(withAndHeight);

        this.position = new Position(x, y);
    }

    public abstract void move();

    public abstract String toString();


    protected void setPosition(Direction direction) {
        switch (direction) {
            case NORTH:
                if (0 <= this.position.y - 1 && this.position.y - 1 < withAndHeight) {
                    this.position = new Position(this.position.x, this.position.y - 1);
                }
                break;
            case SOUTH:
                if (0 <= this.position.y + 1 && this.position.y + 1 < withAndHeight) {
                    this.position = new Position(this.position.x, this.position.y + 1);
                }
                break;
            case WEST:
                if (0 <= this.position.x - 1 && this.position.x - 1 < withAndHeight) {
                    this.position = new Position(this.position.x - 1, this.position.y);
                }
                break;
            case EAST:
                if (0 <= this.position.x + 1 && this.position.x + 1 < withAndHeight) {
                    this.position = new Position(this.position.x + 1, this.position.y);
                }
                break;
        }
    }

    public Position getPosition() {
        return this.position;
    }

}
