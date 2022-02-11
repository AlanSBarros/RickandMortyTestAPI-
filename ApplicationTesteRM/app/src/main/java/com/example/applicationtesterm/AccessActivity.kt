package com.example.applicationtesterm

import android.app.Activity
import android.os.Bundle
import com.example.applicationtesterm.R
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import android.widget.Toast
import android.content.Intent
import android.view.View
import com.example.applicationtesterm.SelectionActivity

class AccessActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.access_screen)
        val userLogin = findViewById<View>(R.id.user_login) as TextView
        val userPassword = findViewById<View>(R.id.user_password) as TextView
        val buttonLogin = findViewById<View>(R.id.btn_login) as MaterialButton
        buttonLogin.setOnClickListener {
            if (userLogin.text.toString() == "alan" && userPassword.text.toString() == "qwerty") {
                Toast.makeText(this@AccessActivity, "Login Feito!", Toast.LENGTH_SHORT).show()
                openAccessActivity()
            } else Toast.makeText(this@AccessActivity, "Login Recusado", Toast.LENGTH_SHORT).show()
        }
    }

    fun openAccessActivity() {
        val intent = Intent(this, SelectionActivity::class.java)
        startActivity(intent)
    }
}