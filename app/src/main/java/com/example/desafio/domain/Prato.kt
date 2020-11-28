package com.example.desafio.domain

class Prato(val id: Int, var nome:String, var img:Int, var descricao:String) {
    override fun toString(): String {
        return "Prato(id=$id,nome =$nome, img=$img, descricao= $descricao)"
    }
}