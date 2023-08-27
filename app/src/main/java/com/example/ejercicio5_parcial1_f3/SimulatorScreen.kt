package com.example.ejercicio5_parcial1_f3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SimulatorScreen : AppCompatActivity() {

    private lateinit var figureImageView: ImageView
    private lateinit var fieldTextView: TextView
    private lateinit var  arrowImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulator_screen)
    }
}