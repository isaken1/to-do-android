package com.example.to_dolistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.to_dolistapp.Fragments.TaskDialogFragment;
import com.example.to_dolistapp.Fragments.TaskListFragment;
import com.example.to_dolistapp.model.Task;

public class TaskActivity extends AppCompatActivity implements TaskListFragment.AoClicarNaTask,
    TaskDialogFragment.AoAdicionarTask {

    private FragmentManager fragmentManager;
    private TaskListFragment taskListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        fragmentManager = getSupportFragmentManager();
        taskListFragment = (TaskListFragment) fragmentManager.findFragmentById(R.id.fragmentList);
    }

    @Override
    public void clicouNaTask(Task task) {
        Intent it = new Intent(this, com.example.to_dolistapp.TaskDetalheActivity.class);

        it.putExtra("task", task);

        startActivity(it);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.acao_novo:
                TaskDialogFragment taskDialogFragment = TaskDialogFragment.novaInstancia();
                taskDialogFragment.show(fragmentManager, TaskDialogFragment.DIALOG_TAG);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void adicionouTask(Task task) {
        taskListFragment.addTask(task);
    }
}