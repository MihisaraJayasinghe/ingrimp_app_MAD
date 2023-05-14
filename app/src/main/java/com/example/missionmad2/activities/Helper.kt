package com.example.missionmad2.activities

import android.content.Context
import android.content.Intent
import android.widget.Toast

fun Context.Toast(message:String) =
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()


fun Context.login():Intent{
    return Intent(this,HomeActivity::class.java).apply{
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

    }

}