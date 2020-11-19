package javacore.advanced.hw4.task2.android.number;

import java.util.Arrays;
import java.util.LinkedList;

import static javacore.advanced.hw4.task2.android.number.NumUtil.*;

public class NumCreator {

    private static final String DOT = ".";
    private static final String MINUS = "-";

    private final LinkedList<String> number;

    private boolean dot;
    private boolean minus;

    public NumCreator() {
        number = new LinkedList<>();
    }

    /**
     * Add a digit or dot to the number
     *
     * @param token Digit or dot token
     * @return Current number creator
     */
    public NumCreator add(String token) {
        if (isDigit(token)) {
            addToken(token);

        } else if (isDot(token)) {
            addDot();

        } else if (isMinus(token)) {
            addMinus();
        }
        return this;
    }

    private void addMinus() {
        if (!minus && isEmpty()) {
            addToken(MINUS);
            minus = true;
        }
    }

    /**
     * Remove a last digit or dot in the number
     */
    public void removeLast() {
        String last = number.pollLast();
        if (last == null) {

        } else if (isDot(last)) {
            dot = false;

        } else if (isMinus(last)) {
            minus = false;
        }
    }

    private void addDot() {
        String last = number.peekLast();
        if (!isEmpty() && isDigit(last) && !dot) {
            addToken(DOT);
            dot = true;
        }
    }

    private void addToken(String token) {
        number.add(token);
    }

    /**
     * Return whether the number is empty or not
     *
     * @return True - empty, False = not
     */
    public boolean isEmpty() {
        return number.isEmpty();
    }

    /**
     * Return a string representation of this number
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        number.forEach(sb::append);
        return sb.toString();
    }

    /**
     * Reset the number creator
     */
    public void clear() {
        dot = false;
        minus = false;
        number.clear();
    }

    /**
     * Set a new number to this number creator
     *
     * @param newNumber
     */
    public void set(String newNumber) {
        if (newNumber == null) {
            return;
        }
        clear();
        Arrays.stream(newNumber.split(""))
                .forEach(this::add);
    }
}
