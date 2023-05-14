package com.example.missionmad2.Testing

object RecipeUtil {

    private val existingrecipe= listOf("friedrice","eggs67","fry the fench fries")

    fun validateRecipeInput(
        recipename:String,
        recipeingredeints:String,
        instructions:String
    ):Boolean{
        if (recipename.isEmpty()||recipeingredeints.isEmpty()||instructions.isEmpty()){
            return false
        }
        if (recipename in existingrecipe){
            return false
        }
        if (recipename in existingrecipe){
            return false
        }
        if (recipename in existingrecipe){
            return false
        }
        return true
    }

}