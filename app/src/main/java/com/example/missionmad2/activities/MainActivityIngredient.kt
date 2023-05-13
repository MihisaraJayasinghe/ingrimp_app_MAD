package com.example.missionmad2.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.missionmad2.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivityIngredient : AppCompatActivity() {

    private lateinit var btnInsertData: Button
    private lateinit var btnFetchData: Button
    private lateinit var btnPantry: ImageView
    private lateinit var ingredbtn: ImageView
    private lateinit var btngrocerylist: ImageView
    private lateinit var recipbtn: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_main)


        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()
        btnInsertData = findViewById(R.id.btnInsertData)
        btnFetchData = findViewById(R.id.btnFetchData)
        btnPantry = findViewById<ImageView>(R.id.btnPantry)
        ingredbtn = findViewById<ImageView>(R.id.ingredbtn)
        btngrocerylist = findViewById<ImageView>(R.id.btngrocerylist)
        recipbtn = findViewById<ImageView>(R.id.recipbtn)




        recipbtn.setOnClickListener {
            val intent = Intent(this, MainActivityRecipe::class.java)
            startActivity(intent)
        }





        btnPantry.setOnClickListener {
            val intent = Intent(this, MainActivityPantry::class.java)
            startActivity(intent)
        }


        ingredbtn.setOnClickListener {
            val intent = Intent(this, MainActivityIngredient::class.java)
            startActivity(intent)
        }

        btngrocerylist.setOnClickListener {
            val intent = Intent(this, MainActivityGrocerieslist::class.java)
            startActivity(intent)
        }


        //directing to the insert data
        btnInsertData.setOnClickListener {
            val intent = Intent(this, InsertIngredientActivity::class.java)
            startActivity(intent)
        }
        //directing to the viewing page
        btnFetchData.setOnClickListener {
            val intent = Intent(this, IngredientFetchActivity::class.java)
            startActivity(intent)
        }

    }
}