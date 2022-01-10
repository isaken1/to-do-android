package com.example.to_dolistapp.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.to_dolistapp.R;
import com.example.to_dolistapp.model.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TaskDialogFragment extends DialogFragment {

    public static final String DIALOG_TAG = "addDialog";
    private EditText etTitulo;
    private EditText etDescricao;
    private EditText etDataFinal;

    private Button btnAdicionar;

    private DatePickerDialog datePickerDialog;

    private Task task;

    public TaskDialogFragment(){

    }

    public static TaskDialogFragment novaInstancia(){
        TaskDialogFragment taskDialogFragment = new TaskDialogFragment();
        return taskDialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        task = new Task();

        iniciarDatePicker();
    }

    private void iniciarDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month+=1;
                if(month<10){
                    etDataFinal.setText(dayOfMonth+"/0"+month+"/"+year);
                } else{
                    etDataFinal.setText(dayOfMonth+"/"+month+"/"+year);
                }

            }
        };

        Calendar cal = Calendar.getInstance();

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(getContext(), style, dateSetListener,
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_task_dialog, container, false);

        etTitulo = layout.findViewById(R.id.etTitulo);
        etDescricao = layout.findViewById(R.id.etDescricao);
        etDataFinal = layout.findViewById(R.id.etDataFinal);

        etDataFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        btnAdicionar = layout.findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarTask();
            }
        });

        getDialog().setTitle("Adicionar Tarefa");

        return layout;
    }

    public void adicionarTask(){
        Activity activity = getActivity();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if(activity instanceof AoAdicionarTask){
            task.setTitle(etTitulo.getText().toString());
            task.setDescription(etDescricao.getText().toString());
            try {
                task.setFinishDate(sdf.parse(etDataFinal.getText().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        AoAdicionarTask listener = (AoAdicionarTask) activity;
        listener.adicionouTask(task);

        dismiss();
    }

    public interface AoAdicionarTask{
        void adicionouTask(Task task);
    }
}