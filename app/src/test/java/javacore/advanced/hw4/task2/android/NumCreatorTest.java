package javacore.advanced.hw4.task2.android;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import javacore.advanced.hw4.task2.android.number.NumCreator;

import static org.junit.Assert.assertEquals;

public class NumCreatorTest {

    NumCreator creator;

    @Before
    public void setUp() {
        creator = new NumCreator();
    }

    @Test
    public void addDotNotAllowIfEmptyNum() {
        creator.add(".");
        assertEquals("", creator.toString());
    }

    @Test
    public void notAllowedDoubleDot() {
        creator.add("1").add(".").add(".").add("9");
        assertEquals("1.9", creator.toString());
    }

    @Test
    public void removeAndAddDot() {
        creator.add("1").add(".");
        creator.removeLast();
        creator.add(".").add("9");
        assertEquals("1.9", creator.toString());
    }

    @Test
    public void changeSign() {
        creator.add("1").add(".").add(".").add("9");
        creator.changeSign();
        assertEquals("-1.9", creator.toString());
        creator.changeSign();
        assertEquals("1.9", creator.toString());
    }

    @Test
    public void changeSignIfEmptyNum() {
        creator.changeSign();
        assertEquals("-", creator.toString());
        creator.changeSign();
        assertEquals("", creator.toString());
    }

}
