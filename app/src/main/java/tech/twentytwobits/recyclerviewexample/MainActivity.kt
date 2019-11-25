package tech.twentytwobits.recyclerviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adapter Source
        val platillos = ArrayList<Platillo>()

        platillos.add(Platillo("Platillo 1", 200.00, 3.5, R.drawable.platillo01))
        platillos.add(Platillo("Platillo 2", 100.00, 4.5, R.drawable.platillo02))
        platillos.add(Platillo("Platillo 3", 150.00, 5.0, R.drawable.platillo03))
        platillos.add(Platillo("Platillo 4", 180.00, 3.8, R.drawable.platillo04))
        platillos.add(Platillo("Platillo 5", 210.00, 1.0, R.drawable.platillo05))
        platillos.add(Platillo("Platillo 6", 250.00, 2.5, R.drawable.platillo06))
        platillos.add(Platillo("Platillo 7", 115.00, 4.7, R.drawable.platillo07))
        platillos.add(Platillo("Platillo 8", 175.00, 2.8, R.drawable.platillo08))
        platillos.add(Platillo("Platillo 9", 215.00, 0.0, R.drawable.platillo09))
        platillos.add(Platillo("Platillo 10", 300.00, 4.0, R.drawable.platillo10))

        layoutManager = LinearLayoutManager(this)

        // Indicar a la lista el adaptador a utilizar
        val adapter = AdapterCustom(this, platillos, object: ClickListener {
            override fun onClick(view: View, index: Int) {
                Toast.makeText(applicationContext, platillos[index].nombre, Toast.LENGTH_SHORT).show()
            }
        }, object: LongClickListener{
            override fun LongClickListener(view: View, index: Int) {
                Log.d("LONGCLICK", platillos[index].nombre)
            }
        })

        recyclerViewPlatillos.setHasFixedSize(true)
        recyclerViewPlatillos.layoutManager = layoutManager
        recyclerViewPlatillos.adapter = adapter

        // Swipe to refresh
        swipeRefreshLayout.setOnRefreshListener {
            Log.d("REFRESH", "La información se ha refrescado")

            // Mentirita
            for (i in 1..100000000) {

            }
            swipeRefreshLayout.isRefreshing = false

            // Agregar un nuevo platillo
            platillos.add(Platillo("Platillo 11", 400.00, 5.0, R.drawable.platillo06))
            // Decirle al adapter que la información ha cambiado
            adapter.notifyDataSetChanged()
        }
    }
}
