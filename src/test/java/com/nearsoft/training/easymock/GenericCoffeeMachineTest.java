package com.nearsoft.training.easymock;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericCoffeeMachineTest {
    CoffeeMachine coffeeMachine;
    Container coffeeContainer;
    Container waterContainer;

    @Before
    public void setUp() throws Exception {
        coffeeContainer = EasyMock.createMock(CoffeeContainer.class);
        waterContainer = EasyMock.createMock(WaterContainer.class);
        coffeeMachine = new GenericCoffeeMachine(coffeeContainer, waterContainer);
    }

    @After
    public void tearDown() throws Exception {
        coffeeContainer = null;
        waterContainer = null;
        coffeeMachine = null;
    }

    @Test
    public void testMakeCoffee() throws NotEnoughException {
        EasyMock.expect(coffeeContainer.getPortion(Portion.LARGE)).andReturn(true);
        EasyMock.replay(coffeeContainer);
        EasyMock.expect(waterContainer.getPortion(Portion.LARGE)).andReturn(true);
        EasyMock.replay(waterContainer);
        assertTrue(coffeeMachine.makeCoffee(Portion.LARGE));
        EasyMock.verify(coffeeContainer);
        EasyMock.verify(waterContainer);
    }

    @Test
    public void testGetCoffeeContainer() {
        assertNotNull(coffeeMachine.getCoffeeContainer());
    }

    @Test
    public void testGetWaterContainer() {
        assertNotNull(coffeeMachine.getWaterContainer());
    }

    @Test
    public void testNotEnoughException() throws NotEnoughException{
        EasyMock.expect(coffeeContainer.getPortion(Portion.LARGE)).andReturn(false);
        EasyMock.replay(coffeeContainer);
        EasyMock.expect(waterContainer.getPortion(Portion.LARGE)).andReturn(true);
        EasyMock.replay(waterContainer);
        assertFalse(coffeeMachine.makeCoffee(Portion.LARGE));
        EasyMock.verify(coffeeContainer);
        EasyMock.verify(waterContainer);
    }
}