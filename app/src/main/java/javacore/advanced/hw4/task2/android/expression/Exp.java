package javacore.advanced.hw4.task2.android.expression;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

import static javacore.advanced.hw4.task2.android.expression.ExpUtil.*;

public class Exp {

    private static final String OP_PLUS = "+";
    private static final String OP_MINUS = "-";
    private static final String OP_MUL = "*";
    private static final String OP_DIV = "/";

    /**
     * Convert an infix expression to postfix expression
     *
     * @param infix An infix expression
     * @return A postfix expression
     */
    public static List<String> convertToPostfix(List<String> infix) {
        Map<String, Integer> priority = new HashMap<>();
        priority.put(OP_PLUS, 1);
        priority.put(OP_MINUS, 1);
        priority.put(OP_MUL, 2);
        priority.put(OP_DIV, 2);
        LinkedList<String> stack = new LinkedList<>();
        List<String> exp = new ArrayList<>();
        for (String token : infix) {
            if (isNum(token)) {
                exp.add(token);

            } else if (isLeftBracket(token)) {
                stack.push(token);

            } else if (isRightBracket(token)) {
                while (!isLeftBracket(stack.peek())) {
                    exp.add(stack.pop());
                }
                stack.pop();

            } else if (isOperator(token)) {
                while (stack.size() > 0 && !isLeftBracket(stack.peek()) &&
                        priority.get(stack.peek()) >= priority.get(token)) {
                    exp.add(stack.pop());
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty()) {
            exp.add(stack.pop());
        }
        return exp;
    }

    /**
     * Calculate a postfix expression
     *
     * @param postfix A postfix expression
     * @return Result of calculation
     */
    public static BigDecimal calc(List<String> postfix) {
        LinkedList<BigDecimal> stack = new LinkedList<>();
        for (String token : postfix) {
            if (isNum(token)) {
                stack.push(new BigDecimal(token));
            } else if (isOperator(token)) {
                BigDecimal second = stack.pop();
                stack.push(calc(stack.pop(), second, token));
            }
        }
        return stack.pop();
    }

    private static BigDecimal calc(BigDecimal first, BigDecimal second, String operator) {
        switch (operator) {
            default:
            case OP_PLUS:
                return first.add(second);
            case OP_MINUS:
                return first.subtract(second);
            case OP_MUL:
                return first.multiply(second);
            case OP_DIV:
                return first.divide(second, MathContext.DECIMAL128);
        }
    }
}
