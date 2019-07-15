package com.mylearning.designpatterns.A0010_Decorator;


public class Milk extends CondimentDecorator {
	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
    public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	@Override
    public double cost() {
		return .10 + beverage.cost();
	}
}
