package javacore.advanced.hw4.task2.android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import javacore.advanced.hw4.task2.android.ui.main.CalcFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);

        if (state != null) {
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rootLayout, new CalcFragment())
                .commit();
    }
}