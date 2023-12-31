package com.example.ejercicio5_parcial1_f3

import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.math.RoundingMode
import java.text.DecimalFormat

class SimulatorScreen : AppCompatActivity() {

    private lateinit var figureImageView: ImageView
    private lateinit var  arrowImageView: ImageView
    private lateinit var dotImageView: ImageView
    private lateinit var background: RelativeLayout
    private lateinit var electricFieldTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulator_screen)

        figureImageView = findViewById(R.id.Figure)
        arrowImageView = findViewById(R.id.Arrow)
        dotImageView = findViewById(R.id.Point)
        background = findViewById(R.id.Background)
        electricFieldTextView = findViewById(R.id.ElectricField)

        when (intent.getStringExtra("selectedShape").toString()) {
            "Hemisferio" -> {
                figureImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bluesphere))

                // Calculando campo
                val charge = intent.getDoubleExtra("Charge", 1.0)
                val distance = intent.getDoubleExtra("Distance", 1.0)
                val radio = intent.getDoubleExtra("Radius", 1.0)
                val electricField = electricFieldOfHemisphere(charge/1000000, distance, radio)

                val electricFieldRounded = roundNumber(electricField)

                electricFieldTextView.text = electricFieldRounded.toString()

                if (distance <= 47) {
                    dotImageView.x = (distance  * 37.78F).toFloat()
                } else {
                    dotImageView.x = 47F * 37.8F
                    Toast.makeText(this, "Partícula ha superado la distancia máxima. Colocada en 47 m.", Toast.LENGTH_LONG).show()
                }

                if (electricField >= 1500) {
                    arrowImageView.alpha = 1F

                } else if (electricField in 1000.0..1500.0) {
                    arrowImageView.alpha = 0.7F

                } else if (electricField in 600.0..1000.0) {
                    arrowImageView.alpha = 0.5F

                } else {
                    arrowImageView.alpha = 0.2F
                }
            }

            "Cono" -> {
                figureImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bluecone))

                // Calculando campo
                val charge = intent.getDoubleExtra("Charge", 1.0)
                val height = intent.getDoubleExtra("Height", 1.0)
                val radio = intent.getDoubleExtra("Radio", 1.0)
                val distance = intent.getDoubleExtra("Distance", 1.0)
                val electricField = electricFieldOfCone(charge/1000000, radio, height, distance)

                electricFieldTextView.text = roundNumber(electricField).toString()

                if (distance <= 47) {
                    dotImageView.x = (distance  * 37.78F).toFloat()
                } else {
                    dotImageView.x = 47F * 37.8F
                    Toast.makeText(this, "Partícula ha superado la distancia máxima. Colocada en 47 m.", Toast.LENGTH_LONG).show()
                }

                if (electricField >= 1500) {
                    arrowImageView.alpha = 1F

                } else if (electricField in 1000.0..1500.0) {
                    arrowImageView.alpha = 0.7F

                } else if (electricField in 600.0..1000.0) {
                    arrowImageView.alpha = 0.5F

                } else {
                    arrowImageView.alpha = 0.2F
                }
            }

            "Cono Truncado" -> {
                figureImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.conotruncado))

                // Calculando campo
                val charge = intent.getDoubleExtra("Charge", 1.0)
                val radio = intent.getDoubleExtra("Radio", 1.0)
                val radio2 = intent.getDoubleExtra("Radio2", 1.0)
                val height = intent.getDoubleExtra("Height", 1.0)
                val distance = intent.getDoubleExtra("Distance", 1.0)

                val electricField = electricFieldOfTruncatedCone(charge/1000000, radio, radio2, height, distance)

                electricFieldTextView.text = roundNumber(electricField).toString()

                if (distance <= 47) {
                    dotImageView.x = (distance  * 37.78F).toFloat()
                } else {
                    dotImageView.x = 47F * 37.8F
                    Toast.makeText(this, "Partícula ha superado la distancia máxima. Colocada en 47 m.", Toast.LENGTH_LONG).show()
                }

                if (electricField >= 1500) {
                    arrowImageView.alpha = 1F

                } else if (electricField in 1000.0..1500.0) {
                    arrowImageView.alpha = 0.7F

                } else if (electricField in 600.0..1000.0) {
                    arrowImageView.alpha = 0.5F

                } else {
                    arrowImageView.alpha = 0.2F
                }
            }
        }
        dotImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bluedot))
        arrowImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bluearrow))
    }
}

fun roundNumber(number: Double): Double {
    val format = DecimalFormat("#.##")
    format.roundingMode = RoundingMode.DOWN
    val roundOff = format.format(number)
    return  roundOff.toDouble()
}

