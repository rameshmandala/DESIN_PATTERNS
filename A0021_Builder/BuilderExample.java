package com.mylearning.designpatterns.A0021_Builder;

/** "Product" */
class Pizza {
	private String dough = "";
	private String sauce = "";
	private String topping = "";

	public void setDough(String dough) {
		this.dough = dough;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}
}

/** "Abstract Builder" */
abstract class PizzaBuilder {
	protected Pizza pizza;

	public Pizza getPizza() {
		return pizza;
	}

	public void createNewPizzaProduct() {
		pizza = new Pizza();
	}

	public abstract void buildDough();

	public abstract void buildSauce();

	public abstract void buildTopping();
}
/** "ConcreteBuilder" */
class HawaiianPizzaBuilder extends PizzaBuilder {
	@Override
    public void buildDough() {
		pizza.setDough("cross");
	}

	@Override
    public void buildSauce() {
		pizza.setSauce("mild");
	}

	@Override
    public void buildTopping() {
		pizza.setTopping("ham+pineapple");
	}
}

/** "ConcreteBuilder" */
class SpicyPizzaBuilder extends PizzaBuilder {
	@Override
    public void buildDough() {
		pizza.setDough("pan baked");
	}

	@Override
    public void buildSauce() {
		pizza.setSauce("hot");
	}

	@Override
    public void buildTopping() {
		pizza.setTopping("pepperoni+salami");
	}
}
/** "Director" */
class Cook {
	private PizzaBuilder pizzaBuilder;

	public void setPizzaBuilder(PizzaBuilder pb) {
		pizzaBuilder = pb;
	}

	public Pizza getPizza() {
		return pizzaBuilder.getPizza();
	}

	public void constructPizza() {
		pizzaBuilder.createNewPizzaProduct();
		pizzaBuilder.buildDough();
		pizzaBuilder.buildSauce();
		pizzaBuilder.buildTopping();
	}
}

/** A given type of pizza being constructed. */
public class BuilderExample {
	public static void main(String[] args) {
		final Cook cook = new Cook();
		final PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
		final PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

		cook.setPizzaBuilder(hawaiianPizzaBuilder);
		cook.constructPizza();

		final Pizza pizza = cook.getPizza();
	}
}
