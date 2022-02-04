package org.learn.swing.week2.example3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PizzaOrder extends JFrame {

	private static final double LARGE = 14.99;
	private static final double MEDIUM = 10.99;
	private static final double SMALL = 6.99;
	private static final double PEPPERONI = 5.99;
	private static final double VEGGIES = 2.99;

	private double price;

	private ActionListener listener;

	private JPanel radioButtonPanel;
	private JPanel checkBoxPanel;
	private JPanel pricePanel;
	private JPanel centerPanel;
	private JPanel sizeMenu;
	private JPanel toppingPanel;
	private JPanel menuPanel;

	private JRadioButton smallRadioBtn;
	private JRadioButton mediumRadioBtn;
	private JRadioButton largeRadioBtn;

	private ButtonGroup groupOfRadioButton;

	private JCheckBox veggieCheckBox;
	private JCheckBox pepperoniCheckBox;

	private JTextField priceTextField;

	private JTable sizeMenuTable;
	private JScrollPane spSize;

	private JTable toppingMenuTable;
	private JScrollPane spTopping;

	public PizzaOrder() {
		// TODO Auto-generated constructor stub

		setSize(500, 500);

		class PizzaSelectionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculatePrice();
			}
		}

		listener = new PizzaSelectionListener();
		createMenuTable();
		createRadioButton();
		createCheckBoxButton();
		createPriceDisplay();
		createLayout();

	}

	private void createMenuTable() {
		// TODO Auto-generated method stub
		String sizeTableColumns[] = { "Size", "Price" };
		String sizeMenu[][] = { { "Small", Double.toString(SMALL) }, { "Medium", Double.toString(MEDIUM) },
				{ "Large", Double.toString(LARGE) } };

		sizeMenuTable = new JTable(sizeMenu, sizeTableColumns);
		spSize = new JScrollPane(sizeMenuTable);
		spSize.setPreferredSize(new Dimension(400, 400));

		
		
		String toppingTableColumns[] = { "Topping", "Price" };
		String toppingMenu[][] = { { "Pepperoni", Double.toString(PEPPERONI) },
				{ "Veggies", Double.toString(VEGGIES) } };
		toppingMenuTable = new JTable(toppingMenu, toppingTableColumns);
		spTopping = new JScrollPane(toppingMenuTable);
		spSize.setPreferredSize(new Dimension(400,400));
		
		/*
		 * menuPanel.add(sizeMenuTable); menuPanel.add(toppingMenuTable);
		 */
	}

	public void calculatePrice() {
		// TODO Auto-generated method stub
		price = 0;
		if (smallRadioBtn.isSelected())
			price = SMALL;
		else if (mediumRadioBtn.isSelected())
			price = MEDIUM;
		else if (largeRadioBtn.isSelected())
			price = LARGE;

		if (pepperoniCheckBox.isSelected())
			price += PEPPERONI;
		if (veggieCheckBox.isSelected())
			price += VEGGIES;

		priceTextField.setText("$" + price);
	}

	private void createLayout() {
		// TODO Auto-generated method stub
		
		menuPanel = new JPanel();
		menuPanel.add(spSize); 
		menuPanel.add(spTopping);
		
		centerPanel = new JPanel();
		centerPanel.add(checkBoxPanel);
		centerPanel.add(radioButtonPanel);
		
		add(menuPanel,BorderLayout.NORTH);
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

	private void createCheckBoxButton() {
		// TODO Auto-generated method stub
		// Checkbox Section
		checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new GridLayout(2, 1));
		checkBoxPanel.setBorder(new TitledBorder(new EtchedBorder(), "Topping"));

		veggieCheckBox = new JCheckBox("Veggie");
		pepperoniCheckBox = new JCheckBox("Pepperoni");

		veggieCheckBox.addActionListener(listener);
		pepperoniCheckBox.addActionListener(listener);

		checkBoxPanel.add(pepperoniCheckBox);
		checkBoxPanel.add(veggieCheckBox);
	}

	public void createRadioButton() {

		// Radio Button Section
		radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new GridLayout(3, 1));
		radioButtonPanel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

		smallRadioBtn = new JRadioButton("Small");
		mediumRadioBtn = new JRadioButton("Medium");
		largeRadioBtn = new JRadioButton("Large");

		groupOfRadioButton = new ButtonGroup();
		groupOfRadioButton.add(smallRadioBtn);
		groupOfRadioButton.add(mediumRadioBtn);
		groupOfRadioButton.add(largeRadioBtn);

		smallRadioBtn.addActionListener(listener);
		mediumRadioBtn.addActionListener(listener);
		largeRadioBtn.addActionListener(listener);
		smallRadioBtn.setSelected(true);

		radioButtonPanel.add(largeRadioBtn);
		radioButtonPanel.add(smallRadioBtn);
		radioButtonPanel.add(mediumRadioBtn);

	}
}
