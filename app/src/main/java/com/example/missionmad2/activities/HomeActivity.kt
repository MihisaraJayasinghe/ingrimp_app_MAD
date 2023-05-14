package com.example.missionmad2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.missionmad2.R
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var database: FirebaseDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

            // Initialize the Firebase Authentication
            val auth: FirebaseAuth = FirebaseAuth.getInstance()
            database = Firebase.database

            val logout_btn = findViewById<Button>(R.id.log_out_btn)
            val grocery_list_btn = findViewById<Button>(R.id.groceryList_btn)
            val recipe_management_btn = findViewById<Button>(R.id.recipe_management_btn)
            val my_pantry_btn = findViewById<Button>(R.id.my_pantry_btn)
            val ingredient_management_btn = findViewById<Button>(R.id.ingredient_Management_btn)

            logout_btn.setOnClickListener {
                // Call the logout() function
                auth.signOut()

                val intent = Intent(this,LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }


            grocery_list_btn.setOnClickListener {

                val intent = Intent(this,MainActivityGrocerieslist::class.java)
                startActivity(intent)

            }

        recipe_management_btn.setOnClickListener {

            val intent = Intent(this,MainActivityRecipe::class.java)
            startActivity(intent)

        }

        my_pantry_btn.setOnClickListener {

            val intent = Intent(this,MainActivityPantry::class.java)
            startActivity(intent)

        }

        ingredient_management_btn.setOnClickListener {

            val intent = Intent(this,MainActivityIngredient::class.java)
            startActivity(intent)

        }


    }
}