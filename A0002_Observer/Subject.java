package com.mylearning.designpatterns.A0002_Observer;
public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
