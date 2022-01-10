package com.example.to_dolistapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.to_dolistapp.R;
import com.example.to_dolistapp.model.Task;

import java.text.SimpleDateFormat;

public class TaskDetalheFragment extends Fragment {
public static final String TAG_DETALHE = "tagDetalhe";
    public static final String TASK = "task";

    Task mTask;

    TextView tvNome;
    TextView tvDescricao;
    TextView tvDataInicial;
    TextView tvDataFinal;

    public TaskDetalheFragment(){
    }

    public static TaskDetalheFragment novaInstancia(Task task){
        TaskDetalheFragment fragment = new TaskDetalheFragment();

        Bundle parametros = new Bundle();
        parametros.putSerializable(TASK, task);

        fragment.setArguments(parametros);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mTask = (Task) getArguments().getSerializable(TASK);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View layout = inflater.inflate(R.layout.fragment_task_detalhe, container, false);

        tvNome = layout.findViewById(R.id.tvNome);
        tvDescricao = layout.findViewById(R.id.tvDescricao);
        tvDataInicial = layout.findViewById(R.id.tvDataInicial);
        tvDataFinal = layout.findViewById(R.id.tvDataFinal);

        if(mTask != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            //String dataInicial = sdf.format(mTask.getInitialDate());
            //String dataFinal = sdf.format(mTask.getFinishDate());

            tvNome.setText(mTask.getTitle());
            tvDescricao.setText(mTask.getDescription());
            //tvDataInicial.setText(dataInicial);
            //tvDataFinal.setText(dataFinal);
        }

        return layout;
    }

}
