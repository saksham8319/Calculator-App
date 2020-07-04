package com.example.calci;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText number1;
    EditText number2;
    TextView symbolText;
    TextView resultText;
    Button sumButton;
    Button subtractButton;
    Button divideButton;
    Button multiplyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        symbolText = findViewById(R.id.symbolText);
        resultText = findViewById(R.id.resultText);
        sumButton = findViewById(R.id.sumButton);
        subtractButton = findViewById(R.id.subtractButton);
        divideButton = findViewById(R.id.divideButton);
        multiplyButton = findViewById(R.id.multiplyButton);

        calculator();

    }

    public void calculator() {

        sumButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                symbolText.setText("+");
                double result = 0;
                try {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    result = num1 + num2;
                    resultText.setText(String.valueOf(result));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                symbolText.setText("-");
                double result = 0;
                try {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    result = num1 - num2;
                    resultText.setText(String.valueOf(result));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                symbolText.setText("*");
                double result = 0;
                try {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    result = num1 * num2;
                    resultText.setText(String.valueOf(result));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                symbolText.setText("/");

                double result = 0.0;
                try {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    if (num2 == 0) {
                        resultText.setText(String.valueOf(result));
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    } else {
                        result = num1 / num2;
                        resultText.setText(String.valueOf(result));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });


    }
}