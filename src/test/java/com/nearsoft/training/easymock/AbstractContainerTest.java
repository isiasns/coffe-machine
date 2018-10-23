package com.nearsoft.training.easymock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractContainerTest {

    Container waterContainer;
    private final static int VOLUME = 10;

    @Before
    public void setUp() throws Exception {
        waterContainer = new WaterContainer(VOLUME);
    }

    @After
    public void tearDown() throws Exception {
        waterContainer = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbstractContainer(){
        waterContainer = new WaterContainer(0);
    }

    @Test
    public void testGetPortion() throws NotEnoughException {
        int expectedCurrentVolume = VOLUME;
        waterContainer.getPortion(Portion.SMALL);
        expectedCurrentVolume -= Portion.SMALL.size();
        assertEquals("Calculation for the SMALL portion is incorrect", expectedCurrentVolume, waterContainer.getCurrentVolume());
        waterContainer.getPortion(Portion.MEDIUM);
        expectedCurrentVolume -= Portion.MEDIUM.size();
        assertEquals("Calculation for the SMALL portion is incorrect", expectedCurrentVolume, waterContainer.getCurrentVolume());
        waterContainer.getPortion(Portion.LARGE);
        expectedCurrentVolume -= Portion.LARGE.size();
        assertEquals("Calculation for the SMALL portion is incorrect", expectedCurrentVolume, waterContainer.getCurrentVolume());
    }

    @Test(expected = NotEnoughException.class)
    public void testNotEnoughException() throws NotEnoughException {
        waterContainer.getPortion(Portion.LARGE);
        waterContainer.getPortion(Portion.LARGE);
        waterContainer.getPortion(Portion.LARGE);
        waterContainer.getPortion(Portion.LARGE);
    }

    @Test
    public void testGetCurrentVolume() {
        assertEquals("Current volume has incorrect value", VOLUME, waterContainer.getCurrentVolume());
    }

    @Test
    public void testGetTotalVolume() {
        assertEquals("Total volume has incorrect value", VOLUME, waterContainer.getTotalVolume());
    }

    @Test
    public void testRefillContainer() throws NotEnoughException {
        waterContainer.getPortion(Portion.SMALL);
        waterContainer.refillContainer();
        assertEquals("Current volume has incorrect value", VOLUME, waterContainer.getCurrentVolume());
    }
}