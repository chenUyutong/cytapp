package com.example.myapplication.ceshi;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cs {
    public static void main(String[] args) {
        cs c = new cs();
        c.a();
    }
    public  void a(){
        String []cmds = {"curl",
                "-H", "Content-Type:application/json",
                "-H", "Authorization: Bearer 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",
                "-X","POST","--data",
                "{\"model\": \"text-davinci-003\", \"prompt\": \"写一个故事\", \"temperature\": 0, \"max_tokens\": 1024}",
                "https://api.openai.com/v1/completions"};
        ProcessBuilder pb=new ProcessBuilder(cmds);
        pb.redirectErrorStream(true);
        Process p;
        try {
            p = pb.start();
            BufferedReader br=null;
            String line=null;

            br=new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((line=br.readLine())!=null){
                System.out.println("\t"+line);
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}