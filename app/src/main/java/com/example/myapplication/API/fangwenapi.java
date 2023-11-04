package com.example.myapplication.API;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myapplication.R;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class fangwenapi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
       // getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fangwenapi);

        EditText bjk1 = findViewById(R.id.bjk1);
        TextView wb1 = findViewById(R.id.wb1);
        Button an1 = findViewById(R.id.an1);
        an1.setOnClickListener(new View.OnClickListener() {//?????????z这个地方

            @Override
            public void onClick(View view)
            {
                String url = "https://xiaobapi.top/api/xb/api/banned_word_detection.php?msg="+bjk1.getText();
                // 创建okhttp3类
                OkHttpClient okhttp3 = new OkHttpClient();
                // 创建表单
                FormBody formBody = new FormBody.Builder()
                        .build();
                // 请求构建
                final Request request = new Request.Builder()
                        .url(url)
                        .post(formBody)
                        .build();
                // 同步请求 并且创建一个新线程
                final Call call = okhttp3.newCall(request);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Response request = call.execute();
                            // 获取字符串参数
                            String re = request.body().string();



                            JSONObject jsonObject1 = JSON.parseObject(re);
                            System.out.println("字符串转成JSON对象: " + jsonObject1);
                            String flag=jsonObject1.getString("data");
                            jsonObject1 = JSON.parseObject(flag);
                            flag=jsonObject1.getString("img_url");
                            System.out.println("===flag值为==="+flag);



                            // ui线程，如果在线程执行ui操作会导致app闪退
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    // 给文本1设置字符
                                    Log.i("tata", re);
                                    wb1.setText(re);
                                }
                            });
                        } catch (Exception e) {
                        }
                    }
                }).start();
            }
        });


    }



}