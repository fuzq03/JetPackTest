package com.example.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    //接口里的方法默认public不用写
    @Insert
    void insertStudent(Student... students);

    @Delete
    void deleteStudent(Student... students);

    @Update
    void updateStudent(Student... students);

    @Query("SELECT * FROM student")
    List<Student> getAllStudent();

    @Query("SELECT * FROM student WHERE id = :id")
    List<Student> getStudentById(int id);
}
