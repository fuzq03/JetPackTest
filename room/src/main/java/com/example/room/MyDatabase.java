package com.example.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//指定一下有什么表， 版本号
@Database(entities = {Student.class}, version = 1, exportSchema = false)
//注意Database是一个抽象类，继承RoomDatabase
public abstract class MyDatabase extends RoomDatabase {

    //使用了单例模式
    private static MyDatabase mInstance;
    private static final String DATABASE_NAME = "my_db.db";

    public static synchronized MyDatabase getInstance(Context context) {
        if(mInstance == null) {
            //构建一个Database的实例
            mInstance = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, DATABASE_NAME)
                    //.allowMainThreadQueries()  加上这个就可以在主线程中操作数据库
                    .build();
        }
        return mInstance;
    }

    public abstract StudentDao getStudentDao();
}
