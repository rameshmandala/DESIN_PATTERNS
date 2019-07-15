package com.mylearning.designpatterns.A0003_Factory;
public abstract class PizzaStore {

	abstract Pizza createPizza(String item);

	public Pizza orderPizza(String type) {
		final Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
