package org.learn.swing.week1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Example2Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Calculator");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panelOperator = new JPanel();
		JPanel panelResult = new JPanel();

		BoxLayout boxLayout1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
		BoxLayout boxLayout2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
		BoxLayout boxLayout3 = new BoxLayout(panelOperator, BoxLayout.X_AXIS);

		panel1.setLayout(boxLayout1);
		panel2.setLayout(boxLayout2);
		panelOperator.setLayout(boxLayout3);

		JPanel mainPanel = new JPanel();

		JLabel labelForNum1 = new JLabel("First Number");
		JLabel labelForNum2 = new JLabel("Second Number");

		JTextField textFieldForNum1 = new JTextField(10);
		JTextField textFieldForNum2 = new JTextField(10);

		JTextArea result = new JTextArea(10, 100);

		JButton btnAdd = new JButton("Add");
		JButton btnSub = new JButton("Sub");
		JButton btnDivide = new JButton("Divide");
		JButton btnMultiply = new JButton("Product");

		panel1.add(labelForNum1);
		panel1.add(textFieldForNum1);

		panel2.add(labelForNum2);
		panel2.add(textFieldForNum2);

		panelOperator.add(btnAdd);
		panelOperator.add(btnSub);
		panelOperator.add(btnDivide);
		panelOperator.add(btnMultiply);

		JScrollPane resultScroller = new JScrollPane(result);

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panelOperator);
		mainPanel.add(panelResult);
		mainPanel.add(resultScroller);

		frame.add(mainPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == btnAdd) {
					result.append("The sum of numbers is: " + (Integer.parseInt(textFieldForNum2.getText())
							+ Integer.parseInt(textFieldForNum1.getText())) + "\n");
				}
			}
		};

		btnAdd.addActionListener(actionListener);

	}

}
