package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        EditText quantityInput = findViewById(R.id.quantityInput);
        EditText maxValueInput = findViewById(R.id.maxValueInput);
        EditText minValueInput = findViewById(R.id.minValueInput);
        Button generateRandomButton = findViewById(R.id.generateRandomButton);
        LinearLayout randomValuesLayout = findViewById(R.id.randomValuesLayout);

        generateRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomValues(quantityInput, maxValueInput, minValueInput, randomValuesLayout);
            }
        });
    }

    private void generateRandomValues(EditText quantityInput, EditText maxValueInput,
                                      EditText minValueInput, LinearLayout randomValuesLayout) {
        try {
            int quantity = Integer.parseInt(quantityInput.getText().toString());
            int maxValue = Integer.parseInt(maxValueInput.getText().toString());
            int minValue = Integer.parseInt(minValueInput.getText().toString());

            if (quantity <= 0 || minValue >= maxValue) {
                Toast.makeText(this, "Geçersiz giriş değerleri", Toast.LENGTH_SHORT).show();
                return;
            }

            randomValuesLayout.removeAllViews();

            List<Integer> randomValues = generateRandomNumbers(quantity, minValue, maxValue);

            for (int i = 0; i < quantity; i++) {
                TextView textView = new TextView(this);
                textView.setText("Rastgele Değer " + (i + 1) + ": " + randomValues.get(i));
                randomValuesLayout.addView(textView);
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Lütfen geçerli sayılar girin", Toast.LENGTH_SHORT).show();
        }
    }

    private List<Integer> generateRandomNumbers(int quantity, int minValue, int maxValue) {
        List<Integer> randomValues = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < quantity; i++) {
            int randomValue = random.nextInt((maxValue - minValue) + 1) + minValue;
            randomValues.add(randomValue);
        }

        Collections.shuffle(randomValues);

        return randomValues;
    }
}
