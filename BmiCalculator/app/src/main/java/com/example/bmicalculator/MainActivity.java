package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;

import com.example.bmicalculator.databinding.ActivityMainBinding;
import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean isFemale = true;
    private int height = 185;
    private int age = 30;
    private int weight = 60;
    private double bmiResult = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.heightSlider.setValue(height);
        binding.heightSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                binding.txtHeightValue.setText(String.valueOf((int) value));
                height = (int) value;
            }
        });

        binding.txtWeightValue.setText(String.valueOf(weight));
        binding.txtAgeValue.setText(String.valueOf(age));
        if (isFemale) {
            binding.imgFemale.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.white));
            binding.txtFemale.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        }

    }

    public void oncGenderFemale(View view) {
        binding.imgFemale.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.white));
        binding.txtFemale.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        binding.imgMale.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.labelTextColor));
        binding.txtMale.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.labelTextColor));
        isFemale = true;
    }

    public void oncGenderMale(View view) {
        binding.imgMale.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.white));
        binding.txtMale.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        binding.imgFemale.setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.labelTextColor));
        binding.txtFemale.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.labelTextColor));
        isFemale = false;
    }

    public void oncBtnWeightPlus(View view) {
        if (weight < 250) {
            weight++;
            binding.txtWeightValue.setText(String.valueOf(weight));
        }
    }

    public void oncBtnWeightMinus(View view) {
        if (weight > 0) {
            weight--;
            binding.txtWeightValue.setText(String.valueOf(weight));
        }

    }

    public void oncBtnAgeMinus(View view) {
        if (age > 0) {
            age--;
            binding.txtAgeValue.setText(String.valueOf(age));
        }
    }

    public void oncBtnAgePlus(View view) {
        if (age < 130) {
            age++;
            binding.txtAgeValue.setText(String.valueOf(age));
        }
    }

    public void oncCalculateBmi(View view) {
        double heightCm = (double) height / 100;
        bmiResult = weight / (heightCm * heightCm);
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("bmiResult", bmiResult);
        startActivity(intent);
        finish();
    }
}