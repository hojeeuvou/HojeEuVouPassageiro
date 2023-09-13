package com.example.hojeeuvoupassageiro.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hojeeuvoupassageiro.R
import com.example.hojeeuvoupassageiro.ui.ViewModel.MapaViewModel
import com.example.hojeeuvoupassageiro.ui.ViewModel.VanViewModel

class MapaFragment : Fragment() {

    companion object {
        fun newInstance() = MapaFragment()
    }

    private lateinit var viewModel: MapaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mapa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MapaViewModel::class.java)
    }

}