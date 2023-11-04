package com.example.myapplication.Function;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class video_bf extends AppCompatActivity {



    private VideoView mVideoView;
    private Button playBtn, stopBtn;
    MediaController mMediaController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_parsing);
        mVideoView = new VideoView(this);
        mVideoView = (VideoView) findViewById(R.id.video);
        mMediaController = new MediaController(this);
        playBtn = (Button) findViewById(R.id.playbutton);
        stopBtn = (Button) findViewById(R.id.stopbutton);
        playBtn.setOnClickListener(new mClick());
        stopBtn.setOnClickListener(new mClick());
    }

    class mClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String uri = "android.resource://" + getPackageName() + "/"+"raw/qwe";  //本地
           // Log.i("qwe", uri);
            //String uri2 = "https://v26.douyinvod.com/44e3a446e7152e1da35a801f3d7dad47/635368ed/video/tos/cn/tos-cn-ve-15c001-alinc2/d0a8c3b2f4244f789f4819adc1ca262b/?a=1128&amp;ch=0&amp;cr=0&amp;dr=0&amp;cd=0%7C0%7C0%7C0&amp;cv=1&amp;br=2302&amp;bt=2302&amp;cs=0&amp;ds=6&amp;ft=raapL0071jevGHhWH6xRZ_snbDUVySYGI78LCTh&amp;mime_type=video_mp4&amp;qs=0&amp;rc=Omg5NmZlZDg5PDg3Njc4PEBpM3g7eTc6ZnFtZzMzNGkzM0AwMl4yYzYzXjYxNjA0LjY0YSNjaDRrcjRnNjZgLS1kLWFzcw%3D%3D&amp;l=2022102210520301020405710034EC00B6&amp;btag=80000&amp;cc=2a";  //网络
            mVideoView.setVideoURI(Uri.parse(uri));  //本地
         //  mVideoView.setVideoURI(Uri.parse(uri2));  //网络
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