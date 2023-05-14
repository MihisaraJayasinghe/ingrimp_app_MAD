package com.example.missionmad2.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.missionmad2.models.IngredientModel
import com.example.missionmad2.R

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference

class InsertIngredientActivity : AppCompatActivity() {



    private lateinit var storageRef: StorageReference
    private lateinit var firebaseFirestore: FirebaseFirestore

    private lateinit var etEmpName: EditText
    private lateinit var selectImageBtn: Button
    private lateinit var etEmpAge: EditText
    private lateinit var etEmpIns: EditText
    private lateinit var btnSaveData: Button
    private lateinit var uploadBtn :Button
    private lateinit var recipbtn: ImageView
    private lateinit var btnPantry: ImageView
    private lateinit var ingredbtn: ImageView
    private lateinit var btngrocerylist: ImageView



    private lateinit var dbRef : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.activity_ingredient_insert)
        btnPantry = findViewById<ImageView>(R.id.btnPantry)
        ingredbtn = findViewById<ImageView>(R.id.ingredbtn)
        btngrocerylist = findViewById<ImageView>(R.id.btngrocerylist)
        etEmpName = findViewById(R.id.etEmpName)
        etEmpAge = findViewById(R.id.etEmpAge)
        btnSaveData = findViewById(R.id.btnSaveData)
        recipbtn = findViewById<ImageView>(R.id.recipbtn)


        //database referencing
        dbRef = FirebaseDatabase.getInstance().getReference("Ingredient")


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

        recipbtn.setOnClickListener {
            val intent = Intent(this, MainActivityRecipe::class.java)
            startActivity(intent)
        }

        btnSaveData.setOnClickListener{
            saveEmployeeData()
        }


    }




    private fun saveEmployeeData() {
        //get data
        val empName = etEmpName.text.toString()
        val empAge  = etEmpAge.text.toString()


        val empId = dbRef.push().key!!
        val employee = IngredientModel(empId, empName, empAge)


        //validations
        if(empName.isEmpty()){
            etEmpName.error = "Please fill this"
        }

        if(empAge.isEmpty()){
            etEmpAge.error = "Please fill this"
        }




        //auto clear after insertion
        dbRef.child(empId).setValue(employee)
            .addOnCompleteListener{
                Toast.makeText(this,"Data inserted successfully ", Toast.LENGTH_LONG).show()
                etEmpName.text.clear()
                etEmpAge.text.clear()

            }.addOnFailureListener{err ->
                Toast.makeText(this,"Data insertion unsuccessfull ", Toast.LENGTH_LONG).show()

            }

    }
}