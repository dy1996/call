package com.example.administrator.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class myHelper extends SQLiteOpenHelper {
    //数据库名称
    private static final String DB_NAME="STUDENT.db";
    //表名
    private static final String TBL_NAME="student";
    //声明SQLiteDatabase对象
    private SQLiteDatabase db;
    //构造函数
    myHelper(Context c){
        super(c,DB_NAME,null,2);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //获取SQLiteDatabase对象
        this.db=db;
        //创建表
        String CREATE_TBL="create table student(_id integer primary key autoincrement,banji verchar(20),sno verchar(20),sname verchar(20))";
        db.execSQL(CREATE_TBL);
    }

    //插入
    public  void insert(ContentValues values){
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TBL_NAME,null,values);
        db.close();
    }

    //查询
    public Cursor query(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.query(TBL_NAME,null,null,null,null,null,null);
        return c;
    }
    //删除
    public void del(int id){
        if(db==null)
            db=getWritableDatabase();
        db.delete(TBL_NAME,"_id=?",new String[]{String.valueOf(id)});
    }
    //关闭数据库
    public void close(){
        if(db!=null)
            db.close();
    }

}
