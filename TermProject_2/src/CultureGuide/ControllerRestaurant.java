package CultureGuide;

import javax.swing.JOptionPane;

public class ControllerRestaurant implements ControllerRestaurantInterface {

    ModelCultureInterface model;
    ViewCulture view;

    public ControllerRestaurant(ModelCultureInterface model) {
        this.model = model;
        view = new ViewCulture(this, model);
        view.createRestView();
        view.createRestControls();

    }

    public void orderAlcohol() {
        if (model.getArrival().equals("US") && model.getAge() <= 21) {
            JOptionPane.showMessageDialog(null, "You cannot purchase Alcohol in the US under 21", "Enjoy your alcohol", JOptionPane.INFORMATION_MESSAGE);
        } else if (model.getArrival().equals("India") && model.getAge() <= 18) {
            JOptionPane.showMessageDialog(null, "You cannot purchase Alcohol in India under 18", "Enjoy your alcohol", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void getMenu() {
        if (model.getDeparture().equals("US") && model.getArrival().equals("China")) {
            JOptionPane.showMessageDialog(null, "Here is your English Menu", "Enjoy your Meal", JOptionPane.INFORMATION_MESSAGE);
        } else if (model.getDeparture().equals("China") && model.getArrival().equals("US")) {
            JOptionPane.showMessageDialog(null, "Here is your Chinese Menu", "Enjoy your Meal", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
