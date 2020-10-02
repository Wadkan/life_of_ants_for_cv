package com.codecool.ants.geometry;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public static Direction getElementByIndex(int index) {
        switch (index) {
            case 0:
                return NORTH;
            case 1:
                return EAST;
            case 2:
                return SOUTH;
            case 3:
                return WEST;
            default:
                System.out.println("Error in enum!");
                return NORTH;
        }
    }
}
