package src;

public class SetupPanel extends JPanel {
	private JTextField txtSizem;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtEnterShapeMass;

	// "Current shape" data fields:
	private String currShapeType;
	private double currShapeSizeX, currShapeSizeY;
	private double currShapePosX, currShapePosY;
	private double currShapeMass;

	public SetupOptionsPanel() {
		/*
		 * Create the panel.
		 */

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currShapeType = comboBox.getSelectedItem().toString();
				System.out.println(currShapeType);
			}
		});
		comboBox.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Circle"}));
		comboBox.setToolTipText("");

		JLabel lblAddAShape = new JLabel(" Add a shape:");
		lblAddAShape.setForeground(new Color(0, 0, 0));
		lblAddAShape.setFont(new Font("STIXIntegralsSm", Font.BOLD, 12));

		txtSizem = new JTextField();
		txtSizem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String rawInput = txtSizem.getText().toString();
				try {
					currShapeSizeX = Double.parseDouble(rawInput);
					currShapeSizeY = Double.parseDouble(rawInput);
					System.out.println(currShapeSizeY);
					System.out.println(currShapeSizeX);
				} catch (Exception notInt) {
					currShapeSizeX = 0.0;
					currShapeSizeY = 0.0;
				}
			}
		});
		txtSizem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtSizem.getText().equals("Enter shape size...")) {
					txtSizem.setText("");
				}
			}
		});
		txtSizem.setForeground(Color.GRAY);
		txtSizem.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));
		txtSizem.setText("Enter shape size...");
		txtSizem.setColumns(10);

		JLabel lblMeters = new JLabel("meters");
		lblMeters.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));

		JButton btnAddShape = new JButton("Add shape");
		btnAddShape.setFont(new Font("STIXIntegralsSm", Font.BOLD, 12));
		btnAddShape.setForeground(new Color(0, 0, 0));

		JButton btnSimulate = new JButton("Simulate!");
		btnSimulate.setFont(new Font("STIXIntegralsSm", Font.BOLD, 13));

		txtX = new JTextField();
		txtX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String rawInput = txtX.getText().toString();
				try {
					currShapePosX = Double.parseDouble(rawInput);
					System.out.println(currShapePosX);
				} catch (Exception notInt) {
					currShapePosX = 0.0;
				}
			}
		});
		txtX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtX.getText().equals("x")) {
					txtX.setText("");
				}
			}
		});
		txtX.setText("x");
		txtX.setForeground(Color.GRAY);
		txtX.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));
		txtX.setColumns(10);

		JLabel lblPosition = new JLabel("Center position:");
		lblPosition.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));

		JLabel label = new JLabel("(");
		label.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 14));

		JLabel label_1 = new JLabel(",");
		label_1.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 14));

		txtY = new JTextField();
		txtY.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtY.getText().equals("y")) {
					txtY.setText("");
				}
			}
		});
		txtY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String rawInput = txtY.getText().toString();
				try {
					currShapePosY = Double.parseDouble(rawInput);
					System.out.println(currShapePosY);
				} catch (Exception notInt) {
					currShapePosY = 0.0;
				}
			}
		});
		txtY.setText("y");
		txtY.setForeground(Color.GRAY);
		txtY.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));
		txtY.setColumns(10);

		JLabel label_2 = new JLabel(")");
		label_2.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 14));

		txtEnterShapeMass = new JTextField();
		txtEnterShapeMass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String rawInput = txtEnterShapeMass.getText().toString();
				try {
					currShapeSizeX = Double.parseDouble(rawInput);
					currShapeSizeY = Double.parseDouble(rawInput);
					System.out.println(currShapeSizeY);
					System.out.println(currShapeSizeX);
				} catch (Exception notInt) {
					currShapeSizeX = 0.0;
					currShapeSizeY = 0.0;
				}
			}
		});
		txtEnterShapeMass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtEnterShapeMass.getText().equals("Enter shape mass...")) {
					txtEnterShapeMass.setText("");
				}
			}
		});
		txtEnterShapeMass.setText("Enter shape mass...");
		txtEnterShapeMass.setForeground(Color.GRAY);
		txtEnterShapeMass.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));
		txtEnterShapeMass.setColumns(10);

		JLabel lblNewtons = new JLabel("kilograms");
		lblNewtons.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));

		JLabel label_3 = new JLabel("meters");
		label_3.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));
	}

	// INSERT CODE FOR LAYOUR MANAGER
}
}