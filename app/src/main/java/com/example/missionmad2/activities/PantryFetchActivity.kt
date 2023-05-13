package com.example.missionmad2.activities



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.missionmad2.R
import com.example.missionmad2.adapters.PantryAdapter
import com.example.missionmad2.models.pantryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PantryFetchActivity : AppCompatActivity() {

    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var empList: ArrayList<pantryModel>
    private lateinit var dbRef:DatabaseReference
    private lateinit var btnPantry: ImageView
    private lateinit var ingredbtn: ImageView
    private lateinit var btngrocerylist: ImageView
    private lateinit var recipbtn: ImageView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantry_fetch)

        empRecyclerView = findViewById(R.id.rvEmp)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)
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


        empList= arrayListOf<pantryModel>()

        getEmployeesData()
    }

    private fun getEmployeesData(){
        empRecyclerView.visibility= View.GONE
        tvLoadingData.visibility=View.VISIBLE

        dbRef=FirebaseDatabase.getInstance().getReference("Pantry")

        dbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if(snapshot.exists()){
                    for(empSnap in snapshot.children){
                        val empData=empSnap.getValue(pantryModel::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter=PantryAdapter(empList)
                    empRecyclerView.adapter=mAdapter


                    mAdapter.setOnItemClickListener(object : PantryAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@PantryFetchActivity, PantryDetailsActivity ::class.java)

                            //put extras
                            intent.putExtra("empId", empList[position].empId)
                            intent.putExtra("empName", empList[position].empName)
                            intent.putExtra("empAge", empList[position].empAge)


                            startActivity(intent)
                        }

                    })
                    empRecyclerView.visibility= View.VISIBLE
                    tvLoadingData.visibility= View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })



    }
}