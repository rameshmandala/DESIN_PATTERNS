package com.mylearning.designpatterns.A0008_strategy;

public class FlyNoWay implements FlyBehavior {
  public void fly() {
    System.out.println("I can't fly");
  }
}

