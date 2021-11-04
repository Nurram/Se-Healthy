package com.example.sehealthy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val greetings = findViewById<TextView>(R.id.tv_greetings)
        val logoutTv = findViewById<TextView>(R.id.tv_logout)
        val dietRv = findViewById<RecyclerView>(R.id.rv_diet_day)
        val bmiBtn = findViewById<Button>(R.id.btn_bmi)
        val aboutBtn = findViewById<Button>(R.id.btn_about_diet)

        val sharedPreferences = getSharedPreferences(getString(R.string.auth), MODE_PRIVATE)
        val username = sharedPreferences.getString("loggedIn", "")
        greetings.text = getString(R.string.hello, username)

        logoutTv.setOnClickListener {
            sharedPreferences.edit().remove("loggedIn").apply()

            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
        val adapter = DietAdapter {
            val i = Intent(this, DetailDietActivity::class.java)
            i.putExtra("pos", it)
            startActivity(i)
        }

        /**
         * layoutManager dipanggil untuk menentukan seperti apa list akan ditampilkan
         * pada kasus ini list akan ditampilkan secara grid dengan 2 kolom
         */
        dietRv.layoutManager = GridLayoutManager(this, 2)
        dietRv.adapter = adapter

        bmiBtn.setOnClickListener {
            val i = Intent(this, BMIActivity::class.java)
            startActivity(i)
        }

        aboutBtn.setOnClickListener {
            val i = Intent(this, AboutDietActivity::class.java)
            startActivity(i)
        }
    }
}