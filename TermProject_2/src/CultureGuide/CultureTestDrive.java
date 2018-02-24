package CultureGuide;

public class CultureTestDrive {

    public static void main(String[] args) {
        ModelCultureInterface model = new ModelCulture();
        ControllerRestaurantInterface controller = new ControllerRestaurant(model);
    }
}
