package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bmicalculator.databinding.ActivityMainBinding;
import com.example.bmicalculator.databinding.ActivityResultBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private double bmiResult = 0;
    private ActivityResultBinding binding;
    private ArrayList<BmiResult> bmiResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        BmiResult bmiResult1 = new BmiResult("UNDERWEIGHT", "You are underweight");
        BmiResult bmiResult2 = new BmiResult("HEALTHY", "You are healthy");
        BmiResult bmiResult3 = new BmiResult("OVERWEIGHT", "You are underweight");
        BmiResult bmiResult4 = new BmiResult("OBESE", "You are obese");
        BmiResult bmiResult5 = new BmiResult("SEVERELY OBESE", "You are severely obese");
        BmiResult bmiResult6 = new BmiResult("MORBIDLY OBESE", "You are morbidly obese");
        bmiResults.add(bmiResult1);
        bmiResults.add(bmiResult2);
        bmiResults.add(bmiResult3);
        bmiResults.add(bmiResult4);
        bmiResults.add(bmiResult5);
        bmiResults.add(bmiResult6);

        Intent intent = getIntent();
        bmiResult = intent.getDoubleExtra("bmiResult", 0);
        binding.txtBmiResult.setText(String.format("%.2f", bmiResult));
        if(bmiResult == 0){
            binding.txtResultTitle.setText(bmiResults.get(1).getTitle());
            binding.txtResultExplanation.setText(bmiResults.get(1).getExplanation());
        }else if (bmiResult < 18.5){
            binding.txtResultTitle.setText(bmiResults.get(0).getTitle());
            binding.txtResultExplanation.setText(bmiResults.get(0).getExplanation());
        }else if (bmiResult <25){
            binding.txtResultTitle.setText(bmiResults.get(1).getTitle());
            binding.txtResultExplanation.setText(bmiResults.get(1).getExplanation());
        }else if (bmiResult < 30){
            binding.txtResultTitle.setText(bmiResults.get(2).getTitle());
            binding.txtResultExplanation.setText(bmiResults.get(2).getExplanation());
        }else if (bmiResult < 35){
            binding.txtResultTitle.setText(bmiResults.get(3).getTitle());
            binding.txtResultExplanation.setText(bmiResults.get(3).getExplanation());
        }else if (bmiResult < 40){
            binding.txtResultTitle.setText(bmiResults.get(4).getTitle());
            binding.txtResultExplanation.setText(bmiResults.get(4).getExplanation());
        }else{
            binding.txtResultTitle.setText(bmiResults.get(5).getTitle());
            binding.txtResultExplanation.setText(bmiResults.get(5).getExplanation());
        }
    }
    public void oncRecalculate(View view) {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}