package physics2dobjects.src.main.java.com.leilanihagen.physics2dobjects;

public abstract class Shape {
    private int id;
    private String type;
    private String color;
    private double mass;
    private double locX;
    private double locY;

    private static int shapesCount;

    public Shape(String type, String color, double mass, double locX, double locY) {
        this.type = type;
        this.color = color;
        this.mass = mass;
        this.locX = locX;
        this.locY = locY;
        this.id = generateId();
    }

    private static int generateId() {
        if(shapesCount == 0) {
            shapesCount = 1;
        }
        else {
            shapesCount += shapesCount;
        }
        return shapesCount;
    }

    @Override
    public abstract String toString();

    public int getId() {
        return this.id;
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
}

