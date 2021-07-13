package vs.layour.dadm_proyectofinal_miyamam.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    //-----------------Carrito
    private val carrito = MutableLiveData<ArrayList<ListaProductoItem>>().apply { postValue(
        ArrayList()
    ) }

    val getcarrito:LiveData<ArrayList<ListaProductoItem>>get() = carrito

    fun setcarrito(producto: ListaProductoItem){
        carrito.value?.add(producto)
    }


}