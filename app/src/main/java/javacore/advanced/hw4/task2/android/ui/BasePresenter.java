package javacore.advanced.hw4.task2.android.ui;

public interface BasePresenter<T> {

    /**
     * Set a view to a presenter
     *
     * @param view The view associated with this presenter
     */
    void takeView(T view);
}
