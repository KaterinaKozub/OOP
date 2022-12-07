package org.example;

class point implements Movable {
    private double x;
    private double y;

    public point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        if (x < -100 || x > 100)
            return;
        this.x = x;
    }

    public void setY(double y) {
        if (y < -100 || y > 100)
            return;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void moveTo(double x, double y) {
        setX(x);
        setY(y);
    }
}