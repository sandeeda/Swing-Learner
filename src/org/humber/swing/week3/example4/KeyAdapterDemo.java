package org.humber.swing.week3.example4;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class KeyAdapterDemo extends JFrame{
	
	public JLabel inforLabel;
	public JTextArea area;
	public JPanel panel;
	
	
	public KeyAdapterDemo() {
		// TODO Auto-generated constructor stub
		setSize(400,400);
		panel = new JPanel(new GridLayout(2,1));
		
		inforLabel = new JLabel();
		area = new JTextArea();
		
		panel.add(inforLabel);
		panel.add(area);
		
		add(panel);
		
		area.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String text = area.getText();
				int numOfWords = countWords(text);
				int numOfChars = countChars(text);
				inforLabel.setText("Words : "+numOfWords+" Characters: "+numOfChars);
			}

			

			
		});
		
		
	}
	
	private int countWords(String text) {
		// TODO Auto-generated method stub
		int numberOfWords = text.split("\\s").length;
		return numberOfWords;
	}
	
	private int countChars(String text) {
		// TODO Auto-generated method stub
		int numberOfChars = text.split("").length;
		return numberOfChars;
	}
}
