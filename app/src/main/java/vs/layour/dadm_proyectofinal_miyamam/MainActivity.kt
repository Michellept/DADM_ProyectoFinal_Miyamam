package vs.layour.dadm_proyectofinal_miyamam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import vs.layour.dadm_proyectofinal_miyamam.Utils.MyUtils.Companion.dbSet
import vs.layour.dadm_proyectofinal_miyamam.Utils.Utils
import vs.layour.dadm_proyectofinal_miyamam.models.LocalDBManager
import vs.layour.dadm_proyectofinal_miyamam.models.Usuario

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var logueado: Usuario
    }

    lateinit var editUser: EditText
    lateinit var editPass: EditText
    lateinit var btnAcceder: Button
    lateinit var btnRegistrar: Button
    lateinit var SwitchRemember: Switch


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Utils.dataBaseSQL = LocalDBManager(this, "BD", null, 1)
        val database = Utils.dataBaseSQL

        editUser = findViewById(R.id.editTextLogIn)
        editPass = findViewById(R.id.edit_password)
        btnRegistrar = findViewById(R.id.btn_registrarse)
        btnAcceder = findViewById(R.id.btn_acceder)
        SwitchRemember = findViewById(R.id.switchRemember)


        //USUARIO
       // database.altaUsuario(Usuario(1,"tk@gmail.com","123","Michelle","4431991778","industrial","20 de nov","67","56116","Mexico","Morelia"))



        btnAcceder.setOnClickListener {

            var usuario = editUser.text.toString()
            var pass = editPass.text.toString()

            var acceso = false
            for (i in database.consultaUsuarios()) {
                if (i.usr.equals(usuario.trim())) {
                    acceso = true

                    if (i.pass.trim().equals(pass.trim())) {
                        Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                        logueado = i

                        val intent = Intent(this, MenuActivity::class.java)
                        intent.putExtra("LOGEADO", i)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_LONG).show()
                    }

                }

            }
            if (!acceso){
                Toast.makeText(this,"No Existe estos Datos", Toast.LENGTH_LONG).show()
            }



        }

    }


}
