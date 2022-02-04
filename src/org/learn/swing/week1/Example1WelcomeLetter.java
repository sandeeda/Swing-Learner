package org.learn.swing.week1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Example1WelcomeLetter {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Name Display");

		JPanel jPanel = new JPanel();

		JLabel firstNameLbl = new JLabel("First Name");
		JLabel lastNameLbl = new JLabel("Last Name");

		JTextField firstNameTextArea = new JTextField(20);
		JTextField lastNameTextArea = new JTextField(20);

		JLabel resultLabel = new JLabel("Welcome");
		JButton greetButton = new JButton("Greet");

		jPanel.add(firstNameLbl);
		jPanel.add(firstNameTextArea);

		jPanel.add(lastNameLbl);
		jPanel.add(lastNameTextArea);

		jPanel.add(resultLabel);
		jPanel.add(greetButton);
		
		
		
		frame.add(jPanel);
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				resultLabel.setText(
						resultLabel.getText() + " " + firstNameTextArea.getText() + " " + lastNameTextArea.getText());

			}
		};

		greetButton.addActionListener(actionListener);
	}
}
