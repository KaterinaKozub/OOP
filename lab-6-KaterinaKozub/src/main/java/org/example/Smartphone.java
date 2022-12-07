package org.example;

public class Smartphone implements Cellular, GPS {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Smartphone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double[] getCoordinates() {
        this.x=x;
        this.y=y;
        return new double[0];
    }


    @Override
    public void makeCall() {
        makeCall();
    }

    @Override
    public void receiveCall() {
        receiveCall();
    }
}
