package Shape2;

import java.util.ArrayList;

abstract class Shape2 {
    public abstract double getVolume();
}

abstract class SolidOfRevolution extends Shape2 {
    protected double radius;

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Ball extends SolidOfRevolution { // конкретный класс

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 3) * 4 / 3;
    }

    public Ball(double radius) {
        super(radius);
    }
}

class Cylinder extends SolidOfRevolution { // конкретный класс
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }
}

class Pyramid extends Shape2 {
    private double height;
    private double s; // площадь основания

    public Pyramid(double height, double s) {
        this.height = height;
        this.s = s;
    }

    @Override
    public double getVolume() {
        return height * s * 4 / 3;
    }
}


class Box extends Shape2 {
    private ArrayList<Shape2> shapes = new ArrayList<>();
    private double available;
    private double volume;

    public Box(double available) {
        this.available = available;
        this.volume = available;
    }

    public boolean add(Shape2 shape) {
        if (available >= shape.getVolume()) {
            shapes.add(shape);
            available -= shape.getVolume();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getVolume() {
        return volume;
    }
}

class Main {

    public static void main(String[] args) {
        Ball шар = new Ball(4.5);
        Cylinder цилиндр = new Cylinder(2, 2);
        Pyramid пирамида = new Pyramid(100, 100);

        Box box = new Box(1000);

        System.out.println(box.add(шар)); // ok
        System.out.println(box.add(цилиндр)); // ok
        System.out.println(box.add(пирамида)); // failed

    }
}