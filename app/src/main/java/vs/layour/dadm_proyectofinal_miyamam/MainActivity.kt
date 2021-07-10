package vs.layour.dadm_proyectofinal_miyamam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch

class MainActivity : AppCompatActivity() {



    lateinit var editUser: EditText
    lateinit var editPass:EditText
    lateinit var btnAcceder: Button
    lateinit var btnRegistrar: Button
    lateinit var SwitchRemember: Switch


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editUser = findViewById(R.id.editTextLogIn)
        editPass= findViewById(R.id.edit_password)
        btnRegistrar = findViewById(R.id.btn_registrarse)
        btnAcceder = findViewById(R.id.btn_acceder)
        SwitchRemember=findViewById(R.id.switchRemember)


        btnAcceder.setOnClickListener {
         /*   var correcto = true
            if (editUser.text.isEmpty()) {
                editUser.setError("El Usuario No debe ser vacio")
                correcto = false
            }
            if(!editUser.text.contains("@")&&!editUser.text.contains(".")){
                editUser.setError("El Formato del correo es incorrecto")
                correcto = false
            }
            if (editPass.text.isEmpty()) {
                editPass.setError("La contraseña No debe ser vacia")
                correcto = false
            }
            if(!editPass.text.length<3){
                editPass.setError("La contraseña es muy corta")
                correcto = false
            }

            if (correcto){
                login(editUser.text.toString(), editPass.text.toString())
            }*/
            val intent = Intent (this, MenuActivity::class.java)
           // intent.putExtra("USUARIO", usuario)
            startActivity(intent)



        }

    }


    private fun login (usr:String, pass:String){

    }
}