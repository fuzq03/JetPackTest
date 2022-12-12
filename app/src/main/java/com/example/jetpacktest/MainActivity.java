package com.example.jetpacktest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button plusOneBtn;
    TextView infoText;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusOneBtn = findViewById(R.id.plusOneButton);
        infoText = findViewById(R.id.infoText);

        //不需要传参用无参构造函数
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //需要传参的时候用这个
        //viewModel = (MainViewModel) new ViewModelProvider(this, new VmFactory(5)).get(ViewModel.class);
        //注意不能直接创建ViewModel的实例，不然每次活动onCreate()都会创建一个实例，无法保留其中数据
        plusOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.plusOne();
            }
        });
        viewModel.lifeData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.d("change", integer.toString());
                refreshCounter();
            }
        });
        getLifecycle().addObserver(new MyObserver(getLifecycle()));
    }

    private void refreshCounter() {
        infoText.setText(viewModel.lifeData.getValue().toString());
    }

}