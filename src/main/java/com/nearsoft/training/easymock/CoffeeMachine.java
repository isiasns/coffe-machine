package com.nearsoft.training.easymock;

public interface CoffeeMachine {
    boolean makeCoffee(Portion portion) throws NotEnoughException;
    Container getCoffeeContainer();
    Container getWaterContainer();
}
