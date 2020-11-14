package com.example.desafio

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.SupportActionModeWrapper
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.internal.NavigationMenuItemView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val TAG:String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(View.OnClickListener() {
            Log.i(TAG, "clicando back")
        })



        }

    }




//        val bundle :Bundle ?= intent.extras
//        if (bundle != null){
//            val nome = bundle.getString("nome")
//            val email = bundle.getString("password")
//
//            Toast.makeText(this, bundle.toString(), Toast.LENGTH_LONG).show()