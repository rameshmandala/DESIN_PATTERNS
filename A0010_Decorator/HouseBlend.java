package com.mylearning.designpatterns.A0010_Decorator;


public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}

	@Override
    public double cost() {
		return .89;
	}
}

