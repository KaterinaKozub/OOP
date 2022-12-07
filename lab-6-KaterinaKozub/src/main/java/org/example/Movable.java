package org.example;

interface Movable {
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();

    void moveTo(double x, double y);
}