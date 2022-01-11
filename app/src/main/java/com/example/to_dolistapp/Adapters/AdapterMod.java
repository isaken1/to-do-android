package com.example.to_dolistapp.Adapters;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import  android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.to_dolistapp.R;
import com.example.to_dolistapp.model.Task;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdapterMod extends RecyclerView.Adapter<AdapterMod.TaskViewHolder>{
    private List<Task> tasks;

    public AdapterMod(List<Task> list){
        this.tasks = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int view){
        View task = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_lista_mod,parent,false);
        return new TaskViewHolder(task);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        holder.tvTitulo.setText(task.getTitle());
        holder.tvDataInicial.setText(sdf.format(task.getInitialDate()));
        holder.tvDataFinal.setText(sdf.format(task.getFinishDate()));

        if (task.isDone()) {
            holder.tvDataFinal.setPaintFlags(holder.tvDataFinal.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tvDataInicial.setPaintFlags(holder.tvDataInicial.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tvTitulo.setPaintFlags(holder.tvTitulo.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            if ((holder.tvTitulo.getPaintFlags() & Paint.STRIKE_THRU_TEXT_FLAG) > 0) {
                holder.tvDataFinal.setPaintFlags(holder.tvDataFinal.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                holder.tvDataInicial.setPaintFlags(holder.tvDataInicial.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                holder.tvTitulo.setPaintFlags(holder.tvTitulo.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            }
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitulo;
        TextView tvDataInicial;
        TextView tvDataFinal;

        CardView cvTask;

        public TaskViewHolder(View itemView){
            super(itemView);

            tvTitulo = itemView.findViewById(R.id.tvTituloRV);
            tvDataInicial = itemView.findViewById(R.id.tvDataInicialRV);
            tvDataFinal = itemView.findViewById(R.id.tvDataFinalRV);

            cvTask = itemView.findViewById(R.id.cvTask);

            cvTask.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            listener.clicouNaTask(getLayoutPosition());
        }

    }

    public interface AoClicarNaLista{
        void clicouNaTask(int position);
    }

    private AoClicarNaLista listener;

    public void implementaAoClicarNaLista(AoClicarNaLista listener){
        this.listener = listener;
    }
}
