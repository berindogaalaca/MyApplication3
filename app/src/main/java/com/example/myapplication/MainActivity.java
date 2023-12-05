package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userInfoTextView = findViewById(R.id.userInfoTextView);
        userInfoTextView.setText("Berin Doga Alaca");

        TextView userInfoTextView2 = findViewById(R.id.userInfoTextView2);
        userInfoTextView2.setText("201913709002");

        Button convertorButton = findViewById(R.id.convertorButton);
        convertorButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConvertorActivity.class);
            startActivity(intent);
        });

        Button randomButton = findViewById(R.id.randomButton);
        randomButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RandomActivity.class);
            startActivity(intent);
        });

        Button smsButton = findViewById(R.id.smsButton);
        smsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SMSActivity.class);
            startActivity(intent);
        });
    }
}
