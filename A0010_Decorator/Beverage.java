package com.mylearning.designpatterns.A0010_Decorator;

public abstract class Beverage {
	String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
