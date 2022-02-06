package org.humber.swing.week3.example2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class CreateWindow extends JFrame {
	
	public CreateWindow() {
		// TODO Auto-generated constructor stub
		setTitle("Tabbed Panes");
		setSize(500,200);
		createTabbedPane();
		
	}

	private void createTabbedPane() {
		// TODO Auto-generated method stub
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel panel1 = new JPanel();
		JLabel displayLabel = new JLabel("Tab1");
		displayLabel.setHorizontalAlignment(JLabel.CENTER);
		panel1.setLayout(new GridLayout(1,1));
		panel1.add(displayLabel);
		
		tabbedPane.addTab("Tab1", null, panel1, "This is Tab1");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		
		JPanel panel2 = new JPanel();
		JLabel displayLabel2 = new JLabel("Tab2");
		displayLabel2.setHorizontalAlignment(JLabel.CENTER);
		panel2.setLayout(new GridLayout(1,1));
		panel2.add(displayLabel2);
		
		tabbedPane.addTab("Tab2", null, panel2, "this is Tab2");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		
		add(tabbedPane, BorderLayout.CENTER);
	}
}
