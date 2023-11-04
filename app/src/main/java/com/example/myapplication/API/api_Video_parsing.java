package com.example.myapplication.API;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myapplication.R;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class api_Video_parsing extends AppCompatActivity {


    public static String flag;

    private VideoView mVideoView;
    private Button playBtn, stopBtn;
    MediaController mMediaController;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_api_video_parsing);


            EditText bjk1 = findViewById(R.id.bjk1);
            TextView wb1 = findViewById(R.id.wb1);
            Button an1 = findViewById(R.id.an1);

            mVideoView = new VideoView(this);
            mVideoView = (VideoView) findViewById(R.id.video);
            mMediaController = new MediaController(this);
            playBtn = (Button) findViewById(R.id.playbutton);
            stopBtn = (Button) findViewById(R.id.stopbutton);

            an1.setOnClickListener(new View.OnClickListener() {//?????????z这个地方

                @Override
                public void onClick(View view)
                {
                    String url = "https://xiaoapi.cn/API/zs_dspjx.php?url="+bjk1.getText();

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
                               flag=jsonObject1.getString("url");
                               /* jsonObject1 = JSON.parseObject(flag);
                                flag=jsonObject1.getString("img_url");
                                System.out.println("===flag值为==="+flag);*/



                                // ui线程，如果在线程执行ui操作会导致app闪退
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // 给文本1设置字符
                                        playBtn.setOnClickListener(new api_Video_parsing.mClick());
                                        stopBtn.setOnClickListener(new api_Video_parsing.mClick());
                                        Log.i("tata", flag);
                                       // wb1.setText(flag);
                                    }
                                });
                            } catch (Exception e) {
                            }
                        }
                    }).start();
                }
            });


        }

        class mClick implements View.OnClickListener {
            @Override
            public void onClick(View v) {
               // String uri = "android.resource://" + getPackageName() + "/"+"raw/qwe";  //本地
                // Log.i("qwe", uri);
               // String uri2 = "https://v26.douyinvod.com/44e3a446e7152e1da35a801f3d7dad47/635368ed/video/tos/cn/tos-cn-ve-15c001-alinc2/d0a8c3b2f4244f789f4819adc1ca262b/?a=1128&amp;ch=0&amp;cr=0&amp;dr=0&amp;cd=0%7C0%7C0%7C0&amp;cv=1&amp;br=2302&amp;bt=2302&amp;cs=0&amp;ds=6&amp;ft=raapL0071jevGHhWH6xRZ_snbDUVySYGI78LCTh&amp;mime_type=video_mp4&amp;qs=0&amp;rc=Omg5NmZlZDg5PDg3Njc4PEBpM3g7eTc6ZnFtZzMzNGkzM0AwMl4yYzYzXjYxNjA0LjY0YSNjaDRrcjRnNjZgLS1kLWFzcw%3D%3D&amp;l=2022102210520301020405710034EC00B6&amp;btag=80000&amp;cc=2a";  //网络
               // mVideoView.setVideoURI(Uri.parse(uri));  //本地
                  mVideoView.setVideoURI(Uri.parse(flag));  //网络
                mMediaController.setMediaPlayer(mVideoView);
                mVideoView.setMediaController(mMediaController);
                if (v == playBtn) {
                    mVideoView.start();
                } else if (v == stopBtn) {
                    mVideoView.stopPlayback();
                }
            }
        }




}