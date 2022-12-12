package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private StudentRecyclerViewAdapter adapter;
    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<Student> students = new ArrayList<>();
        adapter = new StudentRecyclerViewAdapter(students);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        MyDatabase database = MyDatabase.getInstance(this);
        studentDao = database.getStudentDao();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                //Room不允许在主线程中操作数据库，必须放到子线程里面
                Student s1 = new Student("Jack", 20);
                //second commit
                Log.d("Hesre", "1111");
                studentDao.insertStudent(s1);
                break;
            case R.id.btn_change:
                break;
            case R.id.btn_delete:
                break;
            case R.id.query:
                break;
        }
    }

    class InsertStudentTask extends AsyncTask<Student, Void, Void>{
        //因为不能在主线程操作数据库，所以直接开一个异步任务

        @Override
        protected Void doInBackground(Student... students) {
            return null;
        }
    }
}