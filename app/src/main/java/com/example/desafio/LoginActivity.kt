package com.example.desafio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio.domain.Usuario
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.toolbar))
        btLogin.setOnClickListener() {
            callHome(getInformationUser())
        }

        btRegisterLogin.setOnClickListener(){
            callRegister()
        }

    }

    fun callRegister() {
        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }


    //    Pegando informações do usuario
    fun getInformationUser(): Usuario {
        val email = etEmailLogin.text.toString()
        val senha = etPasswordLogin.text.toString()

        return Usuario(1, email, senha)
    }


    fun callHome(usuario: Usuario) {
        var intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("usuarioL", usuario)
        startActivity(intent)
    }
}