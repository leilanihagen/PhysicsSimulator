package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import src.SP.Shape;
import src.SP.Snapshot;
import src.SP.Snapshots;

public class DrawPanel extends JPanel {
	private static final long serialVersionUID = 2052334012760148536L;
	
	private Snapshots snapshots;
	private double tCurrent = 1.0;

	public DrawPanel(Snapshots snapshots, double tStart, int redrawFreq) {
		super();  // Must be the first thing we call.

		this.snapshots = snapshots;
		this.tCurrent = tStart;
		
		final Timer timer = new Timer(redrawFreq, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
			}
		});
		timer.start();
	}
	
	private void doDrawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Snapshot snap = snapshots.getSnapshotsList().get(0);

		// Screen (300, 300) is our origin for Physics coordinates.
		// Screen Y-positive is down, but Physics Y-positive should be up.
		g2d.setColor(Color.blue);
		g2d.drawLine(0, 300, 600, 300);
		g2d.drawLine(300, 0, 300, 600);

		
		Random rnd = new Random();
		int red = rnd.nextInt(256);
		int green = rnd.nextInt(256);
		int blue = rnd.nextInt(256);
		g2d.setColor(new Color(red, green, blue));
		
		for (Shape shape : snap.getShapesList()) {
			if (shape.getType().equals("circle")) {
				double phyPosX = shape.getPosX();
				double phyPosY = shape.getPosY();
				double phySizeX = shape.getSizeX();
				double phySizeY = shape.getSizeY();

				// Transform to screen coordinates.
				int screenPosX = 300 + (int) phyPosX;
				int screenPosY = 300 - (int) phyPosY;
				int screenSizeX = (int) phySizeX;
				int screenSizeY = (int) phySizeY;
				
				g2d.drawOval(screenPosX, screenPosY, screenSizeX, screenSizeY);
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		doDrawing(g);
	}

}
