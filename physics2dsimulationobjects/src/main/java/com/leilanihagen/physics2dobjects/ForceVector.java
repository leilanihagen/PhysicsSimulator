package physics2dsimulationobjects.src.main.java.com.leilanihagen.physics2dobjects;

public class ForceVector {
    private double magnitude;
    private double direction;
    private double locX;
    private double locY;

    public ForceVector(double magnitude, double direction, double locX, double locY) {
        this.magnitude = magnitude;
        this.direction = direction;
        this.locX = locX;
        this.locY = locY;
    }

    @Override
    public String toString() {
        return "Force vector of magnitude: " + magnitude + " and direction: " + direction + " at x=" + locX
                + ", y=" + locY + '.';
    }
    public double getMagnitude() {
        return this.magnitude;
    }
    public double getDirection() {
        return this.direction;
    }
    public double getLocX() {
        return this.locX;
    }
    public double getLocY() {
        return this.locY;
    }
    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }
    public void setDirection(double direction) {
        this.direction = direction;
    }
    public void setLocX(double locX) {
        this.locX = locX;
    }
    public void setLocY(double locY) {
        this.locY = locY;
    }
}
