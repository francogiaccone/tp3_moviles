package com.example.tp3_moviles.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3_moviles.R;

import java.util.ArrayList;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.ViewHolderNotas> {

    private ArrayList<String> listaNotas;
    private LayoutInflater li;

    public NotasAdapter(ArrayList<String> listaNotas, LayoutInflater li) {
        this.listaNotas = listaNotas;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderNotas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item, parent, false);
        return new ViewHolderNotas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNotas holder, int position) {
        String nota = listaNotas.get(position);
        holder.tvNota.setText(nota);
    }

    @Override
    public int getItemCount() {
        return listaNotas.size();
    }

    public class ViewHolderNotas extends RecyclerView.ViewHolder {

        TextView tvNota;

        public ViewHolderNotas(@NonNull View itemView) {
            super(itemView);
            tvNota = itemView.findViewById(R.id.tvNota);
        }
    }
}

