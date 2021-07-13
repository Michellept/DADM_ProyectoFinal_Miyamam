package vs.layour.dadm_proyectofinal_miyamam.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import vs.layour.dadm_proyectofinal_miyamam.R
import vs.layour.dadm_proyectofinal_miyamam.adapters.CarritoAdapter
import vs.layour.dadm_proyectofinal_miyamam.databinding.MicarritoFragmentBinding
import vs.layour.dadm_proyectofinal_miyamam.databinding.OnlyProductFragmentBinding

class micarrito : Fragment() {

    //Binding para fragmento
    private var _binding: MicarritoFragmentBinding? = null
    private val binding get() = _binding!!


    private val viewModel: GlobalViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MicarritoFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getlistaproductos.observe(viewLifecycleOwner){
            binding.listviewProductosCarrito.adapter = CarritoAdapter(view.context, R.layout.product_on_car, it)
        }



    }
}