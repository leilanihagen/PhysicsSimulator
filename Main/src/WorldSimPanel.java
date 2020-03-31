package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import src.SimData.Shape;
import src.SimData.Snapshot;
import src.SimData.Simulation;
/**
 * WorldSimPanel is the JPanel component inside the "World" window for DURING SIMULATION. We can
 * hardcode magic numbers and screen specific stuff in here since it will only be used for the
 * World frame.
 *
 * @author Leilani Hagen
 * @date Jun 2, 2018
 *
 */
public class WorldSimPanel extends JPanel {

    private static final long serialVersionUID = 2052334012760148536L;

    private Simulation simulation;
    private int redrawFreq;

    public WorldSimPanel(Simulation simulation, int redrawFreq) {

        super();  // Must be the first thing we call.

        this.simulation = simulation;
        this.redrawFreq = redrawFreq;

        final Timer timer = new Timer(redrawFreq, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                repaint(); // Triggers paintComponent()
            }
        });
        timer.start();
    }

//	private Snapshot doSimulation(Snapshot currentSnapshot, double deltaTime) {
//
//		Snapshot.Builder nextSnapshot = Snapshot.newBuilder();
//		int madeTransformation = 0; // Flag
//
//		// Update/set the time for next snapshot:
//		nextSnapshot.setTime(currentSnapshot.getTime() + deltaTime);
//
//		for (Shape shape: currentSnapshot.getShapesList()) {
//			double vel = -5 * deltaTime;
//			double newPosY = (shape.getPosY() + vel);
//			if (newPosY >= 0) {
//				Shape newShape = shape.toBuilder().setPosY(newPosY).build();
//				nextSnapshot.addShapes(newShape);
//				madeTransformation = 1; // Indicates at least one shape moved
//			}
//		}
//		if (madeTransformation == 1) {
//			return nextSnapshot.build();
//		}
//		return currentSnapshot;
//	}

    private void doDrawing(Graphics g, Snapshot snap) {

        // Cast g (Graphics) to Graphics2D:
        Graphics2D g2d = (Graphics2D) g;

        // Screen (300, 300) is our origin for Physics coordinates. Screen Y-positive is
        // down, but Physics Y-positive should be up.
//		g2d.setColor(Color.blue);
//		g2d.drawLine(0, 300, 600, 300);
//		g2d.drawLine(300, 0, 300, 600);

        Random rnd = new Random();
        int red = rnd.nextInt(256);
        int green = rnd.nextInt(256);
        int blue = rnd.nextInt(256);
        g2d.setColor(new Color(red, green, blue));

        for (Shape shape : snap.getShapesList()) {
            if (shape.getType().equals("circle")) {

                // Centers of shapes from engine:
                double phyPosX = shape.getPosX();
                double phyPosY = shape.getPosY();
                double phySizeX = shape.getSizeX();
                double phySizeY = shape.getSizeY();

                // Transform to screen coordinates.
                int screenPosX = (0 + (int) (phyPosX)) - (int) (phySizeX); // dist. from corner of the frame...
                int screenPosY = (477 - (int) (phyPosY)) - (int) (phySizeY);
                int screenWidth = (int) (2.0 * phySizeX);
                int screenHeight = (int) (2.0 * phySizeY);

//				g2d.drawOval(screenPosX, screenPosY, screenWidth, screenHeight);
                g2d.fillOval(screenPosX, screenPosY, screenWidth, screenHeight);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int lastSnap = simulation.getSnapshotsCount() - 1;

        Snapshot currentSnap = simulation.getSnapshots(lastSnap);
        doDrawing(g, currentSnap);
        Snapshot nextSnap = Engine.getNextSnapshot(currentSnap, 1.0/(double)redrawFreq);
        // Create mutable version of simulation:
        Simulation.Builder simBuilder = simulation.toBuilder();
        simBuilder.addSnapshots(nextSnap);
        simulation = simBuilder.build();
    }
}