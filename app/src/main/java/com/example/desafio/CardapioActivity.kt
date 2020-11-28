package com.example.desafio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.domain.Prato
import com.example.desafio.domain.Restaurante
import kotlinx.android.synthetic.main.activity_cardapio.*
import kotlinx.android.synthetic.main.activity_detalhe_cardapio.*
import kotlinx.android.synthetic.main.activity_home.*

class CardapioActivity : AppCompatActivity(), PratoAdapter.OnPratoClickListener {

    var listPrato: ArrayList<Prato> = getPrato()
    var adapter: PratoAdapter = PratoAdapter(listPrato, this)
    var TAG = "Cardapio"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardapio)

        setSupportActionBar(toolbarC)

        toolbarC.setNavigationOnClickListener(View.OnClickListener() {
            onBackPressed()
        })

        rvCardapioC1.adapter = adapter
        rvCardapioC1.layoutManager = GridLayoutManager(this,2)
        rvCardapioC1.setHasFixedSize(true)


        val restaurant = intent.getSerializableExtra("restaurante") as? Restaurante
        tvNomeRestauranteC.text = restaurant!!.nome
        ivImgRestauranteC.setImageResource(restaurant.img)



    }

    fun getPrato():ArrayList<Prato>{
        return arrayListOf(
                Prato(1,
                        "Salada com molho Gengibre",
                        R.mipmap.image4,
                        "Lorem ipsum, or lipsum as it is sometimes known, " +
                                "is dummy text used in laying out print, graphic or web " +
                                "designs."),
                Prato(2,
                        "Salada com molho Gengibre",
                        R.mipmap.image4,
                        "Lorem ipsum, or lipsum as it is sometimes known, " +
                                "is dummy text used in laying out print, graphic or web " +
                                "designs."),
                Prato(3,
                        "Salada com molho Gengibre",
                        R.mipmap.image4,
                        "Lorem ipsum, or lipsum as it is sometimes known, " +
                                "is dummy text used in laying out print, graphic or web " +
                                "designs."),
                Prato(4,
                        "Salada com molho Gengibre",
                        R.mipmap.image4,
                        "Lorem ipsum, or lipsum as it is sometimes known, " +
                                "is dummy text used in laying out print, graphic or web " +
                                "designs."),
                Prato(5,
                        "Salada com molho Gengibre",
                        R.mipmap.image4,
                        "Lorem ipsum, or lipsum as it is sometimes known, " +
                                "is dummy text used in laying out print, graphic or web " +
                                "designs.")
        )
    }

    override fun pratoClick(position: Int) {
        val prato = listPrato.get(position)
        var nomePrato = prato.nome
        var descPrato = prato.descricao
        adapter.notifyItemChanged(position)
        callDetalheCardapio(prato)
    }

    fun  callDetalheCardapio(prato:Prato) {
        var intent = Intent(this, DetalheCardapioActivity::class.java)
        intent.putExtra("nome",prato.nome)
        intent.putExtra("descricao",prato.descricao)

        startActivity(intent)
    }


}




