package CultureGuide;

public interface ModelCultureInterface {
	void setArrival(String arival);
	void setDeparture(String whereTo);
	void setAge(int age);
	String getArrival();
	String getDeparture();
	int getAge();
	void registerObserver(ObserverRestaurant o);
	void removeObserver(ObserverRestaurant o);
}
