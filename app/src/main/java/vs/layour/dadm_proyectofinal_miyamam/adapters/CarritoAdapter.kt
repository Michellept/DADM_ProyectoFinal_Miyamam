package vs.layour.dadm_proyectofinal_miyamam.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import vs.layour.dadm_proyectofinal_miyamam.models.ListaProductoItem

class ProductoAdapter (
    val context: Context,
    val res:Int,
    val list:ArrayList<ListaProductoItem>
        ):RecyclerView.Adapter<ProductoAdapter.OnlyProductoVH>(){}