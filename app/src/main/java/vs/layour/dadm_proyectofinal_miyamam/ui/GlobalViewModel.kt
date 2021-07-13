package vs.layour.dadm_proyectofinal_miyamam.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vs.layour.dadm_proyectofinal_miyamam.models.Carrito
import vs.layour.dadm_proyectofinal_miyamam.models.ListaProducto
import vs.layour.dadm_proyectofinal_miyamam.models.ListaProductoItem

class GlobalViewModel : ViewModel() {

    // se importa la clase PRODUCTOITEM
    //Mutable Live Data
    private val productoSelect = MutableLiveData<ListaProductoItem>()

    //Getter del live Data
    val getroductoSelect: LiveData<ListaProductoItem> get() = productoSelect

    //Setter del live data
    fun setProductoSelect(productoItem: ListaProductoItem) {
        productoSelect.value = productoItem

    }
//--------------LISTA PRODUCTO
    private val listaproductos = MutableLiveData<ArrayList<ListaProductoItem>>()
    val getlistaproductos : LiveData<ArrayList<ListaProductoItem>>get() = listaproductos

    fun setlistaproductos(listaProducto: ArrayList<ListaProductoItem>){
        listaproductos.value = listaProducto
    }
    //------------------CARRITO
    private val addcarrito = MutableLiveData<ArrayList<Carrito>>().apply { postValue(
        ArrayList()
    ) }
    val getcarrito:LiveData<ArrayList<Carrito>>get()= addcarrito

    fun setcarrito(carrito: Carrito){
        addcarrito.value?.add(carrito)
    }
}