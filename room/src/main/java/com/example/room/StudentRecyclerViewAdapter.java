package com.example.room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentRecyclerViewAdapter extends RecyclerView.Adapter {
    List<Student> students;
    public StudentRecyclerViewAdapter(List<Student> students) {this.students = students;}


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Student student = students.get(position);
        TextView tvId = holder.itemView.findViewById(R.id.textView);
        tvId.setText(String.valueOf(student.id));
        TextView tvName = holder.itemView.findViewById(R.id.textView2);
        tvId.setText(String.valueOf(student.name));
        TextView tvAge = holder.itemView.findViewById(R.id.textView3);
        tvId.setText(String.valueOf(student.age));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;
        TextView textView3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
        }
    }
}
