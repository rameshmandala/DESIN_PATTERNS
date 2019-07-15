package com.mylearning.designpatterns.A0006_SingleTon;

// NOTE: This is not thread safe!
public class Singleton_withoutThreadSafe {
	private static Singleton_withoutThreadSafe uniqueInstance;

	// other useful instance variables here

	private Singleton_withoutThreadSafe() {}

	public static Singleton_withoutThreadSafe getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton_withoutThreadSafe();
		}
		return uniqueInstance;
	}

	// other useful methods here
}
