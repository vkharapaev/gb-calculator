package javacore.advanced.hw4.task2.android.ui.main;


import javacore.advanced.hw4.task2.android.ui.BasePresenter;
import javacore.advanced.hw4.task2.android.ui.BaseView;

class CalcContract {
    interface View extends BaseView<Presenter> {
        /**
         * Show the result of the expression
         *
         * @param text The result of the expression
         */
        void show(String text);

        /**
         * Show the expression
         *
         * @param text The expression
         */
        void showExpression(String text);
    }

    interface Presenter extends BasePresenter<View> {

        /**
         * Get an operation from GUI
         *
         * @param operation An operation
         */
        void process(String operation);
    }
}
