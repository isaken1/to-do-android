package com.example.to_dolistapp.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.to_dolistapp.R;

public class InfoDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Alunos");
        builder.setMessage("Ian Barreto, Isaac Kennedy, Italo Lima e Victor Gabriel");
        builder.setPositiveButton("Ver Site", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String link = "https://github.com/isaken1/to-do-android";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Sair", this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Activity activity = getActivity();

        if(activity instanceof AoClicarEmInfo){
            AoClicarEmInfo listener = (AoClicarEmInfo) activity;
            listener.aoClicar(which);
        }

    }

    public interface AoClicarEmInfo{
        public void aoClicar(int botao);
    }
}