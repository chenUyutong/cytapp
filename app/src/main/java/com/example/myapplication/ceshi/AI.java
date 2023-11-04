package com.example.myapplication.ceshi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);
        Button an1 = findViewById(R.id.an1);


        an1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)   {
            cs a= new cs();
                String[] cmds = {"curl", "-H", "Content-Type:application/json","-H", "Authorization: Bearer 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", "-X","POST","--data",
                        ""+ "{\"model\": \"text-davinci-003\", \"prompt\": \"你好\", \"temperature\": 0, \"max_tokens\": 7}" +"",
                        ""+"https://api.openai.com/v1/completions"+""};
            a.main(cmds);

            }
        });

    }

    //java 调用 Curl的方法
    public static String execCurl(String[] cmds) {
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;
    }


    //接口调用
    public static void qwe(){

        String[] cmds = {"curl", "-H", "Content-Type:application/json","-H", "Authorization: Bearer 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", "-X","POST","--data",
                ""+ "{\"model\": \"text-davinci-003\", \"prompt\": \"你好\", \"temperature\": 0, \"max_tokens\": 7}" +"",
                ""+"https://api.openai.com/v1/completions"+""};

//HTTP请求有两个超时时间：一个是连接超时时间，另一个是数据传输的最大允许时间（请求资源超时时间）。 单位秒
        //String[] cmds = {"curl","--connect-timeout","5","m","6", "-H", "Content-Type:application/json", "-X","POST","--data",""+requestJson+"",""+address+""};

        System.out.println(cmds);
        //命令的空格在jva数组里单个的,必须分开写，不能有空格,
        // 使用Arrays.toString()方法
        System.out.println("-- Arrays.toString() Methods --");
        toStingPringArray(cmds); // 带[]输出一行

        String responseMsg=execCurl(cmds);
        System.out.println("curl===!@#$%^&**&^%$@!@#$%^&*&^%$#@!@#$%^&*&^%$#@!@#$%^&^%$#@#$%^&*&^%$#@#$%^&*^%$#@curl"+responseMsg);


    }
    public static void toStingPringArray(String []arr) {
        System.out.println(Arrays.toString(arr));
    }


}