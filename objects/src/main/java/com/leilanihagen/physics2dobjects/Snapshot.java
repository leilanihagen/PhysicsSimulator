package com.leilanihagen.physics2dobjects;

import java.util.LinkedList;

public class Snapshot {
    private double gMagnitude;
    private double gDirection;
    private double surroundingFluidDensity;
    private LinkedList<Shape> shapeList;
    private LinkedList<ForceVector> forceVectorList;

    public Snapshot(double gMagnitude, double gDirection, double surroundingFluidDensity) {
        this.gMagnitude = gMagnitude;
        this.gDirection = gDirection;
        this.shapeList = new LinkedList<Shape>();
        this.forceVectorList = new LinkedList<ForceVector>();
    }

    @Override
    public String toString() {
        return "Physics2d world-state Snapshot; contains " + this.getShapesCount() + " shapes, "
                + this.getForceVectorCount() + " force vectors. " + "Magnitude of g=" + gMagnitude
                + ", direction of g=" + gDirection  + ", density of surrounding fluid=" + surroundingFluidDensity + ".";
    }
    public double getGMagnitude() {
        return this.gMagnitude;
    }
    public double gDirection() {
        return this.gDirection;
    }
    public double getSurroundingFluidDensity() {
        return this.surroundingFluidDensity;
    }
    public LinkedList<Shape> getShapeList() {
        return this.shapeList;
    }
    public int getShapesCount() {
        return shapeList.size();
    }
    public LinkedList<ForceVector> getForceVectorList() {
        return this.forceVectorList;
    }
    public int getForceVectorCount() {
        return this.forceVectorList.size();
    }
    public void setGMagnitude(double gMagnitude) {
        this.gMagnitude = gMagnitude;
    }
    public void setGravityDirection(double gDirection) {
        this.gDirection = gMagnitude;
    }
    public void setSurroundingFluidDensity(double surroundingFluidDensity) {
        this.surroundingFluidDensity = surroundingFluidDensity;
    }
    public void setShapeList(LinkedList<Shape> shapeList) {
        this.shapeList = shapeList;
    }
    public void setForceVectorList(LinkedList<ForceVector> forceVectorList) {
        this.forceVectorList = forceVectorList;
    }
    public void addShape(Shape shape) {
        this.shapeList.add(shape);
    }
    public void addForceVector(ForceVector forceVector) {
        this.forceVectorList.add(forceVector);
    }
    public void deleteShape(Shape shape) {
        this.shapeList.remove(shape);
    }
    public void deleteShape(int shapeId) {
        this.shapeList.remove(shapeId - 1);
    }
    public void deleteForceVector(ForceVector forceVector) {
        this.forceVectorList.remove(forceVector);
    }
    public void deleteForceVector(int forceVectorId) {
        this.shapeList.remove(forceVectorId - 1);
    }
}
