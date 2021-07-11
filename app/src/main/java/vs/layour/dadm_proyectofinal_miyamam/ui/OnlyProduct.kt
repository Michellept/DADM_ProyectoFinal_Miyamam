package vs.layour.dadm_proyectofinal_miyamam.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.squareup.picasso.Picasso
import vs.layour.dadm_proyectofinal_miyamam.R
import vs.layour.dadm_proyectofinal_miyamam.databinding.OnlyProductFragmentBinding

class OnlyProduct : Fragment() {

    private val viewModel: GlobalViewModel by activityViewModels()
    private var _binding: OnlyProductFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = OnlyProductFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getroductoSelect.observe(viewLifecycleOwner, {
            //binding.imageViewproducto.setImageResource(it.images)
            //Cargar una imagen desde la URL
            it.images[0].src?.let {
                Picasso.get().load(it).into(binding.imageViewproducto)
            }
            binding.txtNombreproducto.setText(it.name)
            var categorias = ""
            for (i in it.categories) {
                categorias += " ${i.name}"
            }
            binding.txtCategoriaPro.setText(categorias)

            binding.txtDesproducto.setText(it.shortDescription)
            // des.text= Html.fromHtml(lista[position].shortDescription)
            binding.txtPrecioproducto.setText(it.price)
            binding.viewproductoInfoInventario.setText(it.stockStatus)

        })

    }
}



