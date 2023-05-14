package com.example.missionmad2.Testing

object IngredientUtil {


    private val existingingred= listOf("fish","100kg")

    fun validateIngredients(
        ingname:String,
        ingamount:String
    ):Boolean{
        if (ingname.isEmpty()||ingamount.isEmpty()){
            return false
        }
        if (ingname in existingingred){
            return false
        }
        if (ingamount in existingingred){
            return false
        }

        return true
    }
}