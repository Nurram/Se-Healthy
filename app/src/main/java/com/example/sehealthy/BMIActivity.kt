package com.example.sehealthy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class BMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiactivity)

        val toolbar = findViewById<Toolbar>(R.id.bmi_toolbar)
        //setSupportActionBar dipanggil untuk memberitahu android mengenai custom toolbar
        setSupportActionBar(toolbar)
        //setDisplayHomeAsUpEnabled dipanggil untuk menampilkan back arrow pada toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //title dipanggil untuk mengatur title dari toolbar
        supportActionBar?.title = null

        val heightEt = findViewById<EditText>(R.id.et_height)
        val weightEt = findViewById<EditText>(R.id.et_weight)
        val calculateBtn = findViewById<Button>(R.id.btn_calculate)
        val bmiResultTv = findViewById<TextView>(R.id.tv_bmi_result)

        calculateBtn.setOnClickListener {
            val heightString = heightEt.text.toString()
            val weightString = weightEt.text.toString()

            if(heightString.isBlank() || weightString.isBlank()) {
                Toast.makeText(
                    this,
                    getString(R.string.please_fill),
                    Toast.LENGTH_SHORT)
                    .show()
            } else {
                //toDouble dipanggil untuk membuat data menjadi double (desimal)
                val weightDouble = weightString.toDouble()
                val heightDouble = heightString.toDouble() / 100
                val bmi = weightDouble / (heightDouble * heightDouble)

                val bmiDesc = when {
                    bmi < 16 -> { "Severely underweight" }
                    bmi < 18.5 -> { "Underweight" }
                    bmi < 25 -> { "Normal" }
                    bmi < 30 -> { "Overweight" }
                    else -> { "Obese" }
                }

                //visibility dipanggil untuk mengatur visibilitas view
                bmiResultTv.visibility = View.VISIBLE
                bmiResultTv.text = getString(R.string.bmi_result, bmi, bmiDesc)
            }
        }
    }
}