package src;

import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

import src.SimData.Shape;
import src.SimData.Snapshot;

/**
 * @author Leila
 * Generates the next snapshot after delta t as a simulateShapeation of current snapshot.
 */
public class Engine {

	private static Shape simulateShape(Shape shape, Snapshot currentSnap, double deltat) {
		// Continue motion of objects based on hard-coded velocities/positions and the
		// constant acceleration due to gravity...
		
		// y:
		double accelY = currentSnap.getGravity();
		double deltaVelY = deltat * accelY;
		double velY = deltaVelY + shape.getVelY();
		double deltaPosY = deltat * velY;
		double posY = deltaPosY + shape.getPosY();

		// x:
		double accelX = shape.getAccelX();
		if (!shape.hasAccelX()) {
			accelX = 0.0;
		}
		double deltaVelX = deltat * accelX;
		double velX = deltaVelX + shape.getVelX();
		double deltaPosX = deltat * velX;
		double posX = deltaPosX + shape.getPosX();
		
		return shape.toBuilder()
				.setAccelY(accelY)
				.setAccelX(accelX)
				.setVelY(velY)
				.setVelX(velX)
				.setPosY(posY)
				.setPosX(posX)
				.build();
	}
	
	private static List<Shape> processCollisions(List<Shape> shapes){
		List<Shape.Builder> collidingShapes = new ArrayList<>();
		
		// Check for collisions with ground (separate out creating builders...):
		for (Shape shape: shapes) {
			 if ((shape.getPosY() - shape.getSizeY()) < 0.0 && shape.getVelY() < 0.0) {
				 Shape.Builder shapeBuilder = shape.toBuilder()
					 .setVelY(-shape.getVelY() * 0.99)
					 .setPosY(0.0 + shape.getSizeY());
				 
				 collidingShapes.add(shapeBuilder);
			 }
			 else {
				 collidingShapes.add(shape.toBuilder());
			 }
		 }
		
		// Check collisions between all shapes:
		for (int outer = 0; outer < collidingShapes.size(); outer++) {
			for (int inner = outer+1; inner < collidingShapes.size(); inner++) {
				// Get (xo,yo) center of outer circle:
				double xo = collidingShapes.get(outer).getPosX();
				double yo = collidingShapes.get(outer).getPosY();
				// Get (xi,yi) center of inner circle:
				double xi = collidingShapes.get(inner).getPosX();
				double yi = collidingShapes.get(inner).getPosY();
				// Get circle radii:
				double ro = collidingShapes.get(outer).getSizeX();
				double ri = collidingShapes.get(inner).getSizeX();
				// Square both sides of (sqrt((xi-xo)^2+(yi-yo)^2) = ri+ro) equation:
				if ((Math.pow(xi-xo, 2)+Math.pow(yi-yo, 2)) < Math.pow((ri+ro),2)) {
					// Collision occurred! 
				}
			}
		}
		
		List<Shape> finalShapes = new ArrayList<>();
		for (Shape.Builder shapeBuilder: collidingShapes) {
			finalShapes.add(shapeBuilder.build());
		}
		
		return finalShapes;
	}
	
	public static Snapshot getNextSnapshot(Snapshot currentSnap, double deltat) {
		
		// Build nextSnap (for use throughout this method):
		Snapshot.Builder nextSnapBuilder = currentSnap.toBuilder();
		nextSnapBuilder.clearShapes();
		
		// Simulate each shape:
		for (Shape shape: currentSnap.getShapesList()) {
			nextSnapBuilder.addShapes(simulateShape(shape, currentSnap, deltat));
		}
		
		// Process collisions for all shapes:
		List<Shape> postCollisionShapes = processCollisions(nextSnapBuilder.getShapesList());
		nextSnapBuilder.clearShapes();
		nextSnapBuilder.addAllShapes(postCollisionShapes);
		
		return nextSnapBuilder.build();
	}
}