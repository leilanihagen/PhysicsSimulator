package src;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

    public SetupPanel() {
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
                if (txtSizem.getText().equals("Enter shape size…")) {
                    txtSizem.setText("");
                }
            }
        });
        txtSizem.setForeground(Color.GRAY);
        txtSizem.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));
        txtSizem.setText("Enter shape size…");
        txtSizem.setColumns(10);

        JLabel lblMeters = new JLabel("meters");
        lblMeters.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));

        JButton btnAddShape = new JButton("Add shape");
        btnAddShape.setFont(new Font("STIXIntegralsSm", Font.BOLD, 12));
        btnAddShape.setForeground(new Color(0, 0, 0));

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
                if (txtEnterShapeMass.getText().equals("Enter shape mass…")) {
                    txtEnterShapeMass.setText("");
                }
            }
        });
        txtEnterShapeMass.setText("Enter shape mass…");
        txtEnterShapeMass.setForeground(Color.GRAY);
        txtEnterShapeMass.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));
        txtEnterShapeMass.setColumns(10);

        JLabel lblNewtons = new JLabel("kilograms");
        lblNewtons.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));

        JLabel label_3 = new JLabel("meters");
        label_3.setFont(new Font("STIXIntegralsSm", Font.PLAIN, 12));

        JButton btnNewButton = new JButton("Simulate!");
        btnNewButton.setFont(new Font("STIXIntegralsSm", Font.BOLD, 13));
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(6)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(btnAddShape, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                .addGap(290)
                                                .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(lblAddAShape)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(6)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                                                        .addComponent(lblPosition, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(txtSizem, Alignment.LEADING))
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(lblMeters))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                                .addComponent(txtEnterShapeMass, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(lblNewtons, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                                .addComponent(label)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(txtX, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(txtY, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(label_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                .addGap(20)
                                .addComponent(lblAddAShape)
                                .addGap(18)
                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtSizem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblMeters))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblPosition, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtX, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtY, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtEnterShapeMass, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewtons, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnAddShape)
                                .addContainerGap(51, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(247)
                                .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(24))
        );
        setLayout(groupLayout);

    }
}
