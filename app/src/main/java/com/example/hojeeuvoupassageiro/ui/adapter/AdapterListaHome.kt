package com.example.hojeeuvoupassageiro.ui.adapter

import android.graphics.Color
import kotlin.random.Random
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.hojeeuvoupassageiro.R
import com.example.hojeeuvoupassageiro.databinding.AdapterListaHomeBinding
import com.example.hojeeuvoupassageiro.model.ItemListaHome
import java.util.*

class AdapterListaHome : RecyclerView.Adapter<AdapterListaHome.ListaPassageiroViewHolder>() {

    private var listaPassageiros = emptyList<ItemListaHome>()

    inner class ListaPassageiroViewHolder(private val binding: AdapterListaHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemListaHome) {
            binding.tvNomeUsuario.text = item.nome
            binding.tvStatusAluno.text = item.status
            binding.tvStatusAluno.setTextColor(ContextCompat.getColor(binding.root.context, definirCorStatus(item.status)))
            binding.ivFundoPassageiro.setCardBackgroundColor(gerarCorAleatoria())
            binding.tvIniciais.text = extrairIniciais(item.nome)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaPassageiroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterListaHomeBinding.inflate(inflater, parent, false)
        return ListaPassageiroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaPassageiroViewHolder, position: Int) {
        holder.bind(listaPassageiros[position])
    }

    override fun getItemCount(): Int {
        return listaPassageiros.size
    }

    fun setData(data: List<ItemListaHome>) {
        listaPassageiros = data
        notifyDataSetChanged()
    }

    private fun definirCorStatus(status: String): Int {
        val corStatus: Int = when (status) {
            "Hoje eu vou" -> R.color.verde_claro
            "Hoje não vou" -> R.color.vermelho_claro
            "Hoje só vou" -> R.color.laranja
            "Hoje só volto" -> R.color.vermelho_vinho
            else -> R.color.black
        }
        return corStatus
    }

    fun gerarCorAleatoria(): Int {
        val random = Random
        while (true) {
            val cor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
            if (cor != Color.WHITE) {
                return cor
            }
        }
    }

    fun extrairIniciais(nome: String): String {
        val palavras = nome.split(" ")
        val iniciais = StringBuilder()

        // Extrair a inicial do primeiro nome
        if (palavras.isNotEmpty()) {
            iniciais.append(palavras[0][0])
        }

        // Extrair a inicial do último nome
        if (palavras.size >= 2) {
            val ultimoNome = palavras[palavras.size - 1]
            iniciais.append(ultimoNome[0])
        }

        return iniciais.toString()
    }

}
