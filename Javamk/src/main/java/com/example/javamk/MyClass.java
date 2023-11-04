package com.example.javamk;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyClass {
    public static void main(String[] args) {
        MyClass c = new MyClass();
        c.a();
    }
    public  void a(){
        String []cmds = {"curl",
                "-H", "Content-Type:application/json",
                "-H", "Authorization: Bearer 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",
                "-X","POST","--data",
                "{\"model\": \"text-davinci-003\", \"prompt\": \"你好\", \"temperature\": 0, \"max_tokens\": 1024}",
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
                System.out.println("\n\n\n\n\n\n\n\n"+line);
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}