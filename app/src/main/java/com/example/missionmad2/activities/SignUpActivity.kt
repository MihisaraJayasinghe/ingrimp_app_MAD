package com.example.missionmad2.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import com.example.missionmad2.R
import com.example.missionmad2.activities.LoginActivity
import com.example.missionmad2.activities.Toast
import com.example.missionmad2.activities.login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var database: FirebaseDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()
        database = Firebase.database


        val signUpBtn = findViewById<Button>(R.id.signUpBtn)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val Email_signUp = findViewById<EditText>(R.id.Email_signUp)
        val password_signUp = findViewById<EditText>(R.id.password_signUp)

        signUpBtn.setOnClickListener{
            val email = Email_signUp.text.toString().trim()
            val password = password_signUp.text.toString().trim()

            if(email.isEmpty()){
                Email_signUp.error = "Email Required"
                Email_signUp.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                Email_signUp.error = "Email Required"
                Email_signUp.requestFocus()
                return@setOnClickListener

            }

            if(password.isEmpty() || password.length < 6){
                password_signUp.error = "6 character Password Required"
                password_signUp.requestFocus()
                return@setOnClickListener
            }

            registerUser(email,password)





        }

        loginBtn.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }



    }

    private fun registerUser(email: String, password: String) {

        mAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task ->

                if(task.isSuccessful) {

                    val intent = login()
                    startActivity(intent)


                }else{
                    task.exception?.message?.let{
                        Toast(it)
                    }
                }
            }



    }

    override fun onStart() {
        super.onStart()

        mAuth.currentUser?.let{
            val intent =  login()
            startActivity(intent)

        }

    }





    }
