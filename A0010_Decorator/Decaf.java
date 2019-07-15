package com.mylearning.designpatterns.A0010_Decorator;


public class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf Coffee";
	}

	@Override
    public double cost() {
		return 1.05;
	}
}

