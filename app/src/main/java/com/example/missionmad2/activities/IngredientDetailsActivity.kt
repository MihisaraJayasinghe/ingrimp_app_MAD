package com.example.missionmad2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.missionmad2.R
import com.example.missionmad2.models.IngredientModel
import com.google.firebase.database.FirebaseDatabase

class IngredientDetailsActivity : AppCompatActivity() {

    private lateinit var tvEmpId: TextView
    private lateinit var tvEmpName: TextView
    private lateinit var tvEmpAge: TextView
    private lateinit var btnUpdate:Button
    private lateinit var btnDelete:Button
    private lateinit var btnPantry: ImageView
    private lateinit var ingredbtn: ImageView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_details)
        btnPantry = findViewById<ImageView>(R.id.btnPantry)
        ingredbtn = findViewById<ImageView>(R.id.ingredbtn)
        initView()
        setValuesToViews()

        //update dialog

        btnUpdate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("empId").toString(),
                intent.getStringExtra("empName").toString(),
                intent.getStringExtra("empAge").toString()

            )
        }

        //delete

        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("empId").toString()
            )
        }



        btnPantry.setOnClickListener {
            val intent = Intent(this, MainActivityPantry::class.java)
            startActivity(intent)
        }


        ingredbtn.setOnClickListener {
            val intent = Intent(this, MainActivityIngredient::class.java)
            startActivity(intent)
        }


    }

    private fun deleteRecord(
        id: String
    ){
        //Toast messages for acknowledgement
        val dbRef=FirebaseDatabase.getInstance().getReference("Ingredient").child(id)
        val mTask =dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this, "Ingredient data deleted",Toast.LENGTH_LONG).show()

            val intent = Intent( this,IngredientFetchActivity::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener { error ->
            Toast.makeText(this, "Deleting Err ${error.message}",Toast.LENGTH_LONG).show()
        }
    }
    private fun initView(){


        tvEmpName = findViewById(R.id.tvEmpName)
        tvEmpAge = findViewById(R.id.tvEmpAge)

        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)

    }

    //setting values for views
    private fun setValuesToViews(){
        tvEmpId.text = intent.getStringExtra("empId")
        tvEmpName.text = intent.getStringExtra("empName")
        tvEmpAge.text = intent.getStringExtra("empAge")



    }

    private fun openUpdateDialog(
        empId: String,
        empName: String,
        empAge:String,


        ){

        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.update_dialog_ingredient,null)

        mDialog.setView(mDialogView)

       val etEmpName = mDialogView.findViewById<EditText>(R.id.etEmpName)
        val etEmpAge = mDialogView.findViewById<EditText>(R.id.etEmpAge)
        val btnUpdateData  =mDialogView.findViewById<Button>(R.id.btnUpdateData)

        etEmpName.setText(intent.getStringExtra("empName").toString())
        etEmpAge.setText(intent.getStringExtra("empAge").toString())

        mDialog.setTitle("Updating $empName Record")

        val alertDialog=mDialog.create()
        alertDialog.show()

        // using update button
        btnUpdateData.setOnClickListener {
            updateEmpData(
                empId,
                etEmpName.text.toString(),
                etEmpAge.text.toString(),


            )
            Toast.makeText(applicationContext,"Ingredient data updated",Toast.LENGTH_LONG).show()

            tvEmpName.text=etEmpName.text.toString()
            tvEmpAge.text=etEmpAge.text.toString()

            alertDialog.dismiss()
        }


    }
    private fun updateEmpData(
        id: String,
        name: String,
        age: String,

    ){
        val dbRef= FirebaseDatabase.getInstance().getReference("Ingredient").child(id)
        val empInfo =IngredientModel(id,name,age)
        dbRef.setValue(empInfo)
    }
}