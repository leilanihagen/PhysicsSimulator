package com.leilanihagen.physics2dobjects;

public class Tester {

    public static void main(String args[]) {
        Circle c1 = new Circle("red", 2, 3.55, 7.85, 4.1);
        Circle c2 = new Circle("blue", 2, -3.55, -7.85, 4.1);
        Rectangle r1 = new Rectangle("blue", 2, -3.55, -7.85, 4.1, 4.3);
        Rectangle r2 = new Rectangle("blue", 2, -3.55, -7.85, 4.1, 4.3);
        Circle c3 = new Circle("blue", 2, -3.55, -7.85, 4.1);

        //System.out.println(c1.getId());
        //System.out.println(c2.getId());
        //System.out.println(r1.getId());
        //System.out.println(r2.getId());
        //System.out.println(c3.getId());

        Snapshot snap1 = new Snapshot(9.81, 0, 1.225);
        snap1.addShape(c1);
        snap1.addShape(c2);
        snap1.addShape(r1);
        snap1.addShape(r2);
        snap1.addShape(c3);
        System.out.println(snap1.toString());

    }
}
