package org.example;

public abstract class Shape {
    private final int colour;
    public final double PI = 3.14;

    public Shape(int colour) {
        this.colour = colour;
    }

    public void draw() {}

    public double getArea() {
        return 0;
    }

    public int getColour() {
        return 0;
    }
}


