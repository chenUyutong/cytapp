package com.example.myapplication.start_up;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
    }

    private void initView() {
        SharedPreferences sp=getSharedPreferences("jsj",MODE_PRIVATE);
        boolean is=sp.getBoolean("ok",true);
        //判断是否为第一次打开软件
        if (is){
            SharedPreferences.Editor editor=sp.edit();
            editor.putBoolean("ok",false);
            editor.apply();
            //跳转到引导页
            startActivity(new Intent(StartActivity.this, SplashActivity.class));
            finish();
        }else {
            //直接进入首页
            startActivity(new Intent(StartActivity.this, SplashActivity.class));
            finish();
        }

    }
}