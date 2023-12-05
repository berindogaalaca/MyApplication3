package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConvertorActivity extends AppCompatActivity {
     @Override
     protected void onCreate(Bundle savedInstanceState){
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_convertor);

          EditText decimalInput = findViewById(R.id.decimalInput);
          Spinner decimalConversionTypeSpinner = findViewById(R.id.decimalConversionTypeSpinner);
          Button convertDecimalButton = findViewById(R.id.convertDecimalButton);
          TextView decimalConversionResult = findViewById(R.id.decimalConversionResultTextView);

          EditText byteInput = findViewById(R.id.byteInput);
          Spinner byteConversionTypeSpinner = findViewById(R.id.byteConversionTypeSpinner);
          Button convertByteButton = findViewById(R.id.convertByteButton);
          TextView byteConversionResult = findViewById(R.id.byteConversionResultTextView);

          EditText celsiusInput = findViewById(R.id.celsiusInput);
          Spinner celsiusConversionTypeSpinner = findViewById(R.id.celsiusConversionTypeSpinner);
          Button convertCelsiusButton = findViewById(R.id.convertCelsiusButton);
          TextView celsiusConversionResult = findViewById(R.id.celsiusConversionResultTextView);

          ArrayAdapter<CharSequence> conversionAdapter = ArrayAdapter.createFromResource(
                  this,
                  R.array.conversion_types,
                  android.R.layout.simple_spinner_item
          );
          conversionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

          ArrayAdapter<CharSequence> celsiusConversionAdapter = ArrayAdapter.createFromResource(
                  this,
                  R.array.celsius_conversion_types,
                  android.R.layout.simple_spinner_item
          );
          celsiusConversionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

          ArrayAdapter<CharSequence> byteConversionAdapter = ArrayAdapter.createFromResource(
                  this,
                  R.array.byte_conversion_types,
                  android.R.layout.simple_spinner_item
          );
          byteConversionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

          decimalConversionTypeSpinner.setAdapter(conversionAdapter);
          byteConversionTypeSpinner.setAdapter(byteConversionAdapter);
          celsiusConversionTypeSpinner.setAdapter(celsiusConversionAdapter);

          convertDecimalButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    performDecimalConversion(decimalInput, decimalConversionTypeSpinner, decimalConversionResult);
               }
          });

          convertByteButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    performByteConversion(byteInput, byteConversionTypeSpinner, byteConversionResult);
               }
          });

          convertCelsiusButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    performCelsiusConversion(celsiusInput, celsiusConversionTypeSpinner, celsiusConversionResult);
               }
          });
     }

     private void performDecimalConversion(
             EditText decimalInput,
             Spinner decimalConversionTypeSpinner,
             TextView decimalConversionResult
     ) {
          try {
               double inputValue = Double.parseDouble(decimalInput.getText().toString());
               int selectedConversionType = decimalConversionTypeSpinner.getSelectedItemPosition();

               String convertedValue;
               switch (selectedConversionType) {
                    case 0:
                         convertedValue = Integer.toBinaryString((int) inputValue);
                         break;
                    case 1:
                         convertedValue = Integer.toOctalString((int) inputValue);
                         break;
                    case 2:
                         convertedValue = Integer.toHexString((int) inputValue);
                         break;
                    default:
                         convertedValue = "Herhangi bir seçenek seçilmedi";
                         break;
               }

               decimalConversionResult.setText("Sonuç: " + convertedValue);

          } catch (NumberFormatException e) {
               Toast.makeText(this, "Lütfen bir değer giriniz", Toast.LENGTH_SHORT).show();
          }
     }

     private void performByteConversion(EditText byteInput, Spinner byteConversionTypeSpinner, TextView byteConversionResult) {
          try {
               double inputValue = Double.parseDouble(byteInput.getText().toString());
               int selectedConversionType = byteConversionTypeSpinner.getSelectedItemPosition();

               String convertedValue;
               switch (selectedConversionType) {
                    case 0:
                         convertedValue = String.valueOf(inputValue * 1024);
                         break;
                    case 1:
                         convertedValue = byteInput.getText().toString();
                         break;
                    case 2:
                         convertedValue = String.valueOf(inputValue / 1024);
                         break;
                    case 3:
                         convertedValue = String.valueOf(inputValue * 8);
                         break;
                    default:
                         convertedValue = "Herhangi bir seçenek seçilmedi";
                         break;
               }

               byteConversionResult.setText("Sonuç : " + convertedValue);

          } catch (NumberFormatException e) {
               Toast.makeText(this, "Lütfen bir sayı değeri giriniz.", Toast.LENGTH_SHORT).show();
          }
     }

     private void performCelsiusConversion(EditText celsiusInput, Spinner celsiusConversionTypeSpinner, TextView celsiusConversionResult) {
          try {
               double inputValue = Double.parseDouble(celsiusInput.getText().toString());
               int selectedConversionType = celsiusConversionTypeSpinner.getSelectedItemPosition();

               String convertedValue;
               switch (selectedConversionType) {
                    case 0:
                         convertedValue = String.valueOf((inputValue * 9 / 5) + 32);
                         break;
                    case 1:
                         convertedValue = String.valueOf(inputValue + 273.15);
                         break;
                    default:
                         convertedValue = "Herhangi bir seçenek seçilmedi";
                         break;
               }

               celsiusConversionResult.setText("Sonuç : " + convertedValue);

          } catch (NumberFormatException e) {
               Toast.makeText(this, "Lütfen bir sayı değeri giriniz.", Toast.LENGTH_SHORT).show();
          }
     }
}
