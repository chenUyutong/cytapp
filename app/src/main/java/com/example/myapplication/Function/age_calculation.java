package com.example.myapplication.Function;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class age_calculation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculation);




        EditText bjk1 = findViewById(R.id.nian);
        EditText bjk2 = findViewById(R.id.yue);
        EditText bjk3 = findViewById(R.id.ri);
        TextView wb1 = findViewById(R.id.fanh);
        Button an1 = findViewById(R.id.button);
        an1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = 0; //由出生日期获得年龄***
                try {
                    age = getAge(parse(bjk1.getText()+"-"+bjk2.getText()+"-"+bjk3.getText()));
                } catch (Exception e) {

                }
                String s1 = age + "";
                wb1.setText(s1);





                /*long time_Birth =getBirth(bjk1.getText()+"-"+bjk2.getText()+"-"+bjk3.getText());
                long time_now = getDate();
                long days = (time_now-time_Birth)/86400000;
                String s1 = days + "";*/

            }
        });



    }



    public static Date parse(String strDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.parse(strDate);

    }



    public static int getAge(Date birthDay) throws Exception {

        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算

            throw new IllegalArgumentException(

                    "The birthDay is before Now.It's unbelievable!");

        }

        int yearNow = cal.get(Calendar.YEAR); //当前年份

        int monthNow = cal.get(Calendar.MONTH); //当前月份

        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期

        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);

        int monthBirth = cal.get(Calendar.MONTH);

        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth; //计算整岁数

        if (monthNow <= monthBirth) {

            if (monthNow == monthBirth) {

                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一

            }else{

                age--;//当前月份在生日之前，年龄减一

            } } return age; }

/*
    public static long getDate() {//获取当前时间距时间原点的毫秒
        Date date = new Date();
        //System.out.println(date);
        long time = date.getTime();
        System.out.println("当前时间距离时间原点"+time+"毫秒");
        return time;
    }
    public static long getBirth(String str) {//键盘输入一个字符串，解析为date类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        try {
            Date date = sdf.parse(str);
            long time = date.getTime();//获取解析后的 相对于原时间的毫秒
            System.out.println("出生时间距离时间原点---"+time+"毫秒");
            return time;
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
*/







}


