package com.example.missionmad2.Testing

object GroceryUtil {

    private val existingGroceries= listOf("rice","dhal")


    fun validateGroceryInputs(
        groceryitemname:String,
        groceryamount:String
    ):Boolean{
        if (groceryitemname.isEmpty()||groceryamount.isEmpty()){
            return false
        }
        if (groceryitemname in existingGroceries){
            return false
        }
        return true
    }

}