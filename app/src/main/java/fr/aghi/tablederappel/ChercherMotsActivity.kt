package fr.aghi.tablederappel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.aghi.tablederappel.databinding.ActivityChercherMotsBinding
import fr.aghi.tablederappel.utils.JsonUtils
import fr.aghi.tablederappel.model.TBNombreItem

class ChercherMotsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChercherMotsBinding
    private var currentItem: TBNombreItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChercherMotsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        chargerNouveauNumero()

        binding.btnVerifier.setOnClickListener {
            verifierReponse()
        }

        binding.btnSolution.setOnClickListener {
            afficherSolution()
        }
    }

    private fun chargerNouveauNumero() {
        val items = JsonUtils.loadTBNombre(this)
        if (items.isNotEmpty()) {
            currentItem = items.random()
            binding.tvNumero.text = currentItem?.numero
        }
    }

    private fun verifierReponse() {
        val reponse = binding.etMot.text.toString().trim()
        if (reponse.isNotEmpty() && currentItem != null) {
            if (reponse.equals(currentItem?.mot, ignoreCase = true)) {
                Toast.makeText(this, "Correct !", Toast.LENGTH_SHORT).show()
                binding.etMot.text.clear()
                chargerNouveauNumero()
            } else {
                Toast.makeText(this, "Incorrect, essayez encore", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Veuillez entrer un mot", Toast.LENGTH_SHORT).show()
        }
    }

    private fun afficherSolution() {
        currentItem?.let { item ->
            Toast.makeText(this, "La solution est : ${item.mot}", Toast.LENGTH_LONG).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
} 