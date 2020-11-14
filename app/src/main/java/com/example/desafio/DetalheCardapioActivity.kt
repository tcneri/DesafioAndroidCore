package com.example.desafio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_detalhe_cardapio.*
import kotlinx.android.synthetic.main.activity_home.*

class DetalheCardapioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_cardapio)

        setSupportActionBar(toolbarDC)
        toolbarDC.setNavigationOnClickListener(View.OnClickListener() {
            onBackPressed()
        })

        val nome = intent.getStringExtra("nome")
        val descricao = intent.getStringExtra("descricao")

        tvNomePrato.text = nome
        tvDetalhePrato.text = descricao


    }
}