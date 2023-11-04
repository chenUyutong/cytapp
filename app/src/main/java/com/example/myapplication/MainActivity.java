package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ciesi.ip;
import com.example.myapplication.fwqxxlook.fwqxxlook;
import com.example.myapplication.ui.Network_API_page;
import com.example.myapplication.ui.toolbox;
import com.example.myapplication.web.WebViewActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        //EditText bjk1 = findViewById(R.id.bjk1);
       // TextView wb1 = findViewById(R.id.wb1);
        String md5=AppSigning.getMD5(MainActivity.this);


        System.out.println("________________________________________"+md5);

        Button an1 = findViewById(R.id.an1);
        Button an2 = findViewById(R.id.an2);
        Button an3 = findViewById(R.id.an3);
        Button an4 = findViewById(R.id.an4);
        Button an5 = findViewById(R.id.an5);
        Button an6 = findViewById(R.id.Network_API);
        // 给按钮设置点击监听
        an1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                ip son=new ip();




                //   System.out.println("\n\n\n\n\n\n\n12"+son.);
                //Intent intent = new Intent(MainActivity.this,  /*Javayouhua*/  WebViewActivity.class);
                //MainActivity.this.startActivity(intent);
            }
        });//ok
        an2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, toolbox.class);
                MainActivity.this.startActivity(intent);
            }
        });

        an3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Network_API_page.class);
                MainActivity.this.startActivity(intent);
            }
        });

        an4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                MainActivity.this.startActivity(intent);


            }
        });

        an5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, fwqxxlook.class);
                MainActivity.this.startActivity(intent);

            }
        });

        an6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Network_API_page.class);
                MainActivity.this.startActivity(intent);

            }
        });
    }

}