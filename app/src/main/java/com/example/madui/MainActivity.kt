package com.example.madui

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        setContentView(R.layout.create_account)

        val pantry_nav_icon = findViewById<ImageView>(R.id.pantry_nav_icon)

        pantry_nav_icon.setOnClickListener{
            val Intent = Intent(this,pantry::class.java)
            startActivity(Intent)

        }




    }


}