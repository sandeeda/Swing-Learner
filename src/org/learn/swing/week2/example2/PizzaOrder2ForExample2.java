package org.learn.swing.week2.example2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PizzaOrder2ForExample2 extends JFrame {

	private static final double LARGE = 14.99;
	private static final double MEDIUM = 10.99;
	private static final double SMALL = 6.99;
	private static final double PEPPERONI = 5.99;
	private static final double VEGGIES = 2.99;

	private double price;

	private ActionListener listener;
	private ListSelectionListener listSelectionListener;

	private JPanel comboBoxPanel;
	private JPanel listPanel;
	private JPanel pricePanel;
	private JPanel centerPanel;

	private JComboBox sizeComboBox;
	private JList<String> toppingList;

	private JTextField priceTextField;

	public PizzaOrder2ForExample2() {
		// TODO Auto-generated constructor stub

		setSize(300, 200);

		class PizzaSelectionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculatePrice();
			}
		}

		class PizzaToppingListSelectionListener implements ListSelectionListener {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				calculatePrice();
			}
		}

		listener = new PizzaSelectionListener();
		listSelectionListener = new PizzaToppingListSelectionListener();
		createComboBox();
		createList();
		createPriceDisplay();
		createLayout();

	}

	private void createList() {
		// TODO Auto-generated method stub
		listPanel = new JPanel();
		listPanel.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));

		ArrayList<String> listOfToppings = new ArrayList<>();
		listOfToppings.add("Pepperoni");
		listOfToppings.add("Veggies");
		toppingList = new JList(listOfToppings.toArray());
		toppingList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		toppingList.addListSelectionListener(listSelectionListener);

		listPanel.add(toppingList);
	}

	private void createComboBox() {
		// TODO Auto-generated method stub
		comboBoxPanel = new JPanel();
		comboBoxPanel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

		sizeComboBox = new JComboBox();
		sizeComboBox.addItem("Small");
		sizeComboBox.addItem("Medium");
		sizeComboBox.addItem("Large");

		sizeComboBox.setEditable(true);

		sizeComboBox.addActionListener(listener);
		comboBoxPanel.add(sizeComboBox);
	}

	public void calculatePrice() {
		// TODO Auto-generated method stub
		price = 0;
		String size = (String) sizeComboBox.getSelectedItem();
		if (size.equals("Small"))
			price +=SMALL;
		if (size.equals("Medium"))
			price +=MEDIUM;
		if (size.equals("Large"))
			price +=LARGE;
		
		
		ArrayList<String> selectedToppings = (ArrayList<String>) toppingList.getSelectedValuesList();
		for (Iterator iterator = selectedToppings.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if(string.equals("Veggies"))
				price+=VEGGIES;
			if(string.equals("Pepperoni"))
				price+=PEPPERONI;
		}
		
		priceTextField.setText("$" + price);
	}

	private void createLayout() {
		// TODO Auto-generated method stub
		centerPanel = new JPanel();
		centerPanel.add(comboBoxPanel);
		centerPanel.add(listPanel);

		add(centerPanel, BorderLayout.CENTER);
		add(pricePanel, BorderLayout.SOUTH);

	}

	private void createPriceDisplay() {
		// TODO Auto-generated method stub
		pricePanel = new JPanel();
		JLabel priceLabel = new JLabel("Your price");

		pricePanel.setLayout(new FlowLayout());
		priceTextField = new JTextField(10);

		pricePanel.add(priceLabel);
		pricePanel.add(priceTextField);

	}

}
