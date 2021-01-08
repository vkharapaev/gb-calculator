package javacore.advanced.hw4.task2.android.ui.main;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import javacore.advanced.hw4.task2.android.interactors.OperationProcessorInteractor;

public class CalcPresenter extends ViewModel implements CalcContract.Presenter {

    private CalcContract.View view;
    private OperationProcessorInteractor opProcessorInteractor;

    public CalcPresenter(OperationProcessorInteractor interactor) {
        opProcessorInteractor = interactor;
    }

    @Override
    public void takeView(CalcContract.View view) {
        this.view = view;

        view.showExpression(opProcessorInteractor.getExpCreator().toString());
        view.show(opProcessorInteractor.getExpCreator().toString());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        view = null;
    }

    @Override
    public void process(String operation) {
        try {
            opProcessorInteractor.process(operation);
            view.show(opProcessorInteractor.getNumCreator().toString());
        } catch (ArithmeticException e) {
            view.show(e.getMessage());
        }
        view.showExpression(opProcessorInteractor.getExpCreator().toString());
    }

}
