package src;

import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

import src.SimData.Shape;
import src.SimData.Snapshot;

/**
 * Generates the next snapshot after delta t as a simulateShapeation of current snapshot.
 *
 * @author Leilani Hagen
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
		double accelX;
		if (!shape.hasAccelX()) {
			accelX = 0.0;
		} else accelX = shape.getAccelX();
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

		// Check for collisions with ground (*FIX: separate out creating builders...):
		for (Shape shape: shapes) {
			if ((shape.getPosY() - shape.getSizeY()) < 0.0 && shape.getVelY() < 0.0) {
				Shape.Builder shapeBuilder = shape.toBuilder()
						.setVelY(-shape.getVelY() * 0.99)
						.setPosY(0.0 + shape.getSizeY());

				collidingShapes.add(shapeBuilder);
			}
//			 // Check for collisions with LEFT WALL (at x=0.0):
//			 else if ((shape.getPosX() - shape.getSizeX()) < 0.0) {
//				 Shape.Builder shapeBuilder = shape.toBuilder()
//					 .setVelY(-shape.getVelX() * 0.99)
//					 .setPosX(0.0 + shape.getSizeX());
//
//				 collidingShapes.add(shapeBuilder);
//			 }
//			// Check for collisions with RIHGT WALL (currently at x=715.0):
//			 else if ((shape.getPosX() - shape.getSizeX()) > 715.0) {
//				 Shape.Builder shapeBuilder = shape.toBuilder()
//					 .setVelY(-shape.getVelX() * 0.99)
//					 .setPosX(0.0 + shape.getSizeX());
//
//				 collidingShapes.add(shapeBuilder);
//			 }
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

//					// First, correct their position so that they are back to BEFORE they collided/went inside each other:
//					// inner:
//					collidingShapes.get(inner).setPosX(xi+((ri+ro)-(xi-xo))/2);
//					collidingShapes.get(inner).setPosX(yi+((ri+ro)-(yi-yo))/2);
//					// outer:
//					collidingShapes.get(outer).setPosX(xo+((ri+ro)-(xi-xo))/2);
//					collidingShapes.get(outer).setPosX(yo+((ri+ro)-(yi-yo))/2);
//
					// Find delta momentum of inner circle:
					double innerDeltaPX = (collidingShapes.get(outer).getVelX() * collidingShapes.get(outer).getMass());
					double innerDeltaPY = (collidingShapes.get(outer).getVelY() * collidingShapes.get(outer).getMass());

					// Find delta momentum of outer circle:
					double outerDeltaPX = (collidingShapes.get(inner).getVelX() * collidingShapes.get(inner).getMass());
					double outerDeltaPY = (collidingShapes.get(inner).getVelY() * collidingShapes.get(inner).getMass());

					// Find new momentum for inner circle baser on delta momentum ((current vel * mass) ):
					double innerNewPX = (collidingShapes.get(inner).getVelX() * collidingShapes.get(inner).getMass()) + outerDeltaPX;
					double innerNewPY = (collidingShapes.get(inner).getVelY() * collidingShapes.get(inner).getMass()) + outerDeltaPY;

					// Find new momentum for outer circle baser on delta momentum ((current vel * mass) ):
					double outerNewPX = (collidingShapes.get(outer).getVelX() * collidingShapes.get(outer).getMass()) + innerDeltaPX;
					double outerNewPY = (collidingShapes.get(outer).getVelY() * collidingShapes.get(outer).getMass()) + innerDeltaPY;

					// Calculate new velocity for inner circle:
					double innerNewVelX = -innerNewPX/(collidingShapes.get(inner).getMass() + collidingShapes.get(outer).getMass());
					double innerNewVelY = -innerNewPY/(collidingShapes.get(inner).getMass() + collidingShapes.get(outer).getMass());
//					double innerNewVelX = innerNewPX;
//					double innerNewVelY = innerNewPY;

					// Calculate new velocity for outer circle:
					double outerNewVelX = -outerNewPX/(collidingShapes.get(inner).getMass() + collidingShapes.get(outer).getMass());
					double outerNewVelY = -outerNewPY/(collidingShapes.get(inner).getMass() + collidingShapes.get(outer).getMass());

					// Give inner shape new velocity:
					collidingShapes.get(inner).setVelX(innerNewVelX);
					collidingShapes.get(inner).setVelY(innerNewVelY);

					// Give outer shape new velocity:
					collidingShapes.get(outer).setVelX(outerNewVelX);
					collidingShapes.get(outer).setVelY(outerNewVelY);

//					// Reposition inner shape:
//					collidingShapes.get(inner).setPosX(); // Set this to new center x coord...
//					collidingShapes.get(inner).setPosY(); // Set this to new center x coord...
//
//					// Reposition outer shape: ??? necessary?
//					collidingShapes.get(inner).setPosX(); // Set this to new center x coord...
//					collidingShapes.get(inner).setPosY(); // Set this to new center x coord...

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