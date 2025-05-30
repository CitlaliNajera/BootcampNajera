package org.example;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SandwichBar extends JFrame implements ActionListener {
  JCheckBox btnSteak, btnHam, btnSalami;
  JCheckBox btnRoastBeef, btnChicken, btnBacon;
  JCheckBox chkLettuce, chkPeppers, chkOnions;
  JCheckBox chkTomatoes, chkJalapenos, chkCucumbers,chkPickles,chkGuacamole,chkMushrooms;
  JCheckBox chkMayo, chkMustard,chkKetchup,chkRanch,chkThousandIslands,chkVinaigrette,chkAujus;
  JCheckBox chkChips, chkSmallDrink, chkMediumDrink, chkLargeDrink,chkToasted;
  JTextField txtPrice;
  JPanel choicePanel, topPanel, bottomPanel,middlePanel, sandwichPanel, additionalPanel, cheesePanel;
  JComboBox sizes,breads,extraMeats,extraCheese,sideSauce;
  JCheckBox chkAmerican, chkSwiss, chkCheddar, chkProvolone,chkExtraMeat,chkExtraCheese;
  JButton btnAddOrder, btnRemoveOrder;
  JList<String> orderList;
  DefaultListModel<String> orderListModel;


    double[] baseSandwichPrices = {0.0,5.50, 7.00, 8.50};
    double[] meatPrices = {0.0,1.00, 2.00, 3.00};
    double[] cheesePrices = {0.0,0.75, 1.50, 2.25};
    double[] extraMeatPrices = {0.0,0.50, 1.00, 1.50};
    double[] extraCheesePrices = {0.0,0.30, 0.60, 0.90};


    
    public SandwichBar(){
             super("Sandwich Shop Orders");

       //combo boxes

             String[] size = new String[]{
                     "No sandwich",
                     "4 inch - $5.50",
                     "8 inch - $7.00",
                     "12 inch - $8.50"};
             sizes = new JComboBox(size);

             String[] bread = new String[]{
                     "No bread",
                     "White",
                     "Wheat",
                     "Rye",
                     "Wrap"};
             breads = new JComboBox(bread);

             String[] extraCheeses = new String[]{
                "Extra American",
                "Extra Provolone",
                "Extra Cheddar",
                "Extra Swiss"};
             extraCheese = new JComboBox(extraCheeses);

             String[] extraMeat = new String[]{
                "Extra Steak",
                "Extra Ham",
                "Extra Salami",
                "Extra Roast Beef",
                "Extra Chicken",
                "Extra Bacon"
             };
            extraMeats = new JComboBox(extraMeat);

             String[] extraSauce = new String[]{
                "No side sauce",
                "Side Mayo",
                "Side Mustard",
                "Side Ketchup",
                "Side Ranch",
                "Side Thousand Islands",
                "Side Vinaigrette"
             };
             sideSauce = new JComboBox(extraSauce);

             //Checkboxes

             btnSteak = new JCheckBox("Steak");
             btnHam = new JCheckBox("Ham");
             btnRoastBeef = new JCheckBox("Roast Beef");
             btnSalami = new JCheckBox("Salami");
             btnChicken = new JCheckBox("Chicken");
             btnBacon = new JCheckBox("Bacon");

             chkLettuce = new JCheckBox("Lettuce");
             chkPeppers = new JCheckBox("Peppers");
             chkOnions = new JCheckBox("Onions");
             chkTomatoes = new JCheckBox("Tomatoes ");
             chkJalapenos = new JCheckBox("Jalapenos ");
             chkCucumbers = new JCheckBox("Cucumbers");
             chkPickles = new JCheckBox("Pickles");
             chkGuacamole = new JCheckBox("Guacamole");
             chkMushrooms = new JCheckBox("Mushrooms");

             chkAmerican = new JCheckBox("American");
             chkSwiss = new JCheckBox("Swiss");
             chkCheddar = new JCheckBox("Cheddar");
             chkProvolone = new JCheckBox("Provolone");

             chkMayo = new JCheckBox("Mayo");
             chkMustard = new JCheckBox("Mustard");
             chkKetchup = new JCheckBox("Ketchup");
             chkRanch = new JCheckBox("Ranch");
             chkThousandIslands = new JCheckBox("ThousandIslands");
             chkVinaigrette = new JCheckBox("Vinaigrette");
             chkAujus = new JCheckBox("Add AuJus");

            chkExtraMeat = new JCheckBox("Extra Meat?");
            chkExtraCheese = new JCheckBox("Extra Cheese?");

            chkChips = new JCheckBox("Add chips ($1.50)");
            chkSmallDrink = new JCheckBox("Small Drink ($2.00)");
            chkMediumDrink = new JCheckBox("Medium Drink ($2.50)");
            chkLargeDrink = new JCheckBox("Large Drink ($3.00)");
            chkToasted = new JCheckBox("Get Toasted?");



           txtPrice = new JTextField("Total price = $0.00",15);
           txtPrice.setHorizontalAlignment(JTextField.CENTER);
           txtPrice.setEditable(false);

        btnAddOrder = new JButton("Add Order");
        btnRemoveOrder = new JButton("Remove Selected Order");
        orderListModel = new DefaultListModel<>();
        orderList = new JList<>(orderListModel);
        JScrollPane orderScrollPane = new JScrollPane(orderList);

       //Clear order button function

        JButton btnClearOrder = new JButton("Clear Order");
        btnClearOrder.addActionListener(e -> clearOrderSelections());

        //Complete order btn function

        JButton btnCompleteOrder = new JButton("Complete Order");
        btnCompleteOrder.addActionListener(e -> {
            double total = calculateAllOrdersTotal();
            JOptionPane.showMessageDialog(this, "Total for all orders: $" + String.format("%.2f", total));

            List<String> orders = new ArrayList<>();
            for (int i = 0; i < orderListModel.size(); i++) {
                orders.add(orderListModel.get(i));
            }

            ReceiptManager.saveReceipt(orders, total);
        });





        ItemListener itemListener = e -> calculateTotalPrice();
        ActionListener actionListener = e -> calculateTotalPrice();

        btnSteak.addItemListener(itemListener);
        btnHam.addItemListener(itemListener);
        btnRoastBeef.addItemListener(itemListener);
        btnSalami.addItemListener(itemListener);
        btnChicken.addItemListener(itemListener);
        btnBacon.addItemListener(itemListener);

        chkAmerican.addItemListener(itemListener);
        chkSwiss.addItemListener(itemListener);
        chkCheddar.addItemListener(itemListener);
        chkProvolone.addItemListener(itemListener);
        chkExtraMeat.addItemListener(itemListener);
        chkExtraCheese.addItemListener(itemListener);

        chkChips.addItemListener(itemListener);
        chkSmallDrink.addItemListener(itemListener);
        chkMediumDrink.addItemListener(itemListener);
        chkLargeDrink.addItemListener(itemListener);

        sizes.addActionListener(actionListener);


        btnAddOrder.addActionListener(e -> {
            StringBuilder order = new StringBuilder();

            // Size and bread and extras
            String sizez = (String) sizes.getSelectedItem();
            String breadz = (String) breads.getSelectedItem();
            String extraMeatz = (String) extraMeats.getSelectedItem();
            String extraCheesez = (String) extraCheese.getSelectedItem();
            String sideSaucez = (String) sideSauce.getSelectedItem();

            order.append(sizez).append(" on ").append(breadz+", ");
            if(chkToasted.isSelected()) order.append(" [Toasted] ");


            // Meats
            ArrayList<String> meats = new ArrayList<>();
            if (btnSteak.isSelected()) meats.add("Steak");
            if (btnHam.isSelected()) meats.add("Ham");
            if (btnRoastBeef.isSelected()) meats.add("Roast Beef");
            if (btnSalami.isSelected()) meats.add("Salami");
            if (btnChicken.isSelected()) meats.add("Chicken");
            if (btnBacon.isSelected()) meats.add("Bacon");
            if (!meats.isEmpty()) order.append(" | Meats: ").append(String.join(", ", meats+", "));


            // Cheeses
            ArrayList<String> cheeses = new ArrayList<>();
            if (chkAmerican.isSelected()) cheeses.add("American");
            if (chkSwiss.isSelected()) cheeses.add("Swiss");
            if (chkCheddar.isSelected()) cheeses.add("Cheddar");
            if (chkProvolone.isSelected()) cheeses.add("Provolone");
            if (!cheeses.isEmpty()) order.append(" | Cheeses and extras: ").append(String.join(", ", cheeses+ ", "));

            // Extras

            if (chkExtraMeat.isSelected())
            order.append(extraMeatz+ ", ");
            if (chkExtraCheese.isSelected())
            order.append(extraCheesez+ ", ");



            // Toppings
            ArrayList<String> toppings = new ArrayList<>();
            if (chkLettuce.isSelected()) toppings.add("Lettuce");
            if (chkPeppers.isSelected()) toppings.add("Peppers");
            if (chkOnions.isSelected()) toppings.add("Onions");
            if (chkTomatoes.isSelected()) toppings.add("Tomatoes");
            if (chkJalapenos.isSelected()) toppings.add("Jalapenos");
            if (chkCucumbers.isSelected()) toppings.add("Cucumbers");
            if (chkPickles.isSelected()) toppings.add("Pickles");
            if (chkGuacamole.isSelected()) toppings.add("Guacamole");
            if (chkMushrooms.isSelected()) toppings.add("Mushrooms");
            if (!toppings.isEmpty()) order.append(" | Toppings: ").append(String.join(", ", toppings));

            // Condiments
            ArrayList<String> condiments = new ArrayList<>();
            if (chkMayo.isSelected()) condiments.add("Mayo");
            if (chkMustard.isSelected()) condiments.add("Mustard");
            if (chkKetchup.isSelected()) condiments.add("Ketchup");
            if (chkRanch.isSelected()) condiments.add("Ranch");
            if (chkThousandIslands.isSelected()) condiments.add("Thousand Islands");
            if (chkVinaigrette.isSelected()) condiments.add("Vinaigrette");
            if (chkAujus.isSelected()) condiments.add("Au Jus");
            if (!condiments.isEmpty()) order.append(" | Condiments: ").append(String.join(", ", condiments +", "));
            order.append( sideSaucez);

            //Drinks, chips, and toasted
            ArrayList<String> extras = new ArrayList<>();
            if(chkSmallDrink.isSelected()) extras.add("Small drink");
            if(chkMediumDrink.isSelected()) extras.add("Medium drink");
            if(chkLargeDrink.isSelected()) extras.add("Large drink");
            if(chkChips.isSelected()) extras.add("Chips");
            if(!extras.isEmpty()) order.append(" | Sides: ").append(String.join(",",extras));



            // Price
            order.append(" | ").append(txtPrice.getText());

            // Add to order list
            orderListModel.addElement(order.toString());
        });

        btnRemoveOrder.addActionListener(e -> {
            int selectedIndex = orderList.getSelectedIndex();
            if (selectedIndex != -1) {
                orderListModel.remove(selectedIndex);
            }
        });



           //Panels and layout

        choicePanel = new JPanel(new GridLayout(3, 1));

        topPanel = new JPanel(new BorderLayout());
        sandwichPanel = new JPanel(new GridLayout(6, 3));
        sandwichPanel.add(new JLabel("Bread:"));
        sandwichPanel.add(breads);
        sandwichPanel.add(new JLabel("Size:"));
        sandwichPanel.add(sizes);
        sandwichPanel.add(btnSteak);
        sandwichPanel.add(btnHam);
        sandwichPanel.add(btnRoastBeef);
        sandwichPanel.add(btnSalami);
        sandwichPanel.add(btnChicken);
        sandwichPanel.add(btnBacon);
        sandwichPanel.add(chkToasted);


            JLabel pricingDetails = new JLabel("Meat:... | Cheese: ... | Extra Cheese: ... | Extra Meat: ..");
            pricingDetails.setHorizontalAlignment(SwingConstants.CENTER);
            topPanel.add(pricingDetails, BorderLayout.SOUTH);

            sizes.addActionListener(selecting -> {
            int i = sizes.getSelectedIndex();
            switch (i) {
                case 0 -> pricingDetails.setText("No options");
                case 1 -> pricingDetails.setText("Meat: $1.00 | Cheese: $0.75 | Extra Cheese: $0.30 | Extra Meat: $0.50");
                case 2 -> pricingDetails.setText("Meat: $2.00 | Cheese: $1.50 | Extra Cheese: $0.60 | Extra Meat: $1.00");
                case 3 -> pricingDetails.setText("Meat: $3.00 | Cheese: $2.25 | Extra Cheese: $0.90 | Extra Meat: $1.50");
            }
        });

        topPanel.add(new JLabel("Sandwich customization", SwingConstants.CENTER),BorderLayout.NORTH);
        topPanel.add(sandwichPanel, BorderLayout.CENTER);
        topPanel.add(btnClearOrder, BorderLayout.WEST);
        topPanel.add(pricingDetails, BorderLayout.SOUTH);

        middlePanel = new JPanel(new BorderLayout());
        cheesePanel = new JPanel(new GridLayout(4, 2));
        cheesePanel.add(chkAmerican);
        cheesePanel.add(chkSwiss);
        cheesePanel.add(chkCheddar);
        cheesePanel.add(chkProvolone);
        cheesePanel.add(chkExtraCheese);
        cheesePanel.add(extraCheese);
        cheesePanel.add(chkExtraMeat);
        cheesePanel.add(extraMeats);
        cheesePanel.add(chkChips);
        cheesePanel.add(chkSmallDrink);
        cheesePanel.add(chkMediumDrink);
        cheesePanel.add(chkLargeDrink);
        middlePanel.add(new JLabel("Cheese and Extras:"), BorderLayout.NORTH);
        middlePanel.add(cheesePanel, BorderLayout.CENTER);

        bottomPanel = new JPanel(new BorderLayout());
        additionalPanel = new JPanel(new GridLayout(3, 3));
        additionalPanel.add(chkLettuce);
        additionalPanel.add(chkPeppers);
        additionalPanel.add(chkOnions);
        additionalPanel.add(chkTomatoes);
        additionalPanel.add(chkJalapenos);
        additionalPanel.add(chkCucumbers);
        additionalPanel.add(chkPickles);
        additionalPanel.add(chkGuacamole);
        additionalPanel.add(chkMushrooms);
        additionalPanel.add(chkMayo);
        additionalPanel.add(chkMustard);
        additionalPanel.add(chkKetchup);
        additionalPanel.add(chkRanch);
        additionalPanel.add(chkThousandIslands);
        additionalPanel.add(chkVinaigrette);
        additionalPanel.add(chkAujus);
        additionalPanel.add(new JLabel("Side sauces:"));
        additionalPanel.add(sideSauce);
        bottomPanel.add(new JLabel("Additional toppings:"), BorderLayout.NORTH);
        bottomPanel.add(additionalPanel, BorderLayout.CENTER);

        choicePanel.add(topPanel);
        choicePanel.add(middlePanel);
        choicePanel.add(bottomPanel);

        JPanel orderControlPanel = new JPanel(new BorderLayout());
        orderControlPanel.add(btnAddOrder, BorderLayout.NORTH);
        orderControlPanel.add(orderScrollPane, BorderLayout.CENTER);
        orderControlPanel.add(btnRemoveOrder, BorderLayout.SOUTH);
        orderControlPanel.add(btnCompleteOrder, BorderLayout.EAST);



        choicePanel.add(orderControlPanel);

        add(choicePanel, BorderLayout.CENTER);
        add(txtPrice, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculateTotalPrice();

    }
    private void calculateTotalPrice() {
        int sizeIndex = sizes.getSelectedIndex();
        double total = baseSandwichPrices[sizeIndex];

        if (btnSteak.isSelected()) total += meatPrices[sizeIndex];
        if (btnHam.isSelected()) total += meatPrices[sizeIndex];
        if (btnRoastBeef.isSelected()) total += meatPrices[sizeIndex];
        if (btnSalami.isSelected()) total += meatPrices[sizeIndex];
        if (btnChicken.isSelected()) total += meatPrices[sizeIndex];
        if (btnBacon.isSelected()) total += meatPrices[sizeIndex];

        if (chkAmerican.isSelected()) total += cheesePrices[sizeIndex];
        if (chkSwiss.isSelected()) total += cheesePrices[sizeIndex];
        if (chkCheddar.isSelected()) total += cheesePrices[sizeIndex];
        if (chkProvolone.isSelected()) total += cheesePrices[sizeIndex];

        if (chkExtraMeat.isSelected()) total += extraMeatPrices[sizeIndex];
        if (chkExtraCheese.isSelected()) total += extraCheesePrices[sizeIndex];

        if(chkChips.isSelected()) total+= 1.50;
        if(chkSmallDrink.isSelected()) total += 2.00;
        if(chkMediumDrink.isSelected()) total += 2.50;
        if (chkLargeDrink.isSelected()) total += 3.00;

        txtPrice.setText(String.format("Total price = $%.2f", total));
    }
    private double calculateAllOrdersTotal() {
        double total = 0.0;
        for (int i = 0; i < orderListModel.size(); i++) {
            String order = orderListModel.get(i);

            int index = order.lastIndexOf("$");
            if (index != -1) {
                try {
                    String pricePart = order.substring(index + 1).trim();
                    total += Double.parseDouble(pricePart);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return total;
    }
    private void clearOrderSelections() {
        // Meats
        btnSteak.setSelected(false);
        btnHam.setSelected(false);
        btnRoastBeef.setSelected(false);
        btnSalami.setSelected(false);
        btnChicken.setSelected(false);
        btnBacon.setSelected(false);

        // Cheeses
        chkAmerican.setSelected(false);
        chkSwiss.setSelected(false);
        chkCheddar.setSelected(false);
        chkProvolone.setSelected(false);

        // Extras
        chkExtraMeat.setSelected(false);
        chkExtraCheese.setSelected(false);
        chkChips.setSelected(false);
        chkSmallDrink.setSelected(false);
        chkMediumDrink.setSelected(false);
        chkLargeDrink.setSelected(false);
        chkToasted.setSelected(false);

        // Toppings
        chkLettuce.setSelected(false);
        chkPeppers.setSelected(false);
        chkOnions.setSelected(false);
        chkTomatoes.setSelected(false);
        chkJalapenos.setSelected(false);
        chkCucumbers.setSelected(false);
        chkPickles.setSelected(false);
        chkGuacamole.setSelected(false);
        chkMushrooms.setSelected(false);

        // Condiments
        chkMayo.setSelected(false);
        chkMustard.setSelected(false);
        chkKetchup.setSelected(false);
        chkRanch.setSelected(false);
        chkThousandIslands.setSelected(false);
        chkVinaigrette.setSelected(false);
        chkAujus.setSelected(false);

        // Reset combo boxes to default
        sizes.setSelectedIndex(0);
        breads.setSelectedIndex(0);
        extraMeats.setSelectedIndex(0);
        extraCheese.setSelectedIndex(0);
        sideSauce.setSelectedIndex(0);

        // Reset the price display
        calculateTotalPrice();
    }









    public static void main(String[] args) {
    SwingUtilities.invokeLater(SandwichBar::new);
}

}




