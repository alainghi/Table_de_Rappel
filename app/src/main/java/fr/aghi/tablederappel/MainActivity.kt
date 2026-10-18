package fr.aghi.tablederappel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.aghi.tablederappel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChercherNumeros.setOnClickListener {
            startActivity(Intent(this, ChercherNumerosActivity::class.java))
        }

        binding.btnChercherMots.setOnClickListener {
            startActivity(Intent(this, ChercherMotsActivity::class.java))
        }

        binding.btnVoirImages.setOnClickListener {
            startActivity(Intent(this, ImagesActivity::class.java))
        }
    }
}