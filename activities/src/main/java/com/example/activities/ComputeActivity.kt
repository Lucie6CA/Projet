package com.example.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.activities.R

class ComputeActivity: AppCompatActivity() {

    private lateinit var textField1: EditText
    private lateinit var textField2: EditText
    private lateinit var afficherTexte: TextView
    private lateinit var calculButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        calculButton = findViewById(R.id.btn_calculer)
        textField1 = findViewById(R.id.field_1)
        textField2 = findViewById(R.id.field_2)
        afficherTexte = findViewById(R.id.resultat)

        if (textField1.text.toString().length <= 0 || textField2.text.toString().length <= 0){
            calculButton.setEnabled(false);

        }
        textField1.doAfterTextChanged {
            if (textField1.text.toString().length <= 0 || textField2.text.toString().length <= 0){
                calculButton.setEnabled(false);

            }
            else{
                calculButton.setEnabled(true);
            }
        }
        textField2.doAfterTextChanged {
            if (textField1.text.toString().length <= 0 || textField2.text.toString().length <= 0){
                calculButton.setEnabled(false);

            }
            else{
                calculButton.setEnabled(true);
            }
        }

        calculButton.setOnClickListener {



                    val nombre1 = textField1.text.toString().toDouble()
                    val nombre2 = textField2.text.toString().toDouble()

                    afficherTexte.text= (nombre1 + nombre2).toString()

            }


    }

}