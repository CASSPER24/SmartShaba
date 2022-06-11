package com.ayesigyederrick.smartshamba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "LogIn"

        val gotoRegisterPage = findViewById<TextView>(R.id.text_gotoRegister)
        gotoRegisterPage.setOnClickListener{
            startActivity(Intent(this, Register::class.java))
        }
    }
}