package vs.layour.dadm_proyectofinal_miyamam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import okhttp3.internal.Util
import vs.layour.dadm_proyectofinal_miyamam.Utils.Utils
import vs.layour.dadm_proyectofinal_miyamam.databinding.ActivityRegistroBinding
import vs.layour.dadm_proyectofinal_miyamam.databinding.PerfilFragmentBinding
import vs.layour.dadm_proyectofinal_miyamam.models.Usuario
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
    private lateinit var _binding: ActivityRegistroBinding
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityRegistroBinding.inflate(layoutInflater)
       setContentView(this.binding.root)

        val database = Utils.dataBaseSQL




        binding.btnRegistroCancelar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this,"Se cancelo el registro", Toast.LENGTH_LONG).show()
            startActivity(intent)
            finish()
        }

        binding.btnRegistroGuardar.setOnClickListener{

                database.altaUsuario(Usuario(3,editEmail.toString(),editContrasenia.toString(),editNombre.toString(),editTelefono.toString(),editColonia.toString(),editCalle.toString(),editNumDom.toString(),CodPos.toString(),pais.toString(),ciudad.toString()))
                val intent = Intent(this, MainActivity::class.java)
                Toast.makeText(this,"Registro Existoso", Toast.LENGTH_LONG).show()
                startActivity(intent)
                finish()
        }





         /*editNombre = findViewById(R.id.editTextRegistro_Nombre)
         editEmail =findViewById(R.id.editTextRegistro_Email)
         editTelefono =findViewById(R.id.editTextRegistro_NTelefono)
        editContrasenia =findViewById(R.id.editTextRegistro_Contrasena)
         editColonia =findViewById(R.id.colonia)
        editCalle =findViewById(R.id.calle)
        editNumDom =findViewById(R.id.numero_dom)
         CodPos =findViewById(R.id.codigo)
         pais =findViewById(R.id.pais)
         ciudad =findViewById(R.id.ciudad)
         btnguardar =findViewById(R.id.btnRegistro_Guardar)
         btncancelar =findViewById(R.id.btnRegistro_Cancelar)
        */


       /*


    */

    }
}