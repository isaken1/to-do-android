package com.example.to_dolistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.to_dolistapp.model.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAbrirLista;
    List<Task> taskList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbrirLista = findViewById(R.id.abrirLista);

        btnAbrirLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getApplicationContext(), TaskActivity.class);

                startActivity(it);

            }
        });


    }
}