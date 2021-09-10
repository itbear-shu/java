package day_7;

public class Circle {
    private double radius;

//    public Circle() {
//        this.radius = 1;
//    }

//    public Circle() {
//    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return 3.14*this.radius*this.radius;
    }
}
