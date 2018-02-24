package CultureGuide;

public class ControllerAirport implements ControllerAirportInterface{
	ModelCulture model;
	ViewCulture view;

	public ControllerAirport(ControllerAirportInterface model){
		this.model = model;
		view = new ViewCulture(this, model);

		view.createView();
		view.createControls();
		//view.disableStopMenuItem();
		//view.disableStartMenuItem();
		model.initialize();
	}

	public void callTaxi(){
		view.
	}

}
