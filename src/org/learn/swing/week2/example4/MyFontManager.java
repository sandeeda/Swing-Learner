package org.learn.swing.week2.example4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyFontManager extends JFrame {
	private JLabel showFont;
	private JPanel fontDisplayPanel;
	
	private JComboBox fontList;
	private JPanel fontListPanel;
	
	
	private JCheckBox italic;
	private JCheckBox bold;
	private JPanel fontStylePanel;
	
	
	private JRadioButton small;
	private JRadioButton medium;
	private JRadioButton large;
	private ButtonGroup groupOfRadioButton;
	private JPanel fontSizePanel;
	
	
	private JPanel southPanel;
	private JPanel centerPanel;
	
	
	private ActionListener actionListener;
	private ListSelectionListener listActionListener;
	
	
	public MyFontManager() {
		// TODO Auto-generated constructor stub
		setSize(400,400);
		class FontManagerActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showText();
				
			}
		}
		
		class FontFamilyActionListener implements ListSelectionListener{
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				showText();
			}
		}
		
		actionListener = new FontManagerActionListener();
		listActionListener = new FontFamilyActionListener();
		createComboBox();
		createStyleSelectionPanel();
		createSizeSelectionPanel();
		createLayout();
	}
	
	
	private void createLayout() {
		// TODO Auto-generated method stub
		centerPanel = new JPanel();
		fontDisplayPanel = new JPanel();
		showFont = new JLabel("Hello");
		fontDisplayPanel.add(showFont);
		
		centerPanel.add(fontDisplayPanel);
		add(centerPanel, BorderLayout.CENTER);
		
		
		
		southPanel = new JPanel();
		southPanel.add(fontListPanel);
		southPanel.add(fontSizePanel);
		southPanel.add(fontStylePanel);
		add(southPanel,BorderLayout.SOUTH);
		
		
	}


	private void createSizeSelectionPanel() {
		// TODO Auto-generated method stub
		
		
		
		fontSizePanel = new JPanel();
		fontSizePanel.setLayout(new GridLayout(1,3));
		fontSizePanel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));
		
		small = new JRadioButton("Small");
		medium = new JRadioButton("Medium");
		large = new JRadioButton ("Large");
		
		groupOfRadioButton = new ButtonGroup();
		groupOfRadioButton.add(small);
		groupOfRadioButton.add(medium);
		groupOfRadioButton.add(large);
		small.setSelected(true);
		
		small.addActionListener(actionListener);
		medium.addActionListener(actionListener);
		large.addActionListener(actionListener);
		
		
		
		
		fontSizePanel.add(small);
		fontSizePanel.add(medium);
		fontSizePanel.add(large);
		
		
	}


	private void createStyleSelectionPanel() {
		// TODO Auto-generated method stub
		
		fontStylePanel = new JPanel();
		fontStylePanel.setLayout(new GridLayout(1,2));
		fontStylePanel.setBorder(new TitledBorder(new EtchedBorder(),"Style"));
		
		
		
		italic = new JCheckBox("Itaic");
		bold = new JCheckBox("Bold");
		
		italic.addActionListener(actionListener);
		bold.addActionListener(actionListener);
		
		fontStylePanel.add(bold);
		fontStylePanel.add(italic);
		
		
	}


	private void createComboBox() {
		// TODO Auto-generated method stub
		fontListPanel = new JPanel();
		fontListPanel.setBorder(new TitledBorder(new EtchedBorder(),"Font-family"));
		fontList = new JComboBox();
		fontList.addItem("Serif");
		fontList.addItem("SansSerif");
		fontList.addItem("Monospaced");
		
		
		fontList.setEditable(true);
		fontList.addActionListener(actionListener);
		fontListPanel.add(fontList);
		
		
	}


	private void showText() {
		// TODO Auto-generated method stub
		System.out.println("HERE");
		String fontFamily = (String) fontList.getSelectedItem();
		int style = 0;
		
		if(italic.isSelected())
		{
			style = style + Font.ITALIC;
			System.out.println("In ITALIC");
		}
		
			
		if(bold.isSelected())
			style += Font.BOLD;
		
		
		int size = 0;
		
		if(small.isSelected())
			size+=24;
		if(medium.isSelected())
			size+=36;
		if(large.isSelected())
			size+=48;
		
		showFont.setFont(new Font(fontFamily, style, size));
		showFont.repaint();
		
	}
	
	
}
