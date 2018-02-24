package CultureGuide;

import java.util.*;

/**
 *
 * @author Siqi Wu
 */
public class ModelCulture implements ModelCultureInterface {

    String whereTo;
    String whereFrom;
    int age = 0;
    ArrayList<ObserverRestaurant> observersRestaurant = new ArrayList<ObserverRestaurant>();
    //ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();

    @Override
    public void setArrival(String whereTo) {
        this.whereTo = whereTo;

    }

    @Override
    public void setDeparture(String whereFrom) {
        this.whereFrom = whereFrom;
    }

    @Override
    public void setAge(int age) {
        this.age = age;

        
    }

    public String getArrival() {
        return whereTo;
    }

    public String getDeparture() {
        return whereFrom;
    }

    public int getAge() {
        return age;
    }

    void restaurantEvent() {
        notifyObserversRestaurant();
    }

    public void registerObserver(ObserverRestaurant o) {
        observersRestaurant.add(o);
    }

    public void notifyObserversRestaurant() {
        for (int i = 0; i < observersRestaurant.size(); i++) {
            ObserverRestaurant observer = (ObserverRestaurant) observersRestaurant.get(i);
            //observer.updateFrom();
            observer.updateTo();
            observer.updateAge();

        }
    }

    public void removeObserver(ObserverRestaurant o) {
        int i = observersRestaurant.indexOf(o);
        if (i >= 0) {
            observersRestaurant.remove(i);
        }
    }

}
