package vs.layour.dadm_proyectofinal_miyamam.models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.jvm.Throws

class LocalDBManager(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.let {
            var sql = """
               CREATE TABLE usuario(
                    id INTEGER PRIMARY KEY,
                    usuario TEXT,
                    contrasenia TEXT,
                    nombre TEXT,
                    celular TEXT,
                    colonia TEXT,
                    calle TEXT,
                    numero TEXT,
                    codigo TEXT,
                    pais TEXT,
                    ciudad TEXT
               ) 
            """

            it.execSQL(sql)

        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    @Throws
    fun removeUsr() {
        val db = writableDatabase

        var sql = "DELETE FROM usuario"

        db.execSQL(sql)

        db.close()
    }

    @Throws
    fun setUsr(usuario: Usuario) {
        val db = writableDatabase

        var sql = "DELETE FROM usuario"

        db.execSQL(sql)

        sql =
            "INSERT INTO usuario VALUES(${usuario.id},'${usuario.usr}','${usuario.name}','${usuario.pass}','${usuario.celphone}'," +
                    "'${usuario.colonia}','${usuario.calle}','${usuario.numero}','${usuario.codigo}','${usuario.pais}','${usuario.ciudad}')"

        db.execSQL(sql)

        db.close()
    }

    @Throws
    fun getUsr(): Usuario? {
        val db = readableDatabase

        var sql = "SELECT * FROM usuario"

        val cursor = db.rawQuery(sql, null)

        var usuario: Usuario? = null
        if (cursor.moveToNext()) {
            usuario = Usuario(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10)
            )
        }
        db.close()

        return usuario
    }

    @Throws
    fun altaUsuario(usuario: Usuario) {
        val db = writableDatabase
        val sql =
            "INSERT INTO usuario   (id,usuario,contrasenia,nombre,celular,colonia,calle,numero,codigo,pais,ciudad)"+
        " VALUES (${usuario.id},'${usuario.usr}','${usuario.name}','${usuario.pass}','${usuario.celphone}','${usuario.colonia}','${usuario.calle}','${usuario.numero}','${usuario.codigo}','${usuario.pais}','${usuario.ciudad}')"
        db.execSQL(sql)

        db.close()
    }

    @Throws
    fun consultaUsuarios(): ArrayList<Usuario> {
        val db = readableDatabase

        val sql =
            "SELECT id,usuario,nombre,contrasenia,celular,colonia,calle,numero,codigo,pais,ciudad FROM usuario"

        val cursor = db.rawQuery(sql, null)

        val resultados = ArrayList<Usuario>()
        while (cursor.moveToNext()) {
            val usuario = Usuario(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10)
            )

            resultados.add(usuario)
        }
        db.close()

        return resultados
    }

//--------------CARRITO
    val carrito = """
        create table carrito(
        nombre TEXT,
        precio TEXT,
        precioT TEXT
        );
    """.trimIndent()

    @Throws
    fun getCarrito(carrito:Carrito):ArrayList<Carrito>{
        val db= readableDatabase
        val sql = "SELECT * FROM carrito WHERE '${carrito.nombre}','${carrito.precio}','${carrito.precioT}'"
        val cursor = db.rawQuery(sql, null)

        val resultados = ArrayList<Carrito>()
        while(cursor.moveToNext()){
            val carrito = Carrito(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2)
            )
            resultados.add(carrito)
        }
        db.close()
        return resultados
    }
    @Throws
    fun altaCarrito(carrito: Carrito){
        val db = writableDatabase
        val sql = "INSERT INTO carrito  (nombre, precio, precioT) "+
                "VALUES ( ${carrito.nombre}', ('${carrito.precio}', ('${carrito.precioT}',)"

        db.execSQL(sql)
        db.close()
    }
    @Throws
    fun consultaCarrito():ArrayList<Carrito>{
        val db = readableDatabase

        val sql = "SELECT  nombre,precio,precioT FROM carrito"

        val cursor = db.rawQuery(sql, null)

        val resultados = ArrayList<Carrito>()
        while (cursor.moveToNext()){
            val carrito = Carrito(
                cursor.getString(0),
                cursor.getString(2),
                cursor.getString(3)
            )
            resultados.add(carrito
            )

        }
        db.close()
        return resultados
    }
}