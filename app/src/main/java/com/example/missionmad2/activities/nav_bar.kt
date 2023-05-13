package com.example.missionmad2.activities

import android.content.Intent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.missionmad2.R

class nav_bar : AppCompatActivity() {




    private lateinit var btnPantry: ImageView
    private lateinit var ingredbtn: ImageView






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_bar)

        btnPantry = findViewById<ImageView>(R.id.btnPantry)
        ingredbtn = findViewById<ImageView>(R.id.ingredbtn)


        btnPantry.setOnClickListener {
            val intent = Intent(this, MainActivityPantry::class.java)
            startActivity(intent)
        }


        ingredbtn.setOnClickListener {
            val intent = Intent(this, MainActivityIngredient::class.java)
            startActivity(intent)
        }
    }
}