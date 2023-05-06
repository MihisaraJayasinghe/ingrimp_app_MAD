package com.example.missionmad2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.missionmad2.R
import com.example.missionmad2.models.RecipeModel


class EmpAdapter (private val empList: ArrayList<RecipeModel>) :
    RecyclerView.Adapter<EmpAdapter.ViewHolder>(){

    private lateinit var mListner: onItemClickListener

    interface  onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListner: onItemClickListener){
        mListner = clickListner
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recipe_list_item,parent, false)
        return ViewHolder(itemView , mListner)

    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val currentEmp = empList[position]
        holder.tvEmpName.text=currentEmp.empName

    }

    override fun getItemCount(): Int {
        return empList.size
    }


    class ViewHolder(itemView: View, clickListner: onItemClickListener): RecyclerView.ViewHolder(itemView){

        val tvEmpName:TextView =itemView.findViewById(R.id.tvEmpName)

        init {
            itemView.setOnClickListener{
                clickListner.onItemClick(adapterPosition)
            }
        }

    }



}
