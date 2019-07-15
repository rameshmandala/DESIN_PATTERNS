package com.mylearning.designpatterns.A0002_Observer;

public class WeatherStation {

	public static void main(String[] args) {
		final WeatherData weatherData = new WeatherData();

		final CurrentConditionsDisplay currentDisplay =
			new CurrentConditionsDisplay(weatherData);
		final StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		final ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);


		weatherData.setMeasurements(80, 65, 30.4f);
		//weatherData.setMeasurements(82, 70, 29.2f);
		//weatherData.setMeasurements(78, 90, 29.2f);
	}
}
