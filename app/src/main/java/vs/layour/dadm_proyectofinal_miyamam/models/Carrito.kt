package vs.layour.dadm_proyectofinal_miyamam.models

import com.google.gson.annotations.SerializedName

data class Carrito(
    @SerializedName("nomre")
    val nombre: String,
    @SerializedName("precio")
    val precio: String,
    @SerializedName("precioT")
    val precioT: String,
)