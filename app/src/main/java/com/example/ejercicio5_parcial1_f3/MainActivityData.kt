package com.example.ejercicio5_parcial1_f3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivityData : AppCompatActivity() {
    private lateinit var btnContinue: Button
    private lateinit var inputCharge: EditText
    private lateinit var inputDistance: EditText
    private lateinit var inputBox1: EditText
    private lateinit var inputBox2: EditText
    private lateinit var inputBox3: EditText
    private lateinit var cmbShapes: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_data)

        btnContinue = findViewById(R.id.btnStart)
        inputCharge = findViewById(R.id.txtChargeInput)
        inputDistance = findViewById(R.id.txtDistanceInput)
        inputBox1 = findViewById(R.id.txtInputBox1)
        inputBox2 = findViewById(R.id.txtInputBox2)
        inputBox3 = findViewById(R.id.txtInputBox3)
        cmbShapes = findViewById(R.id.spinnerShapes)


        cmbShapes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                val selectedShape = cmbShapes.selectedItem.toString()
                if(selectedShape == "Hemisferio"){
                    inputBox1.hint = "Radio"
                    inputBox1.isEnabled = true

                    inputBox2.hint = "-"
                    inputBox2.isEnabled = false

                    inputBox3.hint = "-"
                    inputBox3.isEnabled = false
                }
                if(selectedShape == "Cono"){
                    inputBox1.hint = "Radio"
                    inputBox1.isEnabled = true

                    inputBox2.hint = "Altura"
                    inputBox2.isEnabled = true

                    inputBox3.hint = "-"
                    inputBox3.isEnabled = false

                }
                if(selectedShape == "Cono Truncado"){
                    inputBox1.hint = "Radio mayor"
                    inputBox1.isEnabled = true

                    inputBox2.hint = "Radio menor"
                    inputBox2.isEnabled = true

                    inputBox3.hint = "Altura"
                    inputBox3.isEnabled = true

                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {

            }
        }

        btnContinue.setOnClickListener{
            val intent = Intent(this,SimulatorScreen::class.java)
            val selectedShape = cmbShapes.selectedItem.toString()

            val userCharge = inputCharge.text.toString().toDouble()
            val userDistance = inputDistance.text.toString().toDouble()

            intent.putExtra("selectedShape", selectedShape)

            when (selectedShape) {
                "Hemisferio" -> {
                    val radio = inputBox1.text.toString().toDouble()
                    intent.putExtra("Radius", radio)
                }

                "Cono" -> {
                    val radio = inputBox1.text.toString().toDouble()
                    val height = inputBox2.text.toString().toDouble()
                    intent.putExtra("Radio", radio)
                    intent.putExtra("Height", height)
                }

                "Cono Truncado" -> {
                    val radio = inputBox1.text.toString().toDouble()
                    val height = inputBox2.text.toString().toDouble()
                    val truncadedConeRadio = inputBox3.text.toString().toDouble()
                    intent.putExtra("Radio", radio)
                    intent.putExtra("Height", height)
                    intent.putExtra("Radio2", truncadedConeRadio)
                }
            }
            intent.putExtra("Charge", userCharge)
            intent.putExtra("Distance", userDistance)
            startActivity(intent)
        }
    }
}
