package tech.twentytwobits.recyclerviewexample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class AdapterCustom(var context: Context, var items: ArrayList<Platillo>): RecyclerView.Adapter<AdapterCustom.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): AdapterCustom.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.template_platillo, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: AdapterCustom.ViewHolder, position: Int) {
        val item = items.get(position)

        // Mapeo
        holder.nombre.text = item.nombre
        holder.precio.text = item.precio.toString()
        holder.rating.rating = item.rating.toFloat()
        holder.foto.setImageResource(item.foto)
    }

    // Mapear las variables de cada item dentro de items con los
    // widgets correspondientes dentro de la vista
    class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        var nombre: TextView
        var precio: TextView
        var rating: RatingBar
        var foto: ImageView

        init {
            this.nombre = view.findViewById(R.id.textViewNombre)
            this.precio = view.findViewById(R.id.textViewPrecio)
            this.rating = view.findViewById(R.id.ratingBarPuntuacion)
            this.foto = view.findViewById(R.id.imageViewPlatillo)
        }
    }

}