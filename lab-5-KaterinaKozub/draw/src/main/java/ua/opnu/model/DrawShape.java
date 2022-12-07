package ua.opnu.model;

import java.awt.*;

/*
 * Клас "Фігура для малювання".
 * Клас містить початкову та кінцеву точку, а також різні методи
 */
public abstract class DrawShape {

    public static DrawShape newInstance(int shapeType) {

        DrawShape shape = null;

        if (shapeType == DrawShape.SHAPE_RECTANGLE) {
            shape = new Rectangle();
        } else if (shapeType == DrawShape.SHAPE_ROUNDED_RECT) {
            shape = new RoundedRectangle();
        } else if (shapeType == DrawShape.SHAPE_ELLIPSE) {
            shape = new Ellipse();
        }

        return shape;

    }

    // Figure types
    public static final int SHAPE_RECTANGLE = 0;
    public static final int SHAPE_ROUNDED_RECT = 1;
    public static final int SHAPE_ELLIPSE = 2;

    // Start/end point
    private Point startPoint;
    private Point endPoint;


    public DrawShape() {
        this(new Point(0, 0), new Point(0, 0));
    }

    // Constructor with start/end coordinates
    public DrawShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    // Return figure to draw
    public Shape getShape() {
        return this.getShape(startPoint, endPoint);
    }

    public Shape getShape(Point startPoint, Point endPoint) {
        return null;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

}