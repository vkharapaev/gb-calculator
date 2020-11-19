package javacore.advanced.hw4.task2.android.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import javacore.advanced.hw4.task2.android.ui.main.CalcPresenter;

public class ViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (CalcPresenter.class.equals(modelClass)) {
            return (T) new CalcPresenter();
        }
        throw new RuntimeException("modelClass is not supported");
    }
}
