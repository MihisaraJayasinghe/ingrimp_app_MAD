package com.example.missionmad2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.missionmad2.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivityGrocerieslist : AppCompatActivity() {

    private lateinit var btnInsertData: Button
    private lateinit var btnFetchData: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groceries_main)

        //database refernce
        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()
        btnInsertData = findViewById(R.id.btnInsertData)
        btnFetchData = findViewById(R.id.btnFetchData)

        //directing to the insert
        btnInsertData.setOnClickListener {
            val intent = Intent(this, InsertGroceriesActivity::class.java)
            startActivity(intent)
        }


        //directing to fetch

        btnFetchData.setOnClickListener {
            val intent = Intent(this, GroceriesFetchActivity::class.java)
            startActivity(intent)
        }

    }
}