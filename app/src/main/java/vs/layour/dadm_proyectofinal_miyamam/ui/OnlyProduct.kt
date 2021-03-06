package vs.layour.dadm_proyectofinal_miyamam.ui

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import vs.layour.dadm_proyectofinal_miyamam.R
import vs.layour.dadm_proyectofinal_miyamam.Utils.MyUtils
import vs.layour.dadm_proyectofinal_miyamam.Utils.Utils
import vs.layour.dadm_proyectofinal_miyamam.databinding.OnlyProductFragmentBinding
import vs.layour.dadm_proyectofinal_miyamam.models.Carrito
import vs.layour.dadm_proyectofinal_miyamam.models.ListaProductoItem
import vs.layour.dadm_proyectofinal_miyamam.models.LocalDBManager

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


        val database = Utils.dataBaseSQL
        val carrito =Utils.dataBaseSQL

        viewModel.getroductoSelect.observe(viewLifecycleOwner, {
            //binding.imageViewproducto.setImageResource(it.images)
            //Cargar una imagen desde la URL
            it.images[0].src.let {
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



            viewModel.getcarrito.observe(viewLifecycleOwner, Observer {
                binding.fabAddcarritoOnlyproduct.setOnClickListener{

/*
                    val productos= ArrayList<Carrito>()
                    for (i in carrito.consultaCarrito()){
                        for (a??adir in productos){
                            if (i.nombre.equals(a??adir.nombre)){
                                productos.add(i)
                            }
                        }
                    }
*/
                        findNavController().navigate(R.id.action_onlyProduct_to_navigation_micarrito)


                }
            })




            /*
            var productos = ArrayList<ListaProductoItem>()
            viewModel.getlistaproductos.observe(viewLifecycleOwner, {
                productos = it
            })
            binding.fabAddcarritoOnlyproduct.setOnClickListener {
                findNavController().navigate(R.id.action_onlyProduct_to_navigation_micarrito)
                viewModel.getroductoSelect.observe(viewLifecycleOwner, {
                    productos.add(it)
                    viewModel.setlistaproductos(productos)
                })

            }*/


        })


    }

}




