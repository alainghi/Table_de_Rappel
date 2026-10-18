package fr.aghi.tablederappel.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import fr.aghi.tablederappel.R
import fr.aghi.tablederappel.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val imageView: ImageView = binding.imageView // Assuming you have an ImageView with id imageView in your layout

        // Set the image resource
        imageView.setImageResource(R.drawable.prof) // Replace your_image with the actual image resource name

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}