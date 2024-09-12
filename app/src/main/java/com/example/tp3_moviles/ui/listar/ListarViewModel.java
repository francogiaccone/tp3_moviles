package com.example.tp3_moviles.ui.listar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3_moviles.MainActivity;

import java.util.ArrayList;
import java.util.Collections;

public class ListarViewModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> mNotas;

    public MutableLiveData<ArrayList<String>> getMNotas(){
        if(mNotas == null){
            mNotas = new MutableLiveData<>();
        }
        return mNotas;
    }

    public void listarNotas(){
        Collections.sort(MainActivity.notas);
        mNotas.setValue(MainActivity.notas);
    }
}