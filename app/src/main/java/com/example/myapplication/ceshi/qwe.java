package com.example.myapplication.ceshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhanghao
 * @date 2021/7/7
 */
public class qwe {


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
    public static void main(String args){

        String[] cmds = {"curl", "-H", "Content-Type:application/json","-H", "Authorization: Bearer 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", "-X","POST","--data",
                ""+ "{\"model\": \"text-davinci-003\", \"prompt\": \"你好\", \"temperature\": 0, \"max_tokens\": 7}" +"",
                ""+"https://api.openai.com/v1/completions"+""};
System.out.println(cmds);
//HTTP请求有两个超时时间：一个是连接超时时间，另一个是数据传输的最大允许时间（请求资源超时时间）。 单位秒
        //String[] cmds = {"curl","--connect-timeout","5","m","6", "-H", "Content-Type:application/json", "-X","POST","--data",""+requestJson+"",""+address+""};


        //命令的空格在jva数组里单个的,必须分开写，不能有空格,
        String responseMsg=execCurl(cmds);
        System.out.println("curl===curl"+responseMsg);


    }
}
