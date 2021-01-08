package javacore.advanced.hw4.task2.android.interactors;

import javacore.advanced.hw4.task2.android.expression.InfixExpCreator;
import javacore.advanced.hw4.task2.android.number.NumCreator;

public interface OperationProcessorInteractor {
    void process(String operator);

    InfixExpCreator getExpCreator();

    NumCreator getNumCreator();
}
