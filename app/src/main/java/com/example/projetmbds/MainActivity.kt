package com.example.projetmbds

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Afficher une page web
        //showWebPage()
        //Appeler qqlun
        callMe()

    }
    /* Fonction qui affiche une page web*/
    fun showWebPage(){
        val chemin : Uri = Uri.parse("http://www.google.fr");
        val naviguer = Intent(Intent.ACTION_VIEW, chemin);
        startActivity(naviguer)

    }
    /*Fonction permettant d'appeler un numéro de téléphone*/

    fun callMe(){
        val numero : Uri = Uri.parse("tel: 0695089294");
        val appeler = Intent(Intent.ACTION_VIEW, numero);
        startActivity(appeler)
    }



}

