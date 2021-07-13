package vs.layour.dadm_proyectofinal_miyamam.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import vs.layour.dadm_proyectofinal_miyamam.R
import vs.layour.dadm_proyectofinal_miyamam.models.ListaProductoItem

abstract class CatalogoAdapter(
    val context: Context,
    val res: Int,
    val list: ArrayList<ListaProductoItem>
) : RecyclerView.Adapter<CatalogoAdapter.ProductosVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogoAdapter.ProductosVH {
        val vh = ProductosVH(LayoutInflater.from(context).inflate(res, null))
        return vh
    }

    override fun onBindViewHolder(holder: ProductosVH, position: Int) {
        val producto = list[position]
        holder.bind(producto)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ProductosVH(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(producto: ListaProductoItem) {

            val item: CardView = itemView.findViewById(R.id.item_producto)
            val imagen: ImageView = itemView.findViewById(R.id.imageView_producto)
           // val nombre: TextView = itemView.findViewById(R.id.txt_nombreproducto)
            //val precio: TextView = itemView.findViewById(R.id.txt_precioproducto)

            //val des = myView.findViewById<TextView>(R.id.txt_categoria_pro)

            //nombre.text = producto.name
           // precio.text = producto.price
            // des.text= Html.fromHtml(lista[position].shortDescription)


            //Cargar una imagen desde la URL
            producto.images[0].src?.let {
                Picasso.get().load(it).into(imagen)
            println("IMAGENN---------${it}")
            }?: println("--------------------------")



          item.setOnClickListener{
              Toast.makeText(context, "${producto.categories}", Toast.LENGTH_SHORT).show()
              verproducto(producto)
          }



        }
    }

    abstract fun verproducto(producto: ListaProductoItem)

}






