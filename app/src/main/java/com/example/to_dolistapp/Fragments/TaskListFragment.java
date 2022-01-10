package com.example.to_dolistapp.Fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.to_dolistapp.R;
import com.example.to_dolistapp.model.Task;

import java.util.ArrayList;
import java.util.List;


public class TaskListFragment extends ListFragment {

    List<Task> mTasks;
    ArrayAdapter<Task> mAdapter;

    public TaskListFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mTasks = loadTask();

        mAdapter = new ArrayAdapter<Task>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mTasks
        );

        setListAdapter(mAdapter);
 
    }

    private List<Task> loadTask(){

        List<Task> tasks = new ArrayList<Task>();

        tasks.add(new Task("Compras 1", "comprar frutas"));
        tasks.add(new Task("Compras 2", "comprar frutas"));
        tasks.add(new Task("Compras 3", "comprar frutas"));
        tasks.add(new Task("Compras 4", "comprar frutas"));
        tasks.add(new Task("Trabalho Mobile", "Fazer trabalho de mobile"));

        return tasks;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Activity activity = getActivity();

        if(activity instanceof AoClicarNaTask){

            Task task = (Task) l.getItemAtPosition(position);

            AoClicarNaTask listener = (AoClicarNaTask) activity;

            listener.clicouNaTask(task);

        }
    }

    public interface AoClicarNaTask{
        void clicouNaTask(Task task);
    }
}