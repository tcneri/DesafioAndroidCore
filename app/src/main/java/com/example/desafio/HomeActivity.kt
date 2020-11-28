package com.example.desafio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.domain.Restaurante
import com.example.desafio.domain.Usuario
import kotlinx.android.synthetic.main.activity_home.*
import java.io.Serializable

class HomeActivity : AppCompatActivity(), RestauranteAdapter.OnRestauranteClickListener {
    var listRestauntes: ArrayList<Restaurante> = getRestaurantes()
    var adapter: RestauranteAdapter = RestauranteAdapter(listRestauntes, this)
    var TAG = "HOME"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        lateinit var usuario:Usuario

        if (intent.getSerializableExtra("usuarioL")!= null){
            usuario =intent.getSerializableExtra("usuarioL") as Usuario
        }
        if (intent.getSerializableExtra("usuarioR")!= null){
            usuario =intent.getSerializableExtra("usuarioR") as Usuario
        }

        welcomeUser(usuario)



        setSupportActionBar(toolbar)

        rvRestaurante.adapter = adapter
        rvRestaurante.layoutManager = LinearLayoutManager(this)
        rvRestaurante.setHasFixedSize(true)


    }

    private fun welcomeUser(usuario: Usuario) {
        if (usuario.name!= null){
            showToast("Seja bem-vindo ${usuario.name}!")
        }else{
            showToast("Seja bem-vindo!")
        }

    }

    fun getRestaurantes(): ArrayList<Restaurante> {
        return arrayListOf(
                Restaurante(id = 1,
                        "Tony Roma's",
                        "Av.Lavandisca, 717 - Indianópolis, São Paulo",
                        "Fecha às 22:00",
                        R.mipmap.image1),

                Restaurante(id = 2,
                        "Aoyama - Moema",
                        "Alameda dos Arapanés, 532 - Moema",
                        "Fecha às 00:00",
                        R.mipmap.image4),

                Restaurante(id = 3,
                        "Outback - Moema",
                        "Av. Moaci, 187 - Moema, São Paulo",
                        "Fecha às 00:00",
                        R.mipmap.image5),

                Restaurante(id = 4,
                        "Si Señor!",
                        "Alameda Jauaperi, 626 - Moema",
                        "Fecha às 01:00",
                        R.mipmap.image3)
        )

    }

    override fun restauranteClick(position: Int) {
        val restaurante = listRestauntes.get(position)
        var nome = restaurante.nome
        var img = restaurante.img
        adapter.notifyItemChanged(position)
        callCardapio(restaurante)

    }

    fun callCardapio(restaurante: Restaurante) {
        var intent = Intent(this, CardapioActivity::class.java)
        intent.putExtra("restaurante", restaurante)

        startActivity(intent)
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}


