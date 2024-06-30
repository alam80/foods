package com.alam.foods

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alam.foods.databinding.ActivityRegisterBinding
import com.alam.foods.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database




class RegisterActivity : AppCompatActivity() {


    private lateinit var email: String
    private lateinit var password: String
    private lateinit var userName: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //initialize Firebase Auth (note: format kare ke liye ctrl+alt=L)
        auth = Firebase.auth

        //initialize Firebase Database
        database = Firebase.database.reference


        binding.createUserBtn.setOnClickListener {

            // get text from editText
            userName = binding.name.editableText.toString().trim()
            email = binding.emailId.editableText.toString().trim()
            password = binding.passwords.editableText.toString().trim()

            // fill all condition toast message
            if (userName.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill all detials", Toast.LENGTH_SHORT).show()
            } else {
                //pvt funtion call karaya bottom code
                createAccount(email, password)

            }

        }
        binding.alreadyhaveaaccountbutton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {

                Toast.makeText(this, "Account created Successfully", Toast.LENGTH_SHORT).show()

                //realtime database data store function call
                 saveUserData()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                //activity closed
                finish()
            } else {
                Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_SHORT).show()
                Log.d("Account","createAccount: Failure",task.exception)
            }
        }
    }

    //user data save
    private fun saveUserData() {
        userName = binding.name.editableText.toString().trim()
        email = binding.emailId.editableText.toString().trim()
        password = binding.passwords.editableText.toString().trim()

        val user=UserModel(userName,email,password)
        val userId:String = FirebaseAuth.getInstance().currentUser!!.uid

        //save user data firebase
        database.child("user").child(userId).setValue(user)
    }
}