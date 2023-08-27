package com.example.ejercicio5_parcial1_f3

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
                var selectedShape = cmbShapes.selectedItem.toString()
                if(selectedShape.equals("Hemisferio")){
                    inputBox1.setHint("Radio")
                    inputBox1.isEnabled = true

                    inputBox2.setHint("-")
                    inputBox2.isEnabled = false

                    inputBox3.setHint("-")
                    inputBox3.isEnabled = false

                }
                if(selectedShape.equals("Cono")){
                    inputBox1.setHint("Radio")
                    inputBox1.isEnabled = true

                    inputBox2.setHint("Altura")
                    inputBox2.isEnabled = true

                    inputBox3.setHint("-")
                    inputBox3.isEnabled = false

                }
                if(selectedShape.equals("Cono Truncado")){
                    inputBox1.setHint("Radio mayor")
                    inputBox1.isEnabled = true

                    inputBox2.setHint("Radio menor")
                    inputBox2.isEnabled = true

                    inputBox3.setHint("Altura")
                    inputBox3.isEnabled = true

                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {

            }
        }

        btnContinue.setOnClickListener{

        }
    }
}
