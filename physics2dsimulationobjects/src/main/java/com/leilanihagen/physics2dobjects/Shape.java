package physics2dsimulationobjects.src.main.java.com.leilanihagen.physics2dobjects;

package physics2dsimulationobjects.src.main.java.com.leilanihagen.physics2dobjects;

public abstract class Shape {
    private String type;
    private String color;
    private double mass;
    private double locX;
    private double locY;

    public Shape(String color, double mass, double locX, double locY) {
        this.color = color;
        this.mass = mass;
        this.locX = locX;
        this.locY = locY;
    }

    public String getType() {
        return this.type;
    }
    public String getColor() {
        return this.color;
    }
    public double getMass() {
        return this.mass;
    }
    public double getLocX() {
        return this.locX;
    }
    public double getLocY() {
        return this.locY;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public void setLocX(double locX) {
        this.locX = locX;
    }
    public void setLocY(double locY) {
        this.locY = locY;
    }
    @Override
    public String toString() {
        return "Shape of type: " + type + ", color: " + color + " and mass: " + mass + " at position x="
                + locX + ", y=" + locY "."
    }
}

