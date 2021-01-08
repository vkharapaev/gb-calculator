package javacore.advanced.hw4.task2.android;

import org.junit.Test;

import javacore.advanced.hw4.task2.android.expression.InfixExpCreator;

import static org.junit.Assert.assertEquals;

public class InfixExpCreatorTest {

    @Test
    public void bracketsAutoComplete() {
        InfixExpCreator creator = new InfixExpCreator();
        creator.add("(").add("(").add("(").add("5");
        assertEquals("( ( ( 5 ) ) )", creator.toFinalizedString());
    }

    @Test
    public void removingLastOperator() {
        InfixExpCreator creator = new InfixExpCreator();
        creator.add("5").add("+").add("9").add("*");
        assertEquals("5 + 9", creator.toFinalizedString());
    }

    @Test
    public void notAllowedToAddOperand() {
        InfixExpCreator creator = new InfixExpCreator();
        creator.add("5").add("10");
        assertEquals("5", creator.toString());
    }

    @Test
    public void notAllowedToAddOperator() {
        InfixExpCreator creator = new InfixExpCreator();
        creator.add("5").add("+").add("10").add("+").add("*");
        assertEquals("5 + 10", creator.toFinalizedString());
    }

    @Test
    public void notAllowedToAddExtraBracket() {
        InfixExpCreator creator = new InfixExpCreator();
        creator.add("(").add("5").add("+").add("10").add(")").add(")");
        assertEquals("( 5 + 10 )", creator.toString());
    }

    @Test
    public void emptyExpToString() {
        InfixExpCreator creator = new InfixExpCreator();
        assertEquals("", creator.toString());
    }

    @Test
    public void addDecimal() {
        InfixExpCreator creator = new InfixExpCreator();
        creator.add("0.5");
        assertEquals("0.5", creator.toString());
    }

    @Test
    public void removeLeftBrackets() {
        InfixExpCreator creator = new InfixExpCreator();
        creator.add("5").add("+").add("(").add("(").add("(").add("(").add("(");
        assertEquals("5", creator.toFinalizedString());
    }

}
