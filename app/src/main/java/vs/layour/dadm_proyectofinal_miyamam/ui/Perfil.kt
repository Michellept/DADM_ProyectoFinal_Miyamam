package vs.layour.dadm_proyectofinal_miyamam.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import vs.layour.dadm_proyectofinal_miyamam.R
import vs.layour.dadm_proyectofinal_miyamam.Utils.Utils
import vs.layour.dadm_proyectofinal_miyamam.databinding.MicarritoFragmentBinding
import vs.layour.dadm_proyectofinal_miyamam.databinding.PerfilFragmentBinding

class Perfil : Fragment() {

    //Binding para fragmento
    private var _binding: PerfilFragmentBinding? = null
    private val binding get() = _binding!!


    private val viewModel: GlobalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PerfilFragmentBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = Utils.dataBaseSQL
    }


    }

