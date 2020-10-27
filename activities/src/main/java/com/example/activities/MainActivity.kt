package com.example.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Trace.isEnabled
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var nbClick = 0
    private lateinit var clickButton: Button
    private lateinit var texte: TextView
    private lateinit var computeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn_click_me)
        texte = findViewById(R.id.text_onclick)
        computeButton = findViewById(R.id.btn_compute)

        clickButton.setOnClickListener {
            nbClick++

            if (nbClick < 5) {
                val newText = "Vous avez cliqué $nbClick fois"
                texte.text = newText
            } else {
                clickButton.setEnabled(false);
                val newText = "Vous avez cliqué $nbClick fois : plus d'essais"

                texte.text = newText
            }
        }
        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }


}

