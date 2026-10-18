package fr.aghi.tablederappel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.aghi.tablederappel.databinding.ItemImageBinding
import fr.aghi.tablederappel.model.TBNombreItem

class ImagesAdapter(private val items: List<TBNombreItem>) : 
    RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class ImageViewHolder(private val binding: ItemImageBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(item: TBNombreItem) {
            binding.tvNumero.text = item.numero
            binding.tvNom.text = item.mot
            binding.imageView.contentDescription = 
                "Image pour ${item.mot} (numéro ${item.numero})"
            
            val imageResId = binding.root.context.resources.getIdentifier(
                item.image.replace(".png", ""),
                "drawable",
                binding.root.context.packageName
            )
            if (imageResId != 0) {
                binding.imageView.setImageResource(imageResId)
            }
        }
    }
} 