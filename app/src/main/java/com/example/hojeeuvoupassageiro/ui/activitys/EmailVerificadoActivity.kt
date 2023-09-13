package com.example.hojeeuvoupassageiro.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hojeeuvoupassageiro.databinding.ActivityEmailVerificadoBinding

class EmailVerificadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmailVerificadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailVerificadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonComeceSuasViagens.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

}