package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.API.Color_Font;
import com.example.myapplication.R;

public class Network_API_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_api_page);
        Button an1 = findViewById(R.id.an1);
        Button an2 = findViewById(R.id.an2);
        Button an3 = findViewById(R.id.an3);
        Button an4 = findViewById(R.id.an4);
        Button an5 = findViewById(R.id.an5);
        an1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Network_API_page.this, Color_Font.class);
                Network_API_page.this.startActivity(intent);
            }
        });

        an2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Network_API_page.this, Color_Font.class);
                Network_API_page.this.startActivity(intent);
            }
        });
        an3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Network_API_page.this, toolbox.class);
                Network_API_page.this.startActivity(intent);
            }
        });

        an4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Network_API_page.this, Mini_games.class);
                Network_API_page.this.startActivity(intent);
            }
        });
    }
}