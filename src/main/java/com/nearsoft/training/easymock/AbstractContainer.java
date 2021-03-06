package com.nearsoft.training.easymock;

public class AbstractContainer implements Container {
    private int containerTotalVolume;
    private int currentVolume;

    public AbstractContainer(int volume){
        if (volume < 1) throw new IllegalArgumentException("Container's value must be greater than 0.");
        containerTotalVolume = volume;
        currentVolume = volume;
    }

    public boolean getPortion(Portion portion) throws NotEnoughException {
        int delta = currentVolume - portion.size();
        if (delta > -1){
            currentVolume -= portion.size();
            return true;
        } else {
            throw new NotEnoughException("Refill the " + this.getClass().getName());
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getTotalVolume() {
        return containerTotalVolume;
    }

    public void refillContainer() {
        currentVolume = containerTotalVolume;
    }
}
