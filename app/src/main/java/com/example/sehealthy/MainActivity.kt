package com.example.sehealthy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Baris dibawah digunakan untuk mengatur tampilan menjadi fullscreen
         * Berdasarkan pada versi android
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        //Baris dibawah digunakan untuk melakukan delay selama 2 detik dalam millisecond
        Handler(Looper.getMainLooper()).postDelayed({
            /**
             * Sharedpreference adalah fungsi yang digunakan untuk menyimpan data
             * dengan format key-value
             * getString dipanggil untuk mengambil string dari sharedPreference
             */
            val sharedPreference = getSharedPreferences(getString(R.string.auth), MODE_PRIVATE)
            val loggedInUser = sharedPreference.getString("loggedIn", "")

            if(loggedInUser.isNullOrBlank()) {
                /**
                 * Baris kode ini akan di eksekusi apabila delay telah habis
                 * Intent adalah sebuah fungsi bawaan android untuk berpindah activity (tampilan)
                 * finish dipanggil untuk menutup layar yang tampil
                 */
                val i = Intent(this, LoginActivity::class.java)
                startActivity(i)
                finish()
            } else {
                val i = Intent(this, DashboardActivity::class.java)
                //putExtra dipanggil untuk mengirimkan data ke activity tujuan
                i.putExtra("username", loggedInUser)
                startActivity(i)
                finish()
            }
        }, 2000)

    }
}