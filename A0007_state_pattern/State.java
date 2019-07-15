package com.mylearning.designpatterns.A0007_state_pattern;


public interface State {

	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
