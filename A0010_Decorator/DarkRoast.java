package com.mylearning.designpatterns.A0010_Decorator;


public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}

	@Override
    public double cost() {
		return .99;
	}
}

