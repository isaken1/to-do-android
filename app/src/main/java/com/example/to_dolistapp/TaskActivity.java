package com.example.to_dolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.to_dolistapp.Fragments.TaskListFragment;
import com.example.to_dolistapp.model.Task;

public class TaskActivity extends AppCompatActivity implements TaskListFragment.AoClicarNaTask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

    }

    @Override
    public void clicouNaTask(Task task) {
        Intent it = new Intent(this, com.example.to_dolistapp.TaskDetalheActivity.class);

        it.putExtra("task", task);

        startActivity(it);

    }
}