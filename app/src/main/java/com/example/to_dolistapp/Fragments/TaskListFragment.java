package com.example.to_dolistapp.Fragments;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.to_dolistapp.Adapters.AdapterMod;
import com.example.to_dolistapp.R;
import com.example.to_dolistapp.controllers.SwipeController;
import com.example.to_dolistapp.controllers.SwipeControllerActions;
import com.example.to_dolistapp.model.Task;

import java.util.ArrayList;
import java.util.List;


public class TaskListFragment extends Fragment implements SwipeControllerActions {

    List<Task> mTasks;
    AdapterMod mAdapter;
    RecyclerView rvTasks;


    public TaskListFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_task_list, container, false);

        rvTasks = layout.findViewById(R.id.rvLista);

        mTasks = loadTask();

        mAdapter = new AdapterMod(mTasks);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvTasks.setLayoutManager(layoutManager);

        rvTasks.setHasFixedSize(true);
        rvTasks.setAdapter(mAdapter);

        mAdapter.implementaAoClicarNaLista(new AdapterMod.AoClicarNaLista() {
            @Override
            public void clicouNaTask(int position) {
                Activity activity = getActivity();

                if(activity instanceof AoClicarNaTask){
                    Task task = mTasks.get(position);
                    AoClicarNaTask listener = (AoClicarNaTask) activity;
                    listener.clicouNaTask(task);
                }
            }
        });

        SwipeController swipeController = new SwipeController(this);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(rvTasks);

        rvTasks.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });

        return layout;
    }

    public void addTask(Task task){
        mTasks.add(task);
        mAdapter.notifyDataSetChanged();
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
    public void onLeftClicked(int position) {
        changeTaskState(position);
    }

    @Override
    public void onRightClicked(int position) {
        changeTaskState(position);
    }

    public void changeTaskState(int position) {
        Task t = mTasks.get(position);

        t.setDone(!t.isDone());

        mAdapter.notifyDataSetChanged();
    }

    public interface AoClicarNaTask{
        void clicouNaTask(Task task);
    }


}