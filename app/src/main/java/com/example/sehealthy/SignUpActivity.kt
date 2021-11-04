package com.example.sehealthy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val email = findViewById<EditText>(R.id.et_email)
        val username = findViewById<EditText>(R.id.et_username)
        val password = findViewById<EditText>(R.id.et_password)
        val signUp = findViewById<ImageButton>(R.id.btn_sign_up)
        val signInTv = findViewById<TextView>(R.id.tv_login)

        signUp.setOnClickListener {
            val emailString = email.text.toString()
            val usernameString = username.text.toString()
            val passwordString = password.text.toString()

            if (emailString.isBlank()
                || usernameString.isBlank()
                || passwordString.isBlank()) {
                Toast.makeText(this,
                    getString(R.string.please_fill),
                    Toast.LENGTH_SHORT)
                    .show()
            } else if(!Patterns.EMAIL_ADDRESS.matcher(email.text).matches()) {
                Toast.makeText(this,
                    getString(R.string.enter_valid_email),
                    Toast.LENGTH_SHORT)
                    .show()
            } else if (passwordString.length < 6) {
                Toast.makeText(this,
                    getString(R.string.minimum_length_6),
                    Toast.LENGTH_SHORT)
                    .show()
            } else {
                /**
                 * fungsi edit pada sharedPreference dipanggil untuk mengubah mode sharedPref
                 * menjadi edit
                 *
                 * putString dipanggil untuk menyimpan string ke sharedPreference
                 */
                val sharedPref = getSharedPreferences(getString(R.string.auth), MODE_PRIVATE)
                sharedPref.edit().putString(usernameString, usernameString).apply()
                sharedPref.edit().putString(passwordString, passwordString).apply()
                sharedPref.edit().putString("loggedIn", usernameString).apply()

                val i = Intent(this, DashboardActivity::class.java)
                startActivity(i)
                finish()
            }
        }

        signInTv.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}