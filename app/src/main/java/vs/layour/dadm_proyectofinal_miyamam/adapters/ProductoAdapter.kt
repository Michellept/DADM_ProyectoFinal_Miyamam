package vs.layour.dadm_proyectofinal_miyamam.adapters

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.squareup.picasso.Picasso
import vs.layour.dadm_proyectofinal_miyamam.R
import vs.layour.dadm_proyectofinal_miyamam.models.ListaProductoItem

class ProductoAdapter (val context: Context, val layout:Int, val lista:ArrayList<ListaProductoItem>):BaseAdapter(){
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(layout, null)

        val item = myView.findViewById<CardView>(R.id.item_producto)
        val imagen = myView.findViewById<ImageView>(R.id.imageView_producto)
        val nombre = myView.findViewById<TextView>(R.id.txt_nombreproducto)
        val precio = myView.findViewById<TextView>(R.id.txt_precioproducto)
        val des = myView.findViewById<TextView>(R.id.txt_desproducto)

        //Cargar una imagen desde la URL
        //Picasso.get().load(lista[position].images[0].src).into(imagen)
        lista[position].images[0].src.let {
            var urlPhoto = it
            Picasso.get().load(urlPhoto).into(imagen);
        }

        nombre.text=lista[position].name
        precio.text=lista[position].price
        des.text= Html.fromHtml(lista[position].shortDescription)

        return myView


    }
}
