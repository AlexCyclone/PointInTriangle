package com.gmail.babanin.aleksey;

public class Triangle {

    private double vertexAX;
    private double vertexAY;
    private double vertexBX;
    private double vertexBY;
    private double vertexCX;
    private double vertexCY;

    public Triangle(double vertexAX, double vertexAY,
                    double vertexBX, double vertexBY,
                    double vertexCX, double vertexCY) {

        this.vertexAX = vertexAX;
        this.vertexAY = vertexAY;
        this.vertexBX = vertexBX;
        this.vertexBY = vertexBY;
        this.vertexCX = vertexCX;
        this.vertexCY = vertexCY;
    }

    public boolean pointInside(double pointCoordinateX, double pointCoordinateY) {

        double summaryArea;

        Triangle triangleAB;
        Triangle triangleBC;
        Triangle triangleCA;

        triangleAB = new Triangle(pointCoordinateX, pointCoordinateY,
                                  this.vertexAX, this.vertexAY,
                                  this.vertexBX, this.vertexBY);
        triangleBC = new Triangle(pointCoordinateX, pointCoordinateY,
                                  this.vertexBX, this.vertexBY,
                                  this.vertexCX, this.vertexCY);
        triangleCA = new Triangle(pointCoordinateX, pointCoordinateY,
                                  this.vertexCX, this.vertexCY,
                                  this.vertexAX, this.vertexAY);

        summaryArea = triangleAB.area() + triangleBC.area() + triangleCA.area();

        if (compareDouble(summaryArea, this.area())) {
            return true;
        }
        return false;
    }

    public double area() {
        double area;
        double p;

        p = (this.lengthAB() + this.lengthBC() + this.lengthCA()) / 2;

        area = Math.sqrt(p * (p - this.lengthAB()) * (p - this.lengthBC())
                         * (p - this.lengthCA()));

        return area;
    }

    private double lengthAB() {
        double length;

        length = Math.sqrt(Math.pow((this.vertexAX - this.vertexBX), 2)
                           + Math.pow((this.vertexAY - this.vertexBY), 2));

        return length;
    }

    private double lengthBC() {
        double length;

        length = Math.sqrt(Math.pow((this.vertexBX - this.vertexCX), 2)
                           + Math.pow((this.vertexBY - this.vertexCY), 2));

        return length;
    }

    private double lengthCA() {
        double length;

        length = Math.sqrt(Math.pow((this.vertexCX - this.vertexAX), 2)
                           + Math.pow((this.vertexCY - this.vertexAY), 2));

        return length;
    }

    private boolean compareDouble(double a, double b) {

        double tolerance = 10E-14;
        double deviation = Math.abs(a - b);

        if (deviation <= tolerance) {
            return true;
        }
        return false;
    }
}