package physics2dobjects.src.main.java.com.leilanihagen.physics2dobjects;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double mass, double locX, double locY, double width, double height) {
        super("rectangle", color, mass, locX, locY);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Shape of type: " + super.getType() + ", color: " + super.getColor() + ", mass: " + super.getMass()
                + ", width: " + this.width + ", and height: " + this.height + " at x=" + super.getLocX()
                + " and y=" + super.getLocY() + ".";
    }
    public double getWidth() {
        return this.width;
    }
    public double getHeight() {
        return this.height;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
