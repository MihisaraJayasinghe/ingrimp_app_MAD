package com.example.missionmad2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.missionmad2.R
import android.content.Intent
import android.util.Patterns
import android.widget.Button
import android.widget.EditText

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth :FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        database = Firebase.database

        val Login_btn = findViewById<Button>(R.id.Login_btn)
        val SignUp_btn = findViewById<Button>(R.id.signUp_btn)
        val Email_Login = findViewById<EditText>(R.id.EmailLogin)
        val password_Login = findViewById<EditText>(R.id.passwordLogin)

        Login_btn.setOnClickListener{

            val email = Email_Login.text.toString().trim()
            val password = password_Login.text.toString().trim()

            if(email.isEmpty()){
                Email_Login.error = "Email Required"
                Email_Login.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                Email_Login.error = "Email Required"
                Email_Login.requestFocus()
                return@setOnClickListener

            }

            if(password.isEmpty() || password.length < 6){
                password_Login.error = "6 character Password Required"
                password_Login.requestFocus()
                return@setOnClickListener
            }

            loginUser(email,password)

        }

        SignUp_btn.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }



    }

    private fun loginUser(email : String , password:String) {

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val intent = login()

                    startActivity(intent)
                    finish()

                } else {
                    task.exception?.message?.let {
                        Toast(it)
                    }
                }

            }
        val userRef = database.getReference("users").child("SRzAHhusiSa1wi271nVjgnZiP223")
        userRef.child("userType").setValue("admin")

    }

    override fun onStart() {
        super.onStart()

        mAuth.currentUser?.let{
            val intent = login()
            startActivity(intent)


        }

    }
}