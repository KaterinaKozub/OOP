package ua.opnu;

import ua.opnu.java.inheritance.point.Point;

public class Point3D extends Point {
    private int z;

    public Point3D() {
        this(0, 0, 0);
    }
    public Point3D(int x, int y, int z){
        this.setLocation(x, y, z);
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public double distance(Point3D p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        int dz = this.z - p.z;
        return Math.sqrt((double)(dx * dx + dy * dy + dz * dz));
    }

    @Override
    public double distanceFromOrigin() {
        return this.distance(new Point3D());
    }

    public int getZ() {
        return z;
    }
    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "x = " + this.x + "&& y = " + this.y + "&& z = " + this.z;
    }
}
