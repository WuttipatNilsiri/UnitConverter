import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
	JFrame frame;
	JButton convert;
	JButton clear;
	JTextField leftText;
	JTextField rightText;
	JPanel ui;
	JMenuBar menu;
	JMenu unitTypes;
	JTextField console;
	JLabel eq;
	JList<Unit> leftList;
	boolean defualt = true;
	private JComboBox leftcombo;
	private JComboBox rightcombo;
	UnitConverter unitConverter = UnitConverter.getUnitConverter();
	
	public GUI(){
		frame = new JFrame("GUI frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}

	private void initComponents() {
		leftcombo = new JComboBox();
		rightcombo = new JComboBox();
		Unit[] lengthUnit = unitConverter.getUnits(UnitType.length);
		for (Unit x : lengthUnit){
			leftcombo.addItem(x);
			rightcombo.addItem(x);
		}
		menu = new JMenuBar();
		unitTypes = new JMenu("Unit Types");
		for (UnitType x : UnitType.values()){
			JMenuItem target = new JMenuItem(x.name());
			target.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					leftcombo.removeAllItems();
					rightcombo.removeAllItems();
					Unit[] lengthUnit = unitConverter.getUnits(x);
					for (Unit x : lengthUnit){
						leftcombo.addItem(x);
						rightcombo.addItem(x);
					}
				}
			});
			unitTypes.add(target);
		}
		menu.add(unitTypes);
		frame = new JFrame("Frame");
		convert = new JButton("Convert");
		clear = new JButton("Clear");
		leftText = new JTextField(16);
		rightText = new JTextField(16);
		console = new JTextField(20);
		eq = new JLabel("=");
		console.setEditable(false);
		ui = new JPanel();
		frame.add(menu,BorderLayout.NORTH);
		ui.add(leftcombo);
		ui.add(leftText);
		ui.add(eq);
		ui.add(rightText);
		ui.add(rightcombo);
		convert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				leftText.setForeground(Color.BLACK);
				rightText.setForeground(Color.BLACK);
				Unit unit1 = (Unit) leftcombo.getSelectedItem();
				Unit unit2 = (Unit) rightcombo.getSelectedItem();
				double testpara1 = 0;
				double testpara2 = 0;
				String left = leftText.getText();
				String right = rightText.getText();
				try{
					Double.parseDouble(left);
				}catch (NumberFormatException e){
					leftText.setForeground(Color.RED);
				}
				try{
					Double.parseDouble(right);
				}catch (NumberFormatException e){
					rightText.setForeground(Color.RED);
				}
				try{
					
					if (right.equals("") || defualt){ // to right
						double input = Double.parseDouble(left);
						unitConverter.convert(input, unit1, unit2);
						double ans = unitConverter.getAns();
						rightText.setText(Double.toString(ans));
						console.setText("converted");			
					}else if (left.equals("")){ //to left
						double input = Double.parseDouble(right);
						unitConverter.convert(input, unit2, unit1);
						double ans = unitConverter.getAns();
						leftText.setText(Double.toString(ans));
						console.setText("converted");
					}
				}catch (NumberFormatException e){
					System.out.println(e.getLocalizedMessage());
					console.setText("ERROR "+e.getLocalizedMessage());	
				}
			}
		});
		clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				leftText.setText("");
				rightText.setText("");
			}
		});
		ui.add(convert);
		ui.add(clear);
		frame.add(ui,BorderLayout.CENTER);
		frame.add(console,BorderLayout.SOUTH);		
		frame.pack();
	}
	
	public void run(){
		frame.setVisible(true);
	}
	
	public static void main(String[] a){
		GUI gui = new GUI();
		gui.run();
		System.out.println("RUNN");
	}
}
