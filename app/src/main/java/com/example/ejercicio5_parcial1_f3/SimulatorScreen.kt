package com.example.ejercicio5_parcial1_f3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.marginLeft
import androidx.core.view.marginStart

class SimulatorScreen : AppCompatActivity() {

    private lateinit var figureImageView: ImageView
    private lateinit var  arrowImageView: ImageView
    private lateinit var dotImageView: ImageView
    private lateinit var background: RelativeLayout

    //val shapetest = intent.getStringExtra("selectedShape").toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulator_screen)

        figureImageView = findViewById(R.id.Figure)
        arrowImageView = findViewById(R.id.Arrow)
        dotImageView = findViewById(R.id.Point)
        background = findViewById(R.id.Background)

        when (intent.getStringExtra("selectedShape").toString()) {
            "Hemisferio" -> {
                figureImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bluesphere))


            }

            "Cono" -> {
                figureImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bluecone))

            }

            "Cono Truncado" -> {
                figureImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.conotruncado))

            }
        }

        dotImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bluedot))

        dotImageView.x = 100.0F
        dotImageView.y = 0.0F

        arrowImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bluearrow))
    }
}

