package tech.twentytwobits.recyclerviewexample

class Platillo(nombre: String, precio: Double, rating: Double, foto: Int) {
    var nombre: String
    var precio: Double
    var rating: Double
    var foto: Int

    init {
        this.nombre = nombre
        this.precio = precio
        this.rating = rating
        this.foto = foto
    }
}