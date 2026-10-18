package fr.aghi.tablederappel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.aghi.tablederappel.databinding.ActivityChercherNumerosBinding
import fr.aghi.tablederappel.utils.JsonUtils
import fr.aghi.tablederappel.model.Item

class ChercherNumerosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChercherNumerosBinding
    private var currentItem: Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChercherNumerosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Activer le bouton retour dans l'ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        chargerNouveauMot()

        binding.btnVerifier.setOnClickListener {
            verifierReponse()
        }

        binding.btnSolution.setOnClickListener {
            afficherSolution()
        }
    }

    // Gérer le clic sur le bouton retour
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun chargerNouveauMot() {
        val items = JsonUtils.loadTBNom(this)
        if (items.isNotEmpty()) {
            currentItem = items.random()
            binding.tvMot.text = currentItem?.mot
        }
    }

    private fun verifierReponse() {
        val reponse = binding.etNumero.text.toString().trim()
        if (reponse.isNotEmpty() && currentItem != null) {
            if (reponse == currentItem?.numero) {
                Toast.makeText(this, "Correct !", Toast.LENGTH_SHORT).show()
                binding.etNumero.text.clear()
                chargerNouveauMot()
            } else {
                Toast.makeText(this, "Incorrect, essayez encore", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Veuillez entrer un numéro", Toast.LENGTH_SHORT).show()
        }
    }

    private fun afficherSolution() {
        currentItem?.let { item ->
            Toast.makeText(this, "La solution est : ${item.numero}", Toast.LENGTH_LONG).show()
        }
    }
} 