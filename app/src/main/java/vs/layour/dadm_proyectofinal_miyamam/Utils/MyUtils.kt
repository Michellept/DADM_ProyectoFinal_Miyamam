package vs.layour.dadm_proyectofinal_miyamam.Utils

import android.content.Context
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import vs.layour.dadm_proyectofinal_miyamam.models.LocalDBManager
import vs.layour.dadm_proyectofinal_miyamam.models.Usuario

class MyUtils {

    companion object {
        fun String.toas(c: Context) {
            Toast.makeText(c, this, Toast.LENGTH_LONG).show()

        }

        fun Context.dbSet(usuario: Usuario) {
            val dbManager = LocalDBManager(this,"my_app", null, 1)
            dbManager.setUsr(usuario)
        }

        fun Context.dbGet() : Usuario? {
            val dbManager = LocalDBManager(this,"my_app", null, 1)
            return dbManager.getUsr()
        }

        fun Context.dbRemove() {
            val dbManager = LocalDBManager(this,"my_app", null, 1)
            dbManager.removeUsr()
        }
    }
}

/*    fun cosumePost(c:Context, url: String): String{

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(c)
        val url = "http://bordados.noobhuman.ninja/"


        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                textView.text = "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { textView.text = "That didn't work!" })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)


    }
*/