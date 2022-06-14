package com.ayesigyederrick.smartshamba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

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
    fun GotoMain2(view: View) {
        val email = findViewById<TextInputEditText>(R.id.email_login).text.toString()
        val password = findViewById<TextInputEditText>(R.id.password_login).text.toString()
        if(email =="" || password == ""){
            Toast.makeText(applicationContext, "Fields cant be left Empty, Go to Register to open an Account", Toast.LENGTH_LONG).show()
        }else {
            Firebase.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                        Toast.makeText(applicationContext, "Login successful", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(applicationContext,
                        exception.localizedMessage,
                        Toast.LENGTH_LONG).show()
                }
        }
    }
}