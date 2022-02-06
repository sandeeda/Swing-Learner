package org.humber.swing.week3.example1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PizzaOrderMenuTabFrame extends JFrame {
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 300;
	
	public JLabel displayLabel;
	private String typeOfPizza;
	private String sizeOfPizza;
	
	
	public PizzaOrderMenuTabFrame() {
		// TODO Auto-generated constructor stub
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		displayLabel = new JLabel ("Your order");
		add(displayLabel, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.add(createFileMenu());
		menuBar.add(createOrderMenu());
	}


	private JMenu createOrderMenu() {
		// TODO Auto-generated method stub
		JMenu orderMenu = new JMenu("Order");
		orderMenu.add(createSizeSubMenu());
		orderMenu.add(createTypeSubMenu());
		return orderMenu;
	}


	private JMenu createTypeSubMenu() {
		// TODO Auto-generated method stub
		JMenu menuType = new JMenu("Type");
		menuType.add(createTypeItems("Pepperoni"));
		menuType.add(createTypeItems("Veggies"));
		
		return menuType;
	}


	private JMenuItem createTypeItems(String type) {
		// TODO Auto-generated method stub
		JMenuItem typeItem = new JMenuItem(type);
		class MenuItemListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				typeOfPizza = type;
				displayOrder();
			}
		}
		
		ActionListener listener = new MenuItemListener();
		typeItem.addActionListener(listener);
		return typeItem;
		
	}


	private JMenu createSizeSubMenu() {
		// TODO Auto-generated method stub
		JMenu menuSize = new JMenu("Size");
		menuSize.add(createSizeItems("Small"));
		menuSize.add(createSizeItems("Medium"));
		menuSize.add(createSizeItems("Large"));
		return menuSize;
	}
	
	
	


	private JMenuItem createSizeItems(String size) {
		// TODO Auto-generated method stub
		JMenuItem sizeItem = new JMenuItem(size);
		class MenuItemListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sizeOfPizza = size;
				displayOrder();
			}

		
			
		}
		ActionListener listener = new MenuItemListener();
		sizeItem.addActionListener(listener);
		return sizeItem;
	}

	private void displayOrder() {
		// TODO Auto-generated method stub
		displayLabel.setText("<html> Your Order: <br> Size : "+ sizeOfPizza+"<br> Type: "+ typeOfPizza + "</html");
	}

	private JMenu createFileMenu() {
		// TODO Auto-generated method stub
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(createFileMenuItem());
		return fileMenu;
		
	}


	private JMenuItem createFileMenuItem() {
		// TODO Auto-generated method stub
		JMenuItem itemExit = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			
		}
		ActionListener listener = new MenuItemListener();
		itemExit.addActionListener(listener);
		return(itemExit);
		
	}
	
}
