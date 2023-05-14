package com.example.missionmad2.Testing

object PantryUtil {

    private val existingpantry= listOf("friedriceS","eggs67")

    fun validatePantryInput(
        pantryname:String,
        pantryingredeints:String

    ):Boolean{
        if (pantryname.isEmpty()||pantryingredeints.isEmpty()){
            return false
        }
        if (pantryname in existingpantry){
            return false
        }
        if (pantryingredeints in existingpantry){
            return false
        }

        return true
    }
}