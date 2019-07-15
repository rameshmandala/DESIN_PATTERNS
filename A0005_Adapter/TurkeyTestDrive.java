package com.mylearning.designpatterns.A0005_Adapter;


public class TurkeyTestDrive {
	public static void main(String[] args) {
		final MallardDuck duck = new MallardDuck();
	 final Turkey duckAdapter = new DuckAdapter(duck);

		for(int i=0;i<10;i++) {
			System.out.println("The DuckAdapter says...");
			duckAdapter.gobble();
			duckAdapter.fly();
		}
	}
}
