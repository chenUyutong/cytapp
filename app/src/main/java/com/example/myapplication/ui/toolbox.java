package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Function.age_calculation;
import com.example.myapplication.Function.article_generator;
import com.example.myapplication.Function.jsj;
import com.example.myapplication.R;

public class toolbox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbox);
        Button an1 = findViewById(R.id.an1);//an1.             文章生成器   com.example.myapplication.Function.article_generator
        Button an2 = findViewById(R.id.an2);//an2              生日计算器   com.example.myapplication.Function.age_calculation
        Button an3 = findViewById(R.id.an3);//an3.             计算器    com.example.myapplication.Function.jsj
        Button an4 = findViewById(R.id.an4);//
        Button an5 = findViewById(R.id.an5);
        Button an6 = findViewById(R.id.an6);
        Button an7 = findViewById(R.id.an7);
        Button an8 = findViewById(R.id.an8);
        Button an9 = findViewById(R.id.an9);
        Button an10 = findViewById(R.id.an10);


        an1.setOnClickListener(new View.OnClickListener() {
            //an1.文章生成器   com.example.myapplication.Function.article_generator
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toolbox.this, article_generator.class);
                toolbox.this.startActivity(intent);

            }
        });

        an2.setOnClickListener(new View.OnClickListener() {
            //an2 生日计算器   com.example.myapplication.Function.age_calculation
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toolbox.this, age_calculation.class);
                toolbox.this.startActivity(intent);
            }
        });
        an3.setOnClickListener(new View.OnClickListener() {
            //an3. 计算器    com.example.myapplication.Function.jsj
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(toolbox.this, jsj.class);
                toolbox.this.startActivity(intent);
            }
        });


    }
}