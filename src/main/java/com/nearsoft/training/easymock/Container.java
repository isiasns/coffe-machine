package com.nearsoft.training.easymock;

public interface Container {
    boolean getPortion(Portion portion) throws NotEnoughException;
    int getCurrentVolume();
    int getTotalVolume();
    void refillContainer();
}
