package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.web.Compass_clock;

public class Mini_games extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_games);




        Button compass_clock = findViewById(R.id.compass_clock);
        // 给按钮设置点击监听
        compass_clock.setOnClickListener(new View.OnClickListener() {//?????????z这个地方
            @Override
            public void onClick(View view)
            {


                Intent intent = new Intent(Mini_games.this, Compass_clock.class);
                Mini_games.this.startActivity(intent);
            }
        });


        Button article_generator = findViewById(R.id.article_generator);
        // 给按钮设置点击监听
        article_generator.setOnClickListener(new View.OnClickListener() {//?????????z这个地方
            @Override
            public void onClick(View view)
            {


                Intent intent = new Intent(Mini_games.this, com.example.myapplication.Function.article_generator.class);
                Mini_games.this.startActivity(intent);
            }
        });






        Button age_calculation = findViewById(R.id.age_calculation);
        // 给按钮设置点击监听
        age_calculation.setOnClickListener(new View.OnClickListener() {//?????????z这个地方
            @Override
            public void onClick(View view)
            {


                Intent intent = new Intent(Mini_games.this, com.example.myapplication.Function. age_calculation.class);
                Mini_games.this.startActivity(intent);
            }
        });
    }
}