package org.learn.swing.week2;

import java.awt.BorderLayout;
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

	private JRadioButton smallRadioBtn;
	private JRadioButton mediumRadioBtn;
	private JRadioButton largeRadioBtn;
	
	private ButtonGroup groupOfRadioButton;

	private JCheckBox veggieCheckBox;
	private JCheckBox pepperoniCheckBox;

	private JTextField priceTextField;

	public PizzaOrder() {
		// TODO Auto-generated constructor stub

		setSize(300, 200);

		class PizzaSelectionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculatePrice();
			}
		}

		listener = new PizzaSelectionListener();
		createRadioButton();
		createCheckBoxButton();
		createPriceDisplay();
		createLayout();

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
		if(veggieCheckBox.isSelected())
			price+=VEGGIES;
		
		
		priceTextField.setText("$" + price);
	}

	private void createLayout() {
		// TODO Auto-generated method stub
		centerPanel = new JPanel();
		centerPanel.add(checkBoxPanel);
		centerPanel.add(radioButtonPanel);
		
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
		//Checkbox Section
				checkBoxPanel = new JPanel();
				checkBoxPanel.setLayout(new GridLayout(2,1));
				checkBoxPanel.setBorder(new TitledBorder(new EtchedBorder(),"Topping"));
				
				veggieCheckBox = new JCheckBox("Veggie");
				pepperoniCheckBox = new JCheckBox("Pepperoni");
				
				veggieCheckBox.addActionListener(listener);
				pepperoniCheckBox.addActionListener(listener);
				
				
				checkBoxPanel.add(pepperoniCheckBox);
				checkBoxPanel.add(veggieCheckBox);
	}

	public void createRadioButton()
	{
		
		//Radio Button Section
		radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new GridLayout(3,1));
		radioButtonPanel.setBorder(new TitledBorder(new EtchedBorder(),"Size"));
		
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
