package com.example.to_dolistapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.to_dolistapp.R;
import com.example.to_dolistapp.model.Task;
import com.example.to_dolistapp.Fragments.TaskDetalheFragment;

public class TaskDetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_detalhe_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        Intent it = getIntent();

        Task task = (Task) it.getExtras().getSerializable("task");

        TaskDetalheFragment taskDetalheFragment = TaskDetalheFragment.novaInstancia(task);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.detalhe,taskDetalheFragment,TaskDetalheFragment.TAG_DETALHE);
        ft.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}




