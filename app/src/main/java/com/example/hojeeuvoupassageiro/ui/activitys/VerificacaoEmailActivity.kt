package com.example.hojeeuvoupassageiro.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hojeeuvoupassageiro.R
import com.example.hojeeuvoupassageiro.databinding.ActivityEmailVerificadoBinding
import com.example.hojeeuvoupassageiro.databinding.ActivityVerificacaoEmailBinding

class VerificacaoEmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerificacaoEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificacaoEmailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonVerificar.setOnClickListener{
            val intent = Intent(this, EmailVerificadoActivity::class.java)
            startActivity(intent)
        }

    }
}