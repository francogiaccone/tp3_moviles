package com.example.tp3_moviles.ui.cargar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3_moviles.MainActivity;
import com.example.tp3_moviles.databinding.FragmentCargarBinding;

public class CargarViewModel extends ViewModel {

    private MutableLiveData<String> mMensaje;

    public LiveData<String> getMMensaje() {
        if(mMensaje == null){
            mMensaje = new MutableLiveData<>();
        }
        return mMensaje;
    }

    public void cargarNota(String nota) {
        if (nota.isEmpty()) {
            mMensaje.setValue("La nota está vacía");
        } else {
            mMensaje.setValue("Nota agregada");
            MainActivity.notas.add(nota);
        }
    }
}