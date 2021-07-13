package vs.layour.dadm_proyectofinal_miyamam.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import vs.layour.dadm_proyectofinal_miyamam.R
import vs.layour.dadm_proyectofinal_miyamam.models.ListaProductoItem

 class CarritoAdapter (
    val context: Context,
    val res:Int,
    val list:ArrayList<ListaProductoItem>
        ):RecyclerView.Adapter<CarritoAdapter.OnlyProductoVH>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoAdapter.OnlyProductoVH {
        val vh = OnlyProductoVH(LayoutInflater.from(context).inflate(res, null))
        return vh
    }

    override fun onBindViewHolder(holder: CarritoAdapter.OnlyProductoVH, position: Int) {
        val producto = list[position]
        holder.bind(producto)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OnlyProductoVH(view:View):RecyclerView.ViewHolder(view){
        fun bind(producto:ListaProductoItem){

            val item: CardView = itemView.findViewById(R.id.item_carrito)
            val img: ImageView = itemView.findViewById(R.id.imageView_car)
            val name: TextView = itemView.findViewById(R.id.name_car)
            val precio: TextView = itemView.findViewById(R.id.precio_car)
            val btndelete: Button = itemView.findViewById(R.id.fab_delete_carrito)


            name.text = producto.name
            precio.text = producto.price
            //Cargar una imagen desde la URL
            producto.images[0].src?.let {
                Picasso.get().load(it).into(img)
            }

            btndelete.setOnClickListener{

            }

        }
    }


}