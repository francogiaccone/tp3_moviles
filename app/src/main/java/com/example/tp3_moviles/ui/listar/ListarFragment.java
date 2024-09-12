package com.example.tp3_moviles.ui.listar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.tp3_moviles.databinding.FragmentListarBinding;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel vmListar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vmListar = new ViewModelProvider(this).get(ListarViewModel.class);

        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vmListar.getMNotas().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                NotasAdapter adaptador = new NotasAdapter(strings, inflater);
                GridLayoutManager grilla = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);

                binding.rvLista.setAdapter(adaptador);
                binding.rvLista.setLayoutManager(grilla);
            }
        });

        vmListar.listarNotas();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}