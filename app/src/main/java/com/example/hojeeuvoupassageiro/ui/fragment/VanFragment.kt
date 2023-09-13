package com.example.hojeeuvoupassageiro.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hojeeuvoupassageiro.databinding.FragmentVanBinding
import com.example.hojeeuvoupassageiro.model.ItemListaHome
import com.example.hojeeuvoupassageiro.ui.ViewModel.VanViewModel
import com.example.hojeeuvoupassageiro.ui.adapter.AdapterListaHome

class VanFragment : Fragment() {

    private lateinit var viewModel: VanViewModel
    private lateinit var binding: FragmentVanBinding
    private lateinit var adapter: AdapterListaHome

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVanBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(VanViewModel::class.java)
        setupContentView()

            viewModel.atualizarListaPassageiros(criaLista())
    }

    private fun setupContentView(){
        setupRecyclerViewPassageiros()
        setupBotoes()
    }

    private fun setupRecyclerViewPassageiros(){
        // Configurar RecyclerView e Adapter
        adapter = AdapterListaHome()
        binding.recyclerPassageiros.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerPassageiros.adapter = adapter

        // Observar os dados do ViewModel e atualizar o Adapter quando necessário
        viewModel.listaPassageiros.observe(viewLifecycleOwner) { listaPassageiros ->
            adapter.setData(listaPassageiros)
        }

    }

    private fun criaLista(): List<ItemListaHome> {
        val novaListaPassageiros = listOf(
            ItemListaHome("Victor Pacheco", "Hoje eu vou"),
            ItemListaHome("Ryan Resende", "Hoje eu vou"),
            ItemListaHome("Victor Pacheco", "Hoje não vou"),
            ItemListaHome("Ryan Resende", "Hoje não vou"),
            ItemListaHome("Victor Pacheco", "Hoje só vou"),
            ItemListaHome("Ryan Resende", "Hoje só volto"),
        )
        return novaListaPassageiros
    }

    private fun setupBotoes(){
        binding.buttonHojeEuVou.setOnClickListener {
            binding.containerHojeEuVou.alpha = 1F
            binding.containerHojeNaoVou.alpha = 0.3F
            binding.containerHojeSoVou.alpha = 0.3F
            binding.containerHojeSoVolto.alpha = 0.3F
        }

        binding.buttonNaoVou.setOnClickListener {
            binding.containerHojeEuVou.alpha = 0.3F
            binding.containerHojeNaoVou.alpha = 1F
            binding.containerHojeSoVou.alpha = 0.3F
            binding.containerHojeSoVolto.alpha = 0.3F
        }

        binding.buttonHojeSoVou.setOnClickListener {
            binding.containerHojeEuVou.alpha = 0.3F
            binding.containerHojeNaoVou.alpha = 0.3F
            binding.containerHojeSoVou.alpha = 1F
            binding.containerHojeSoVolto.alpha = 0.3F
        }

        binding.buttonHojeSoVolto.setOnClickListener {
            binding.containerHojeEuVou.alpha = 0.3F
            binding.containerHojeNaoVou.alpha = 0.3F
            binding.containerHojeSoVou.alpha = 0.3F
            binding.containerHojeSoVolto.alpha = 1F
        }

    }

}