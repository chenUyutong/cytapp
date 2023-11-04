package com.example.myapplication.Function;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class jsj extends AppCompatActivity {
    private TextView DisplayBox;
    private Button Number0, Number1, Number2, Number3, Number4, Number5, Number6, Number7, Number8, Number9;
    private Button Add, Subtract, Multiply, Divide, Equal;// + - * / =
    private Button Reset, Point;
    double num1 = 0, num2 = 0;//第一次输入的数和第二次输入的数
    double result = 0;//存放运算结果
    int Operator;//用于判断是那个运算符




    //private String str1,str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        DisplayBox = (TextView) findViewById(R.id.Show);

        Number0 = (Button) findViewById(R.id.Number0);
        Number1 = (Button) findViewById(R.id.Number1);
        Number2 = (Button) findViewById(R.id.Number2);
        Number3 = (Button) findViewById(R.id.Number3);
        Number4 = (Button) findViewById(R.id.Number4);
        Number5 = (Button) findViewById(R.id.Number5);
        Number6 = (Button) findViewById(R.id.Number6);
        Number7 = (Button) findViewById(R.id.Number7);
        Number8 = (Button) findViewById(R.id.Number8);
        Number9 = (Button) findViewById(R.id.Number9);

        Add = (Button) findViewById(R.id.Add);
        Subtract = (Button) findViewById(R.id.Subtract);
        Multiply = (Button) findViewById(R.id.Multiply);
        Divide = (Button) findViewById(R.id.Divide);
        Equal = (Button) findViewById(R.id.Equal);

        Reset = (Button) findViewById(R.id.Clear);
        Point = (Button) findViewById(R.id.Point);

        SetListen();

    }

    public void SetListen() {
        OnClick onClick = new OnClick();
        Number0.setOnClickListener(onClick);
        Number1.setOnClickListener(onClick);
        Number2.setOnClickListener(onClick);
        Number3.setOnClickListener(onClick);
        Number4.setOnClickListener(onClick);
        Number5.setOnClickListener(onClick);
        Number6.setOnClickListener(onClick);
        Number7.setOnClickListener(onClick);
        Number8.setOnClickListener(onClick);
        Number9.setOnClickListener(onClick);
        Point.setOnClickListener(onClick);

        Add.setOnClickListener(onClick);
        Subtract.setOnClickListener(onClick);
        Multiply.setOnClickListener(onClick);
        Divide.setOnClickListener(onClick);

        Equal.setOnClickListener(onClick);
        Reset.setOnClickListener(onClick);

    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.Clear:
                    DisplayBox.setText(null);
                    break;
                case R.id.Number0:
                    String str0 = DisplayBox.getText().toString().trim();
                    str0 += "0";
                    DisplayBox.setText(str0);
                    break;
                case R.id.Number1:
                    String str1 = DisplayBox.getText().toString().trim();
                    str1 += "1";
                    DisplayBox.setText(str1);
                    break;
                case R.id.Number2:
                    String str2 = DisplayBox.getText().toString().trim();
                    str2 += "2";
                    DisplayBox.setText(str2);
                    break;
                case R.id.Number3:
                    String str3 = DisplayBox.getText().toString().trim();
                    str3 += "3";
                    DisplayBox.setText(str3);
                    break;
                case R.id.Number4:
                    String str4 = DisplayBox.getText().toString().trim();
                    str4 += "4";
                    DisplayBox.setText(str4);
                    break;
                case R.id.Number5:
                    String str5 = DisplayBox.getText().toString().trim();
                    str5 += "5";
                    DisplayBox.setText(str5);
                    break;
                case R.id.Number6:
                    String str6 = DisplayBox.getText().toString().trim();
                    str6 += "6";
                    DisplayBox.setText(str6);
                    break;
                case R.id.Number7:
                    String str7 = DisplayBox.getText().toString().trim();
                    str7 += "7";
                    DisplayBox.setText(str7);
                    break;
                case R.id.Number8:
                    String str8 = DisplayBox.getText().toString().trim();
                    str8 += "8";
                    DisplayBox.setText(str8);
                    break;
                case R.id.Number9:
                    String str9 = DisplayBox.getText().toString().trim();
                    str9 += "9";
                    DisplayBox.setText(str9);
                    break;
                case R.id.Point:
                    String point = DisplayBox.getText().toString().trim();
                    point += ".";
                    DisplayBox.setText(point);
                    break;

                case R.id.Add:
                    String add = DisplayBox.getText().toString().trim();
                    if (add.equals(null)) {
                        return;
                    }
                    try {
                        num1 = Double.valueOf(add);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    add += "+";
                    DisplayBox.setText(null);
                    Operator = 1;
                    break;
                case R.id.Subtract:
                    String subtract = DisplayBox.getText().toString().trim();
                    if (subtract.equals(null)) {
                        return;
                    }
                    try {
                        num1 = Double.valueOf(subtract);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    subtract += "-";
                    DisplayBox.setText(null);
                    Operator = 2;
                    break;
                case R.id.Multiply:
                    String multiply = DisplayBox.getText().toString().trim();
                    if (multiply.equals(null)) {
                        return;
                    }
                    try {
                        num1 = Double.valueOf(multiply);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    multiply += "*";
                    DisplayBox.setText(null);
                    Operator = 3;
                    break;
                case R.id.Divide:
                    String divide = DisplayBox.getText().toString().trim();
                    if (divide.equals(null)) {
                        return;
                    }
                    try {
                        num1 = Double.valueOf(divide);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    divide += "/";
                    DisplayBox.setText(null);
                    Operator = 4;
                    break;
                case R.id.Equal:
                    String equal = DisplayBox.getText().toString().trim();
                    try {
                        num2 = Double.valueOf(equal);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    DisplayBox.setText(equal);
                    switch (Operator) {
                        case 1:
                            result = num1 + num2;
                            DisplayBox.setText(num1 + "+" + num2 + "=" + result);
                            break;
                        case 2:
                            result = num1 - num2;
                            DisplayBox.setText(num1 + "-" + num2 + "=" + result);
                            break;
                        case 3:
                            result = num1 * num2;
                            DisplayBox.setText(num1 + "*" + num2 + "=" + result);
                            break;
                        case 4:
                            if (num2 == 0) {
                                DisplayBox.setText("0");
                            } else {
                                result = num1 / num2;
                                DisplayBox.setText(num1 + "/" + num2 + "=" + result);
                            }
                            break;

                    }
                    break;
                default:
                    result = 0;
                    break;
            }
        }
    }
}
