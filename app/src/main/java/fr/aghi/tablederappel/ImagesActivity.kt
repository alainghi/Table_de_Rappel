package fr.aghi.tablederappel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import fr.aghi.tablederappel.databinding.ActivityImagesBinding
import fr.aghi.tablederappel.utils.JsonUtils

class ImagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Activer le bouton retour dans l'ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupRecyclerView()
    }

    // Gérer le clic sur le bouton retour
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupRecyclerView() {
        val items = JsonUtils.loadTBNombre(this)
        with(binding.recyclerView) {
            layoutManager = GridLayoutManager(this@ImagesActivity, 10)
            adapter = ImagesAdapter(items.sortedBy { it.numero.toInt() })
        }
    }
} 