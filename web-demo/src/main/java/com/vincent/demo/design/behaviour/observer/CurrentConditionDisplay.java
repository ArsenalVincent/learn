package com.vincent.demo.design.behaviour.observer;

public class CurrentConditionDisplay implements Observer,DisplayElement {
	
	private float temperature;	
	private float humidity;
	
	private Subject weatherData;
	
	public CurrentConditionDisplay(WeatherData weatherData) {
		
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current Conditions: " + temperature
				+ "F degrees and " + humidity + "% humidity" );
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}
	

}
