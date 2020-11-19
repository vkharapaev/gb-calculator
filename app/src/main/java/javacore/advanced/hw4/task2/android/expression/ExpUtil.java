package javacore.advanced.hw4.task2.android.expression;

import java.util.regex.Pattern;

public class ExpUtil {
    private static final Pattern REGEX_NUMBERS = Pattern.compile("[\\-+]?[0-9]+\\.?[0-9]*");
    private static final Pattern REGEX_OPERATORS = Pattern.compile("[-+/*]");
    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";

    public static boolean isNum(String token) {
        return REGEX_NUMBERS.matcher(token).matches();
    }

    public static boolean isLeftBracket(String token) {
        return LEFT_BRACKET.equals(token);
    }

    public static boolean isRightBracket(String token) {
        return RIGHT_BRACKET.equals(token);
    }

    public static boolean isOperator(String token) {
        return REGEX_OPERATORS.matcher(token).matches();
    }
}
