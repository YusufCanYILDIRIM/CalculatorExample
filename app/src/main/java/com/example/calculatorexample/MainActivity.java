package com.example.calculatorexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button bolme, carpma, cikarma, toplama, result, clear;

    Float firstNumber, secondNumber;
    String operator = ""; // Kullanıcının seçtiği işlem türü saklanacak.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Arayüz bileşenlerini tanımlama
        txtResult = findViewById(R.id.txtResult);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        bolme = findViewById(R.id.bolme);
        carpma = findViewById(R.id.carpma);
        cikarma = findViewById(R.id.cikarma);
        toplama = findViewById(R.id.toplama);
        result = findViewById(R.id.result);
        clear = findViewById(R.id.clear);

        // Rakam butonlarına tıklanınca ekrana yazdıran fonksiyon
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                txtResult.setText(txtResult.getText().toString() + clickedButton.getText().toString());
            }
        };

        // Tüm sayı butonlarına aynı ClickListener atanıyor
        btn0.setOnClickListener(numberClickListener);
        btn1.setOnClickListener(numberClickListener);
        btn2.setOnClickListener(numberClickListener);
        btn3.setOnClickListener(numberClickListener);
        btn4.setOnClickListener(numberClickListener);
        btn5.setOnClickListener(numberClickListener);
        btn6.setOnClickListener(numberClickListener);
        btn7.setOnClickListener(numberClickListener);
        btn8.setOnClickListener(numberClickListener);
        btn9.setOnClickListener(numberClickListener);

        // İşlem butonlarına basıldığında yapılacak işlemler
        toplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Float.parseFloat(txtResult.getText().toString());
                operator = "+";
                txtResult.setText(""); // Yeni giriş için ekranı temizleme
            }
        });

        cikarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Float.parseFloat(txtResult.getText().toString());
                operator = "-";
                txtResult.setText("");
            }
        });

        carpma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Float.parseFloat(txtResult.getText().toString());
                operator = "*";
                txtResult.setText("");
            }
        });

        bolme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Float.parseFloat(txtResult.getText().toString());
                operator = "/";
                txtResult.setText("");
            }
        });

        // Sonucu hesaplama butonu
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondNumber = Float.parseFloat(txtResult.getText().toString());
                float resultValue = 0;

                switch (operator) {
                    case "+":
                        resultValue = firstNumber + secondNumber;
                        break;
                    case "-":
                        resultValue = firstNumber - secondNumber;
                        break;
                    case "*":
                        resultValue = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber != 0) {
                            resultValue = firstNumber / secondNumber;
                        } else {
                            txtResult.setText("Hata! 0'a bölme");
                            return;
                        }
                        break;
                }

                txtResult.setText(String.valueOf(resultValue)); // Sonucu ekrana yazdırma
            }
        });

        // Temizleme butonu
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("");
                firstNumber = 0f;
                secondNumber = 0f;
                operator = "";
            }
        });

    }
}
