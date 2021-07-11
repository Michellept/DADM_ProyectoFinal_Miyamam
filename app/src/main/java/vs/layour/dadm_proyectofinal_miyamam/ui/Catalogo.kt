package vs.layour.dadm_proyectofinal_miyamam.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import vs.layour.dadm_proyectofinal_miyamam.R
import vs.layour.dadm_proyectofinal_miyamam.Utils.MyUtils
import vs.layour.dadm_proyectofinal_miyamam.adapters.ProductoAdapter
import vs.layour.dadm_proyectofinal_miyamam.databinding.CatalogoFragmentBinding
import vs.layour.dadm_proyectofinal_miyamam.models.ListaProducto

class Catalogo : Fragment() {

    private val viewModel: GlobalViewModel by activityViewModels()

    //Binding para fragment
    private var _binding: CatalogoFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Dentro del onCreateView
        _binding = CatalogoFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val lista = ArrayList<Producto>()
        //lista.add(Producto("Noragami",400.0,"Descripcion",""))
        //lista.add(Producto("Noragami2",400.2,"Descripcion2",""))
        // lista.add(Producto("Noragami3",400.3,"Descripcion3",""))


        val url = "${resources.getString(R.string.api)}products"
        object : MyUtils() {
            override fun formatResponse(response: String) {
                //Pasando una respuesta del server a un JSONObject
                val respuesta = Gson().fromJson(response, ListaProducto::class.java)
                Log.d("RESPUESTASERVIDOR", respuesta.toString())
                binding.listviewProductos.adapter = ProductoAdapter(view.context,R.layout.cardproductos, respuesta)
                binding.listviewProductos.layoutManager = GridLayoutManager(view.context, 1)
                    //ProductoAdapter(view.context, R.layout.cardproductos, respuesta)
            }

        }.consumeGet(view.context, url)
        // SE USA VIEW.CONTEXT PARA LOS FRAGMENTOS EN LUGAR DE THIS


    }

}