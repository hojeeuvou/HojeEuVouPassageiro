package com.example.hojeeuvoupassageiro.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hojeeuvoupassageiro.R
import com.example.hojeeuvoupassageiro.databinding.ActivityMainBinding
import com.example.hojeeuvoupassageiro.ui.fragment.MapaFragment
import com.example.hojeeuvoupassageiro.ui.fragment.VanFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupBottomNavigation()

        // Instancie as fragments
        val vanFragment = VanFragment()
        val mapaFragment = MapaFragment()

        loadFragment(vanFragment)

    }

    private fun setupBottomNavigation(){
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val fragment: Fragment? = when (item.itemId) {
                R.id.nav_van -> VanFragment()
                R.id.nav_mapa -> MapaFragment()
                else -> null
            }
            if (fragment != null) {
                loadFragment(fragment)
            }
            false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}