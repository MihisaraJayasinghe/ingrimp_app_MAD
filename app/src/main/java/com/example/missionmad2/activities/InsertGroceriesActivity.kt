package com.example.missionmad2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.missionmad2.models.groceryModel
import com.example.missionmad2.R

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference

class InsertGroceriesActivity : AppCompatActivity() {




    private lateinit var storageRef: StorageReference
    private lateinit var firebaseFirestore: FirebaseFirestore
    private lateinit var etEmpName: EditText
    private lateinit var selectImageBtn: Button
    private lateinit var etEmpAge: EditText
    private lateinit var etEmpIns: EditText
    private lateinit var btnSaveData: Button
    private lateinit var uploadBtn :Button



    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)








        //setting variables
        setContentView(R.layout.activity_groceries_insert)

        etEmpName = findViewById(R.id.etEmpName)
        etEmpAge = findViewById(R.id.etEmpAge)
        btnSaveData = findViewById(R.id.btnSaveData)


        dbRef = FirebaseDatabase.getInstance().getReference("Groceries")

        btnSaveData.setOnClickListener{
            saveEmployeeData()
        }





    }


    //saving data


    private fun saveEmployeeData() {
        //get data
        val empName = etEmpName.text.toString()
        val empAge  = etEmpAge.text.toString()


        val empId = dbRef.push().key!!
        val employee = groceryModel(empId, empName, empAge)

        if(empName.isEmpty()){
            etEmpName.error = "Please fill this"
        }

        if(empAge.isEmpty()){
            etEmpAge.error = "Please fill this"
        }





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