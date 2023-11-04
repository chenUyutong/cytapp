package com.example.myapplication.Function.notebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class jsb extends AppCompatActivity {
    private Button mButton;
    private ListView mList;
    private Intent mIntent;
    private MyAdapter mAdapter;
    private NoteDb mNotedb;
    private Cursor cursor;
    private SQLiteDatabase dbreader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsb);
        mList = (ListView) this.findViewById(R.id.list);//首页显示的记事本内容ListView
        mNotedb = new NoteDb(this);
        dbreader = mNotedb.getReadableDatabase();//获取可读SQLiteDatabase()对象
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("Range")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor.moveToPosition(i);
                Intent intent = new Intent(jsb.this,ShowContent.class);
                intent.putExtra(NoteDb.ID,cursor.getInt(cursor.getColumnIndex(NoteDb.ID)));
                intent.putExtra(NoteDb.CONTENT,cursor.getString(cursor.getColumnIndex(NoteDb.CONTENT)));
                intent.putExtra(NoteDb.TIME,cursor.getString(cursor.getColumnIndex(NoteDb.TIME)));
                startActivity(intent);
            }
        });
    }

    public void add(View v) {
        //显示intent指的是直接指定目标组件
        //使用Intent显示指定要跳转的目标Activity
        //创建Intent对象传入2个参数，第一个参数：表示当前的Activity，第二个参数：表示要跳转到的目标Activity
        //启动Activity
        mIntent = new Intent(jsb.this,AddContent.class);
        startActivity(mIntent);
    }
    public void selectDb() {
        //query()方法，该方法返回的是一个行数集合Cursor，Cursor是一个游标接口，提供遍历查询结果的方法。
        cursor = dbreader.query
                (NoteDb.TABLE_NAME,null,null,null,null,null,null);
        mAdapter = new MyAdapter(this,cursor);
        mList.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        selectDb();
    }
}