package com.example.livedata_viewmodel_example2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button minusButton1;
    private Button minusButton2;
    private Button plusButton1;
    private Button plusButton2;
    private TextView text1;
    private TextView text2;

    CustomViewModel viewModel;
    CustomViewModel viewModel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initViewModel();
        clickable();
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(MainActivity.this).get(CustomViewModel.class);
        viewModel.getLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                text1.setText(String.valueOf(integer));
            }
        });
        viewModel2 = ViewModelProviders.of(MainActivity.this).get(CustomViewModel.class);
        viewModel2.getLiveData2().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                text2.setText(String.valueOf(integer));
            }
        });
    }

    private void init() {
        minusButton1 = findViewById(R.id.minus1);
        minusButton2 = findViewById(R.id.minus2);
        plusButton1 = findViewById(R.id.plus1);
        plusButton2 = findViewById(R.id.plus2);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
    }

    private void clickable() {

        minusButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.decrement1();
            }
        });

        minusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel2.decrement2();
            }
        });

        plusButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.increment1();
            }
        });

        plusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel2.increment2();
            }
        });
    }

}
