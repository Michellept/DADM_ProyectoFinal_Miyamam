package vs.layour.dadm_proyectofinal_miyamam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import okhttp3.internal.Util
import vs.layour.dadm_proyectofinal_miyamam.Utils.Utils
import vs.layour.dadm_proyectofinal_miyamam.databinding.ActivityRegistroBinding
import vs.layour.dadm_proyectofinal_miyamam.databinding.PerfilFragmentBinding
import vs.layour.dadm_proyectofinal_miyamam.ui.GlobalViewModel

class RegistroActivity : AppCompatActivity() {


    lateinit var editNombre :EditText
    lateinit var editEmail: EditText
    lateinit var editTelefono:EditText
    lateinit var editContrasenia:EditText
    lateinit var editColonia:EditText
    lateinit var editCalle:EditText
    lateinit var editNumDom:EditText
    lateinit var CodPos:EditText
    lateinit var pais:EditText
    lateinit var ciudad:EditText
    lateinit var btnguardar:Button
    lateinit var btncancelar:Button


    private val viewModel: GlobalViewModel by viewModels()
    private lateinit var binding: ActivityRegistroBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistroBinding.inflate(layoutInflater)
       setContentView(this.binding.root)

        val database = Utils.dataBaseSQL







    }
}