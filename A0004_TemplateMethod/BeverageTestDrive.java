package com.mylearning.designpatterns.A0004_TemplateMethod;


public class BeverageTestDrive {
	public static void main(String[] args) {

		final Tea tea = new Tea();
		final Coffee coffee = new Coffee();

		System.out.println("\nMaking tea...");
		tea.prepareRecipe();

		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();


		final TeaWithHook teaHook = new TeaWithHook();
		final CoffeeWithHook coffeeHook = new CoffeeWithHook();

		System.out.println("\nMaking tea...");
		teaHook.prepareRecipe();

		System.out.println("\nMaking coffee...");
		coffeeHook.prepareRecipe();
	}
}
