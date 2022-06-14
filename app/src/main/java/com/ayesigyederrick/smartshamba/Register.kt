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

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        title = "SignUP"


        val gotoLoginPage = findViewById<TextView>(R.id.text_gotoLogIn)
        gotoLoginPage.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
        }
    }
    fun GoToMain(view: View){
        val username = findViewById<TextInputEditText>(R.id.user_name_register).text.toString()
        val email = findViewById<TextInputEditText>(R.id.email_register).text.toString()
        val password = findViewById<TextInputEditText>(R.id.password_register).text.toString()
        val confirm_password = findViewById<TextInputEditText>(R.id.confirm_password_register).text.toString()

        if (password =="" || confirm_password == "" || email == "" || username ==""){
            Toast.makeText(applicationContext, "No field should be left Empty", Toast.LENGTH_LONG).show()
        }else if (password == confirm_password) {
            Firebase.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                        Toast.makeText(applicationContext, "Registered successful", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
                }
        } else {
            val toast = Toast.makeText(applicationContext, "Passwords don't match", Toast.LENGTH_LONG)
            toast.show()
        }
    }
    }
