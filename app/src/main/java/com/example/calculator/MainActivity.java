package com.example.calculator;

import static com.example.calculator.R.id.Add;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Defining the Views
    EditText Num1;
    EditText Num2;
    Button Add;
    Button Sub;
    Button Mul;
    Button Div;
    Button Sin;
    Button Cos;
    Button Tan;
    Button Square;
    Button Power;
    Button Sqrt;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referring the Views
        Num1 = findViewById(R.id.editText1);
        Num2 = findViewById(R.id.editText2);
        Add = findViewById(R.id.Add);
        Sub = findViewById(R.id.Sub);
        Mul = findViewById(R.id.Mul);
        Div = findViewById(R.id.Div);
        Sin = findViewById(R.id.Sin);
        Cos = findViewById(R.id.Cos);
        Tan = findViewById(R.id.Tan);
        Square = findViewById(R.id.Square);
        Power = findViewById(R.id.Power);
        Sqrt = findViewById(R.id.Sqrt);
        Result = findViewById(R.id.textView);

        // set a listener
        Add.setOnClickListener(this);
        Sub.setOnClickListener(this);
        Mul.setOnClickListener(this);
        Div.setOnClickListener(this);
        Sin.setOnClickListener(this);
        Cos.setOnClickListener(this);
        Tan.setOnClickListener(this);
        Square.setOnClickListener(this);
        Power.setOnClickListener(this);
        Sqrt.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        double num1;
        double num2;
        double result;
        String oper = "";

        // check if the fields are empty
        if (TextUtils.isEmpty(Num1.getText().toString()) || TextUtils.isEmpty(Num2.getText().toString()))
            return;

        // read EditText and fill variables with numbers
        num1 = Double.parseDouble(Num1.getText().toString());
        num2 = Double.parseDouble(Num2.getText().toString());

        // Get the ID of the clicked view
        int viewId = v.getId();

        // Check which button was clicked and perform the corresponding operation
        if (viewId == R.id.Add) {
            oper = "+";
            result = num1 + num2;
        } else if (viewId == R.id.Sub) {
            oper = "-";
            result = num1 - num2;
        } else if (viewId == R.id.Mul) {
            oper = "*";
            result = num1 * num2;
        } else if (viewId == R.id.Div) {
            oper = "/";
            result = num1 / num2;
        } else if (viewId == R.id.Sin) {
            oper = "sin";
            result = Math.sin(num1);
        } else if (viewId == R.id.Cos) {
            oper = "cos";
            result = Math.cos(num1);
        } else if (viewId == R.id.Tan) {
            oper = "tan";
            result = Math.tan(num1);
        } else if (viewId == R.id.Square) {
            oper = "squared";
            result = num1 * num1;
        } else if (viewId == R.id.Power) {
            oper = "^";
            result = Math.pow(num1, num2);
        } else if (viewId == R.id.Sqrt) {
            oper = "sqrt";
            result = Math.sqrt(num1);
        } else {
            // Default case if none of the buttons were clicked
            result = 0;
        }

        // Display the result
        Result.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
}