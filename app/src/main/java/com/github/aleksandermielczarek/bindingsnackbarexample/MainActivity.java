package com.github.aleksandermielczarek.bindingsnackbarexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.aleksandermielczarek.bindingsnackbarexample.databinding.ActivityMainBinding;

/**
 * Created by Aleksander on 23.04.2016.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainViewModel mainViewModel = new MainViewModel();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mainViewModel);
    }
}
