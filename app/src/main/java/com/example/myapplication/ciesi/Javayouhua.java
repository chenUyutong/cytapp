package com.example.myapplication.ciesi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Javayouhua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javayouhua);

        EditText bjk1 = findViewById(R.id.bjk1);



        bjk1.setOnClickListener(new View.OnClickListener() {//?????????z这个地方
            @Override
            public void onClick(View view)
            {
                String code = "public  \n" +
                        " class                                                                  in  \n" +
                        "    " +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "{public \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        \n" +
                        "        static  \n" +
                        "        \n" +
                        "     void main\n" +
                        "     (String[  \n" +
                        "     \n" +
                        "              \n" +
                        "              ] args) \n" +
                        "  {\n" +
                        "                    System.\n" +
                        "        out.println\n" +
                        "                                                                                                (\n" +
                        "                                                                                                \n" +
                        "                                                                                                \n" +
                        "                                                                                                \n" +
                        "                                                                                  \"hello world\" )\n" +
                        "                                                                                  \n" +
                        "                                                                  ;\n" +
                        "                                                                                              \\u0053\\u0079\\u0073\\u0074\\u0065\\u006d\\u002e\\u006f\\u0075\\u0074\\u002e\\u0070\\u0072\\u0069\\u006e\\u006c\\u006e\\u0028\\u0022\\u0068\\u0065\\u006e\\u0063\\u0065\\u0022\\u0029\\u003b\n" +
                        "         }\n" +
                        "}";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {


                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    // 给文本1设置字符
                                    String t = beautiful(""+bjk1.getText());
                                    System.out.println(t+"\n\n\n\n\n\n\n\n\n\n");
                                    bjk1.setText(t);
                                }
                            });
                        } catch (Exception e) {
                        }
                    }
                }).start();





            }
        });

    }
    public class fileSystem{
        private File file;
        public fileSystem(String path) throws IOException {
            this.file = new File(path);
            if (!this.file.exists()){
                String dir = "";
                for (int i = 0;i < path.split("/").length - 1;i++){
                    dir += path.split("/")[i]+"/";
                }new File(dir).mkdirs();
                this.file.createNewFile();
            }
        }
        public String read() throws IOException{
            try{
                BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(this.file)));
                if (this.file.canRead()){
                    String t = "";
                    String n = r.readLine();
                    while (n != null){
                        t += "\n" + n;
                        n = r.readLine();
                    }
                    t = t.substring(1);
                    r.close();
                    return t;
                }else{
                    r.close();
                    return "";
                }
            }catch (Exception e){
                return "";
            }
        }
        public boolean write(String text) throws IOException{
            FileOutputStream w = new FileOutputStream(this.file);
            try{
                if (this.file.canWrite()){
                    w.write(text.getBytes());
                    w.close();
                    return true;
                }else{
                    w.close();
                    return false;
                }
            }catch (Exception e){
                w.close();
                return false;
            }
        }
        public boolean add(String text){
            try{
                String oldText = this.read();
                this.write(oldText + text);
                return true;
            }catch (Exception e){
                return false;
            }
        }public boolean delete(){
            return this.file.delete();
        }public byte[] readBytes() throws IOException{
            BufferedInputStream r = new BufferedInputStream(new FileInputStream(this.file));
            try{
                int l = r.available();
                byte[] bytes = new byte[l];
                r.read(bytes,0,l);
                return bytes;
            }catch (Exception e){
                return null;
            }finally{
                r.close();
            }
        }public boolean writeBytes(byte[] b) throws IOException{
            try{
                FileOutputStream dos = new FileOutputStream(this.file);
                dos.write(b);
                dos.close();
                return true;
            }catch (Exception e){
                return false;
            }
        }
    }

    Activity 活动;



    public int findRight(String s,int l){
        int left=0;
        char right;
        switch(s.toCharArray()[l]){
            case '{':
                right='}';
                break;
            case '[':
                right=']';
                break;
            case '(':
                right=')';
                break;
            default:
                return -2;
        }for(int i=l+1;i<s.length();i++){
            if(s.toCharArray()[i]==s.toCharArray()[l]){
                left++;
            }else if(s.toCharArray()[i]==right){
                if(left==0)return i;
                left--;
            }
        }return -1;
    }
    public String deUnicode(String t){
        while(t.matches("[\\s\\S]*\\\\u[0-9a-zA-Z]{4}[\\s\\S]*")){
            String gets = get(t,"\\\\u[0-9a-zA-Z]{4}");
            char[] c = gets.substring(2).toLowerCase().toCharArray();
            char r = 0;
            for(int i = 0;i < 4;i++){
                r = (char)(r+('0'<=c[i]&&c[i]<='9'?c[i]-'0':c[i]-'a'+10)*(int)(Math.pow(16,3-i)));
            }t=t.replace(gets,""+r);
        }return t;
    }
    public String ns(String s,int n){
        String t = "";
        for(int i = 0;i < n;i++){
            t+=s;
        }return t;
    }
    public String get(String s,String rex,int group){
        Pattern p = Pattern.compile(rex);
        Matcher m = p.matcher(s);
        if(m.find())return m.group(group);
        return null;
    }
    public String get(String s,String rex){
        return get(s,rex,0);
    }
    public String replace(String s,String from,String to,int n){
        int last = 0;
        for(int i=0;i<n;i++){
            last = s.indexOf(from);
            s=s.substring(0,last)+to+s.substring(last+from.length());
        }return s;
    }
    public String beautiful(String code){
        String t = code.replaceAll("^[\\s]*","").replace("\\\\","[反斜杠]").replace("\\\"","[双引号]").replace("\\'","[单引号]");
        HashMap hs = new HashMap();
        HashMap hs2 = new HashMap();
        HashMap hs3 = new HashMap();
        while(t.matches("[\\s\\S]*\"[^\"]*\"[\\s\\S]*")){
            String gets = get(t, "\"[^\"]*\"");
            String core = "%%"+hs.size()+"%%";
            hs.put(core, gets.replace("[反斜杠]","\\\\").replace("[双引号]","\\\"").replace("[单引号]","\\'"));
            t=replace(t,gets,core,1);
        }while(t.matches("[\\s\\S]*'[^']*'[\\s\\S]*")){
            String gets = get(t, "'[^']*'");
            String core = "%%"+hs.size()+"%%";
            hs.put(core, gets.replace("[反斜杠]","\\\\").replace("[双引号]","\\\"").replace("[单引号]","\\'"));
            t=replace(t,gets,core,1);
        }while(t.matches("[\\s\\S]*//[^\\n]*[\\s\\S]*")){
            String gets = get(t, "//[^\\n]*");
            String core = "%^"+hs2.size()+"^%;";
            hs2.put(core, gets);
            t=replace(t,gets,core,1);
        }while(t.matches("[\\s\\S]*for[\\s]*\\([^\\)]*\\)[\\s\\S]*")){
            String gets = get(t, "for[\\s]*\\([^\\)]*\\)");
            String core = "^%"+hs3.size()+"%^";
            hs3.put(core, deUnicode(gets.replace("\n","").replaceAll("[\\s]*;[\\s]*",";").replaceAll("\\([\\s]*","(").replaceAll("[\\s]*\\)",")").replaceAll("( )+"," ")));
            t=replace(t,gets,core,1);
        }t=deUnicode(t);
        t=t.replace("*/","*/;").replaceAll("\\{[\\s]*\\}","%%-1%%;").replaceAll("\\([\\s]*","(").replaceAll("[\\s]*\\)",")").replaceAll("[\\s]*,[\\s]*",",").replaceAll("[\\s]*\\n","\n").replaceAll("\\n[\\s]*"," ").replaceAll("\\}[\\s]*","}").replaceAll(";[\\s]*",";").replaceAll("\\{[\\s]*","{").replaceAll("[\\s]*\\{","{")+"\n";
        String s;
        while((s=get(t,"[\\S][^\\n]*( ){2,}[^\\n]*\\n"))!=null){
            t=replace(t, s, s.replaceAll("( ){2,}"," "), 1);
        }int tabs=0;
        for(int i = 0;i < t.length();i++){
            if(t.toCharArray()[i]==';'){
                StringBuilder sb = new StringBuilder(t);
                sb.insert(i+1,"\n"+ns(" ",tabs));
                t=sb.toString();
            }else if(t.toCharArray()[i]=='{'){
                boolean f = false;
                for(int j = i-1;j>=0;j--){
                    if(t.toCharArray()[j]==']'||t.toCharArray()[j]=='='){
                        f = true;
                        i = findRight(t,i)+1;
                        break;
                    }if(!(""+t.toCharArray()[j]).matches("[\\s]")){
                        break;
                    }
                }if(f)continue;
                tabs+=4;
                StringBuilder sb = new StringBuilder(t);
                sb.insert(i+1,"\n"+ns(" ",tabs));
                t=sb.toString();
            }else if(t.toCharArray()[i]=='}'){
                StringBuilder sb = new StringBuilder(t);
                if(t.toCharArray()[i-1]==' '){
                    tabs-=4;
                    sb.delete(i-4,i);
                    i-=4;
                    // if(i!=t.length()-1)sb.insert(i+1,"\n"+ns(" ",tabs));
                }else{
                    sb.insert(i,"\n"+ns(" ",tabs));
                    i+=4;
                }t=sb.toString();
            }
        }t=t.replace("*/;","*/").replace("%%-1%%;","{}").replaceAll("( )*\\(( )*","(").replaceAll("( )*\\)( )*",")").replaceAll("[\\s]*\\[[\\s]*\\]","[]").replaceAll("( )*\\.( )*",".");
        for(int i = 0;i < hs3.size();i++){
            t=t.replace("^%"+i+"%^",(String)hs3.get("^%"+i+"%^"));
        }for(int i = 0;i < hs2.size();i++){
            t=t.replace("%^"+i+"^%;",(String)hs2.get("%^"+i+"^%;"));
        }for(int i = 0;i < hs.size();i++){
            t=t.replace("%%"+i+"%%",(String)hs.get("%%"+i+"%%"));
        }return t;
    }








}