package com.example.madui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class pantry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantry)


        val grocerlyListBtn = findViewById<ImageView>(R.id.grocerlyListBtn)

        grocerlyListBtn.setOnClickListener {
            val Intent = Intent(this, grocery_list::class.java)
            startActivity(Intent)
        }

        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener{
            val Intent = Intent(this,sidescoller::class.java)
            startActivity(Intent)

        }




    }
}