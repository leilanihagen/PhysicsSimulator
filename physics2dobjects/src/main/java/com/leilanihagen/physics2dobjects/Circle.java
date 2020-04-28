package physics2dobjects.src.main.java.com.leilanihagen.physics2dobjects;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double mass, double locX, double locY, double radius) {
        super("circle", color, mass, locX, locY);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Shape of type: " + super.getType() + ", color: " + super.getColor() + ", mass: " + super.getMass()
                + ", and radius: " + this.radius + " at x=" + super.getLocX() + " and y=" + super.getLocY() + ".";
    }
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
