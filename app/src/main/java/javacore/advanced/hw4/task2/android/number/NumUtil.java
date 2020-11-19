package javacore.advanced.hw4.task2.android.number;

import java.util.regex.Pattern;

public class NumUtil {

    private static final Pattern REGEX_DIGIT = Pattern.compile("[0-9]");
    private static final String DOT = ".";
    private static final String MINUS = "-";

    public static boolean isDigit(String token) {
        return REGEX_DIGIT.matcher(token).matches();
    }

    public static boolean isDot(String token) {
        return DOT.equals(token);
    }

    public static boolean isMinus(String token) {
        return MINUS.equals(token);
    }
}
