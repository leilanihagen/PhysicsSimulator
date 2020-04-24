package physics2dsimulationobjects.src.main.java.com.leilanihagen.physics2dobjects;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double mass, double locX, double locY, double radius) {
        super("circle", color, mass, locX, locY);
        this.radius = radius;
    }

    @Override
    public String toString() {

    }
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
