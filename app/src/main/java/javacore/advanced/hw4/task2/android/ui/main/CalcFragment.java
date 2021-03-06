package javacore.advanced.hw4.task2.android.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import javacore.advanced.hw4.task2.android.databinding.FragmentCalcBinding;
import javacore.advanced.hw4.task2.android.ui.ViewModelFactory;

public class CalcFragment extends Fragment implements CalcContract.View {

    private FragmentCalcBinding binding;
    private CalcContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCalcBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpWidgets();

        presenter = new ViewModelProvider(requireActivity(), new ViewModelFactory()).get(CalcPresenter.class);

        getLifecycle().addObserver(presenter);
        presenter.takeView(this);
    }

    private void setUpWidgets() {
        for (int i = 0, count = binding.getRoot().getChildCount(); i < count; i++) {
            View child = binding.getRoot().getChildAt(i);
            if (child instanceof Button) {
                Button button = (Button) child;
                String text = button.getText().toString();
                if (text.equals("()")) {
                    button.setOnClickListener((view) -> {
                        presenter.process(")");
                        presenter.process("(");
                    });
                } else {
                    button.setOnClickListener((view) -> presenter.process(text));
                }
            }
        }
    }

    @Override
    public void show(String text) {
        binding.display.setText(text);
    }

    @Override
    public void showExpression(String text) {
        binding.expDislplay.setText(text);
    }
}