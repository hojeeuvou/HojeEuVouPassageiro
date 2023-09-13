package com.example.hojeeuvoupassageiro.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hojeeuvoupassageiro.model.ItemListaHome

class VanViewModel : ViewModel() {

    // Declare uma variável LiveData para os dados que você deseja exibir no RecyclerView
    private val _listaPassageiros = MutableLiveData<List<ItemListaHome>>()

    // Exponha a variável LiveData como somente leitura para o fragmento
    val listaPassageiros: LiveData<List<ItemListaHome>> = _listaPassageiros

    // Método para atualizar os dados da lista quando necessário
    fun atualizarListaPassageiros(novaLista: List<ItemListaHome>) {
        _listaPassageiros.value = novaLista
    }
}