package com.alam.foods

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alam.foods.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class LoginActivity : AppCompatActivity() {

    private lateinit var email:String
    private lateinit var password:String
    private lateinit var auth:FirebaseAuth
    private lateinit var database:DatabaseReference

    private val binding:ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //initialize Firebase Auth (note: format kare ke liye ctrl+alt=L)
        auth = Firebase.auth

        //initialize Firebase Database
        database = Firebase.database.reference

        binding.donthaveaaccountbutton.setOnClickListener {

            // get text from editText
            email = binding.emailId.editableText.toString().trim()
            password = binding.passwords.editableText.toString().trim()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill all detials", Toast.LENGTH_SHORT).show()
            }else{
                createUserAccount(email,password)
            }
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }

            binding.loginbutton.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }

    private fun createUserAccount(email: String, password: String) {

    }
}
