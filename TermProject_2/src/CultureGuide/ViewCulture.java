package CultureGuide;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewCulture implements ActionListener, ObserverRestaurant {

    ModelCultureInterface model;
    ControllerRestaurantInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
    JLabel restOutputLabel;
    JFrame controlFrame;
    JPanel controlPanel;
    JLabel destLabel;
    JLabel departLabel;
    JLabel ageLabel;
    JTextField departTextField;
    JTextField destTextField;
    JTextField ageTextField;
    JButton setDepartButton;
    JButton setDestButton;
    JButton getMenuButton;
    JButton orderAlcoholButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JButton setAgeButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;

    public ViewCulture(ControllerRestaurantInterface controller, ModelCultureInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver((ObserverRestaurant) this);
    }

    public void createRestView() {
        // Create all Swing components here
        viewPanel = new JPanel(new GridLayout(3, 2));
        viewFrame = new JFrame("Restaurant");
        getMenuButton = new JButton("Menu");
        
        orderAlcoholButton = new JButton("Alcohol");
        
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 100));
        restOutputLabel = new JLabel("What to do", SwingConstants.CENTER);

        JPanel restPanel = new JPanel(new GridLayout(3, 1));
        //JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        getMenuButton.addActionListener(this);
        orderAlcoholButton.addActionListener(this);

        restPanel.add(restOutputLabel);
        restPanel.add(getMenuButton);
        restPanel.add(orderAlcoholButton);
        viewPanel.add(restPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    public void createRestControls() {
        // Create all Swing components here
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));
        controlPanel = new JPanel(new GridLayout(1, 2));
        menu = new JMenu("Culture Guide");

        departTextField = new JTextField(2);
        departLabel = new JLabel("Enter Departure", SwingConstants.RIGHT);
        setDepartButton = new JButton("Set Where you from");
        setDepartButton.setSize(new Dimension(10, 40));
        destTextField = new JTextField(2);
        destLabel = new JLabel("Enter Destination", SwingConstants.RIGHT);
        setDestButton = new JButton("Set Destination");
        setDestButton.setSize(new Dimension(10, 40));
        ageTextField = new JTextField(2);
        ageLabel = new JLabel("Enter your age", SwingConstants.RIGHT);
        setAgeButton = new JButton("Confirm Age");
        setAgeButton.setSize(new Dimension(10, 40));
        setDestButton.addActionListener(this);
        setAgeButton.addActionListener(this);
        setDepartButton.addActionListener(this);

        JPanel enterPanel = new JPanel(new GridLayout(4, 2));
        enterPanel.add(departLabel);
        enterPanel.add(departTextField);
        enterPanel.add(destLabel);
        enterPanel.add(destTextField);
        enterPanel.add(ageLabel);
        enterPanel.add(ageTextField);
        JPanel insideControlPanel = new JPanel(new GridLayout(4, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setDepartButton);
        insideControlPanel.add(setDestButton);
        insideControlPanel.add(setAgeButton);

        controlPanel.add(insideControlPanel);

        destLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        restOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        controlFrame.getRootPane().setDefaultButton(setDestButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == setDestButton) {
            String whereTo = destTextField.getText();
            model.setArrival(whereTo);
        } else if (event.getSource() == setDepartButton) {
            String whereFrom = departTextField.getText();
            model.setDeparture(whereFrom);         
        } else if (event.getSource() == setAgeButton) {
            int age = Integer.parseInt(ageTextField.getText());
            model.setAge(age);
        } else if (event.getSource() == getMenuButton) {
            controller.getMenu();
        } else if (event.getSource() == orderAlcoholButton) {
            controller.orderAlcohol();         
        }

    }

    public void updateTo() {
        if (model != null) {
            String whereTo = model.getArrival();
            if (whereTo.equals("")) {
                if (restOutputLabel != null) {
                    restOutputLabel.setText("Not on Travel now");
                }
            } else {
                if (restOutputLabel != null) {
                    restOutputLabel.setText("Current Destination: " + model.getArrival());
                }
            }
        }
    }

    public void updateAge() {
        if (model != null) {
            int age = model.getAge();
            if (age == 0) {
                if (restOutputLabel != null) {
                    restOutputLabel.setText("Unknown Age");
                }
            } else {
                if (restOutputLabel != null) {
                    restOutputLabel.setText("Current Age: " + model.getArrival());

                }
            }
        }
    }
}
