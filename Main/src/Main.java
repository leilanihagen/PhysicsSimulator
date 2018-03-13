package src;

import java.awt.Color;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.google.protobuf.ExtensionRegistryLite;

import src.SimData.Shape;
import src.SimData.Snapshot;
import src.SimData.Simulation;

public class Main {

	/**
	 * Builds complete sample ball objects, adds them to an ArrayList<>(), builds the
	 * initial snapshot, and adds this initial snapshot to the snapshotsBuilder.
	 * @return
	 */
	public static Simulation buildSampleSimulation() {
		
		Shape.Builder ballBuilder = Shape.newBuilder()
				.setType("circle")
				.setPosX(100.0)
				.setPosY(100.0)
				.setSizeX(15.0)
				.setSizeY(15.0)
				.setMass(5.0);
		
		// Create initial ball 1 with ballBuilder defaults:
		Shape ball1 = ballBuilder.build();
		
		// Create 2 new ball objects using modified versions of ball1:
		Shape ball2 = ball1.toBuilder().setPosX(125).setPosY(140).setVelY(100.0).build();
		Shape ball3 = ball1.toBuilder().setPosX(150).setPosY(180).setVelX(-5.0).build();
		
		// Add ball objects to an ArrayList<>():
		List<Shape> shapeList = new ArrayList<>();
		shapeList.add(ball1);
		shapeList.add(ball2);
		shapeList.add(ball3);
		
		// Create first snapshot:
		Snapshot.Builder snapshot1Builder = Snapshot.newBuilder()
				.setTime(0.0)
				.addAllShapes(shapeList)
				.setGravity(-9.81);
		Snapshot snapshot1 = snapshot1Builder.build(); 
		
		// Creates snapshotsBuilder object (should eventually save all snapshots):
		Simulation.Builder snapshotsBuilder = Simulation.newBuilder()
				.addSnapshots(snapshot1);
		Simulation snapshots = snapshotsBuilder.build();
		
		return snapshots;
	}
	
//	/**
//	 * Creates a FileWriter object fw and writes initial snapshot information (for now,
//	 * later on we should have a list of all snapshots(?)) to specified filePath.
//	 * @param snapshots
//	 * @param filePath
//	 * @throws IOException
//	 */
//	public static void writeSnapshots(Simulation snapshots, String filePath)
//			throws IOException {
//		
//		// **Research method:
//		FileWriter fw = new FileWriter(filePath + ".ascii");
//		fw.write(snapshots.toString());
//		fw.close();
//		
//		// **Research method:
//		OutputStream os = new FileOutputStream(filePath + ".binary");
//		snapshots.writeTo(os);
//		os.close();
//	}
	
//	public static Simulation readSnapshots(String filePath)
//			throws IOException {
//
//		InputStream is = new FileInputStream(filePath + ".binary");
//		ExtensionRegistryLite eReg = ExtensionRegistryLite.getEmptyRegistry();
//		Simulation snapshots = Simulation.parseFrom(is, eReg);
//		is.close();
//
//		return snapshots;
//	}
	
	public static void main(String[] args) throws IOException {

		Simulation sample = buildSampleSimulation();
		//writeSnapshots(sample, "sample");
		//Simulation sampleRead = readSnapshots("sample");
		
		// Create and size frame:
		JFrame frame = new JFrame("Setup");
		frame.setSize(600, 600);
		frame.setBackground(Color.blue);
		
		// Quit the program upon frame close:
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create components to put in the frame:
		DrawPanel drawPanel = new DrawPanel(sample, 10);
		drawPanel.setLocation(300, 0);
		drawPanel.setSize(200, 200);
		drawPanel.setPreferredSize(new Dimension(200, 200));
		drawPanel.setVisible(true);
		frame.add(drawPanel);
		
//		JTextArea textArea = new JTextArea(5,20);
//		textArea.setBackground(Color.red);
//		textArea.setSize(200, 500);
//		textArea.setText("Hello world1\nHello world2\nHello world3");
//		textArea.setEditable(false);
//		JScrollPane scrollPane = new JScrollPane(textArea);
//		scrollPane.setBackground(Color.green);
//		scrollPane.setSize(250, 600);
//		scrollPane.setLocation(10, 10);
//		frame.add(scrollPane);
//		frame.pack();		
		
		// Display frame:
		frame.setVisible(true);
	}
}