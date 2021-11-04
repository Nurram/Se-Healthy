package com.example.sehealthy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /**
         * findViewById digunakan untuk mengambil referensi view dari layout
         * Parameter yang dibutuhkan adalah tipe data dan id view
         */
        val username = findViewById<EditText>(R.id.et_username)
        val password = findViewById<EditText>(R.id.et_password)
        val loginBtn = findViewById<ImageButton>(R.id.btn_sign_up)
        val signUpTv = findViewById<TextView>(R.id.tv_login)

        val sharedPreference = getSharedPreferences(getString(R.string.auth), MODE_PRIVATE)

        // setOnClickListener digunakan untuk melakukan sesuatu jika user menekan tombol
        loginBtn.setOnClickListener {
            // toString() digunakan untuk merubah tipe data menjadi string
            val usernameString = username.text.toString()
            val passwordString = password.text.toString()

            val usernamePref = sharedPreference.getString(usernameString, "")
            val passwordPref = sharedPreference.getString(passwordString, "")

            //Jika username atau password tidak ditemukan maka akan menampilkan toast
            if(usernamePref.isNullOrBlank() || passwordPref.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    getString(R.string.incorrect_email_password),
                    Toast.LENGTH_SHORT)
                    .show()
            } else {
                sharedPreference.edit().putString("loggedIn", usernameString).apply()

                val i = Intent(this, DashboardActivity::class.java)
                startActivity(i)
                //Finish dipanggil untuk menutup tampilan yang muncul saat ini
                finish()
            }
        }

        signUpTv.setOnClickListener {
            val i = Intent(this, SignUpActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}