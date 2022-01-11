package com.example.to_dolistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.to_dolistapp.Fragments.InfoDialogFragment;
import com.example.to_dolistapp.Fragments.TaskDialogFragment;
import com.example.to_dolistapp.Fragments.TaskListFragment;
import com.example.to_dolistapp.controllers.SwipeController;
import com.example.to_dolistapp.model.Task;

public class TaskActivity extends AppCompatActivity implements TaskListFragment.AoClicarNaTask,
    TaskDialogFragment.AoAdicionarTask, SearchView.OnQueryTextListener, MenuItemCompat.OnActionExpandListener {

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

        MenuItem searchItem = menu.findItem(R.id.acao_pesquisar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Procurar...");
        MenuItemCompat.setOnActionExpandListener(searchItem,this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.acao_novo:
                TaskDialogFragment taskDialogFragment = TaskDialogFragment.novaInstancia();
                taskDialogFragment.show(fragmentManager, TaskDialogFragment.DIALOG_TAG);
                break;
            case R.id.acao_info:
                InfoDialogFragment infoDialogFragment = new InfoDialogFragment();
                infoDialogFragment.show(fragmentManager, "INFO");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void adicionouTask(Task task) {
        taskListFragment.addTask(task);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        taskListFragment.buscar(newText);
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        taskListFragment.limpaBusca();
        return true;
    }
}