package javacore.advanced.hw4.task2.android.ui;

import androidx.lifecycle.LifecycleObserver;

public interface BasePresenter<T> extends LifecycleObserver {

    /**
     * Set a view to a presenter
     *
     * @param view The view associated with this presenter
     */
    void takeView(T view);
}
