package vs.layour.dadm_proyectofinal_miyamam.adapters

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import vs.layour.dadm_proyectofinal_miyamam.R
import vs.layour.dadm_proyectofinal_miyamam.models.Carrito
import vs.layour.dadm_proyectofinal_miyamam.models.ListaProductoItem

abstract class ProductoAdapter (val context: Context, val layout:Int, val lista : ArrayList<ListaProductoItem>):
    BaseAdapter() {
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
        val myview = inflater.inflate(layout, null)

      //  val img = myview.findViewById<ImageView>(R.id.image_viewproducto)
        val  nombre = myview.findViewById<TextView>(R.id.txt_nombreproducto)
        val des = myview.findViewById<TextView>(R.id.txt_desproducto)
        val cate= myview.findViewById<TextView>(R.id.txt_categoria_pro)
        val status = myview.findViewById<TextView>(R.id.viewproducto_info_inventario)
        val precio = myview.findViewById<TextView>(R.id.txt_precioproducto)
        val fabadd = myview.findViewById<Button>(R.id.fab_addcarrito_onlyproduct)


        nombre.text = lista[position].name
        des.text= Html.fromHtml(lista[position].shortDescription)
        cate.text =  lista[position].categories.toString()
        status.text= lista[position].stockStatus
        precio.text=lista[position].price

        fabadd.setOnClickListener{
            val addcarrito = Carrito(lista[position].name, lista[position].price)
            selectaddcarrito(addcarrito)
        }

        return myview

    }

    abstract fun selectaddcarrito(seleccion :Carrito)
}