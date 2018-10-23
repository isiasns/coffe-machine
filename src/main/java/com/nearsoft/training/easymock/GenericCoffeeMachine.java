package com.nearsoft.training.easymock;

public class GenericCoffeeMachine implements CoffeeMachine {
    private Container coffeeContainer;
    private Container waterContainer;

    public GenericCoffeeMachine(Container coffeeContainer, Container waterContainer){
        this.coffeeContainer = coffeeContainer;
        this.waterContainer = waterContainer;
    }

    public boolean makeCoffee(Portion portion) throws NotEnoughException {
        boolean isEnoughCoffee = coffeeContainer.getPortion(portion);
        boolean isEnoughWater = waterContainer.getPortion(portion);
        if (isEnoughCoffee && isEnoughWater){
            return true;
        }
        return false;
    }

    public Container getCoffeeContainer() {
        return coffeeContainer;
    }

    public Container getWaterContainer() {
        return waterContainer;
    }
}
