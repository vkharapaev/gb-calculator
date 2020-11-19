package javacore.advanced.hw4.task2.android;


import org.junit.Test;

import javacore.advanced.hw4.task2.android.number.NumCreator;

import static org.junit.Assert.assertEquals;

public class NumCreatorTest {

    @Test
    public void notAllowedDoubleDot() {
        NumCreator creator = new NumCreator();
        creator.add("1").add(".").add(".").add("9");
        assertEquals("1.9", creator.toString());
    }

    @Test
    public void removeAndAddDot() {
        NumCreator creator = new NumCreator();
        creator.add("1").add(".");
        creator.removeLast();
        creator.add(".").add("9");
        assertEquals("1.9", creator.toString());
    }
}
